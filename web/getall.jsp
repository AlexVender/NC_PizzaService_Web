<%@ page import="unc.group16.controller.interfaces.Manager" %>
<%@ page import="unc.group16.controller.managers.oracle.OracleManagerFactory" %>
<%@ page import="unc.group16.data.annotations.DisplayName" %>
<%@ page import="unc.group16.data.interfaces.TableRecord" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page import="java.util.Objects" %>

<%@ include file="jspf/header.jspf" %>
<form method="get">
    <select name="table">
        <%
            for (String TABLE_NAME : TABLE_NAMES) {
        %>
        <option<%=Objects.equals(request.getParameter("table"), TABLE_NAME) ? " selected" : ""%>>
            <%=TABLE_NAME%>
        </option>
        <%
            }
        %>
    </select>
    <input type="submit" value="Query">
</form><br>

<table>
    <%
        OracleManagerFactory factory = new OracleManagerFactory();
        try {
            Manager manager = factory.getManager(request.getParameter("table"));
            TableRecord records[] = manager.readAll();
            if (records == null || records.length == 0) {
                out.print("Table is empty");
                throw new RuntimeException();
            }
            for (int i = 0; i < records[0].getColumnsCnt(); i++) {
                out.print("<th>" + records[0].getDisplayColumnName(i) + "</th>");
            }
            out.print("</tr>");

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
        } catch (NullPointerException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</table>
<%@ include file="jspf/footer.jspf" %>
