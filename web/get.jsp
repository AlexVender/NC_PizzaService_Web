<%@ page import="unc.group16.controller.interfaces.Manager" %>
<%@ page import="unc.group16.controller.managers.oracle.OracleManagerFactory" %>
<%@ page import="unc.group16.data.interfaces.TableRecord" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page import="java.util.Objects" %>
<%
    final String ID_STR = request.getParameter("id");
%>

<%@ include file="jspf/header.jspf" %>
<form method="get">
    <table>
        <tr>
            <td>Table</td>
            <td>
                <select name="table">
                    <option selected value=""> -- Select -- </option>
                    <%
                        for (String TABLE_NAME : TABLE_NAMES) {
                    %>
                    <option <%=Objects.equals(request.getParameter("table"), TABLE_NAME) ? "selected" : ""%>>
                        <%=TABLE_NAME%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Whole</td>
            <td>
                <input type="checkbox" <%=request.getParameter("id")==null ? "checked" : ""%>
                       onclick="this.nextSibling.style.display=this.checked ?
                           document.getElementsByName('id')[0].setAttribute('disabled','') :
                           document.getElementsByName('id')[0].removeAttribute('disabled');">
            </td>
        </tr>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" value="<%=ID_STR != null ? ID_STR : "" %>" <%=request.getParameter("id")==null ? "disabled" : ""%>></td>
        </tr>
    </table>
    <input type="submit" value="Get">
</form>
    <%
        OracleManagerFactory factory = new OracleManagerFactory();
        try {
            if (ID_STR == null) {
                Manager manager = factory.getManager(request.getParameter("table"));
                TableRecord records[] = manager.readAll();
                if (records == null || records.length == 0) {
                    out.print("Table is empty");
                    throw new RuntimeException();
                }
                out.print("<hr><br><table class=\"result\">");
                for (int i = 0; i < records[0].getColumnsCnt(); i++) {
                    out.print("<th>" + records[0].getDisplayColumnName(i) + "</th>");
                }
                Field[] fields = records[0].getClass().getDeclaredFields();
                for (TableRecord record : records) {
                    if (record == null) {
                        continue;
                    }
                    out.print("<tr>");
                    for (Field field : fields) {
                        field.setAccessible(true);
                        Object data = field.get(record);
                        out.print("<td>" + ((data != null) ? data : "") + "</td>");
                    }
                    out.print("</tr>");
                }
                out.print("</table>");
            } else {
                Long id = Long.parseLong(ID_STR);

                Manager manager = factory.getManager(request.getParameter("table"));
                TableRecord record = manager.read(id);
                if (record != null) {
                    out.print("<hr><br><table class=\"result\">");
                    Field[] fields = record.getClass().getDeclaredFields();
                    int i = 0;
                    for (Field field : fields) {
                        field.setAccessible(true);
                        Object data = field.get(record);
%>
                        <tr>
                            <td><%= record.getDisplayColumnName(i++) %></td>
                            <td><%= (data != null) ? data : "" %></td>
                        </tr>
<%
                    }
                out.print("</table>");
                } else {
                    out.print("Record is not found");
                }
            }
        } catch (Exception e) {
        }
%>
<%@ include file="jspf/footer.jspf" %>
