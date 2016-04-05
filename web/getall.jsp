<%@ page import="unc.group16.controller.interfaces.Manager" %>
<%@ page import="unc.group16.controller.managers.oracle.OracleManagerFactory" %>
<%@ page import="unc.group16.data.interfaces.TableRecord" %>
<%@ page import="javax.persistence.Column" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page import="java.util.Objects" %>

<%@ include file="jspf/header.jspf" %>
<form method="get">
    <select name="table">
        <%
            for (String TABLE_NAME : TABLE_NAMES) {
        %>
        <option <%=Objects.equals(request.getParameter("table"), TABLE_NAME) ? "selected" : ""%>
                value="<%=TABLE_NAME%>"><%=TABLE_NAME%>
        </option>
        <%
            }
        %>
    </select>
    <input type="submit" value="Query">
</form><br><br>

<table>
    <%
        OracleManagerFactory factory = new OracleManagerFactory();
        try {
            Manager manager = factory.getManager(request.getParameter("table"));
            TableRecord records[] = manager.readAll();
            if (records.length == 0) {
                out.print("Table is empty");
                throw new RuntimeException();
            }
            Field[] fields = records[0].getClass().getDeclaredFields();
            for (Field field : fields) {
                Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
                out.print("<td>");
                out.print(columnAnnotation.name());
                out.print("</td>");
            }
            out.print("</tr>");

            for (TableRecord record : records) {
                if (record == null) {
                    continue;
                }
                out.print("<tr>");
                for (Field field : fields) {
                    field.setAccessible(true);
                    Object data = field.get(record);

                    out.print("<td>");
                    out.print((field.get(record) != null) ? field.get(record) : "");
                    out.print("</td>");
                }
                out.print("</tr>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</table>
<%@ include file="jspf/footer.jspf" %>
