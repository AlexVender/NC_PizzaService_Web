<%@ page import="unc.group16.controller.interfaces.Manager" %>
<%@ page import="unc.group16.controller.managers.oracle.OracleManagerFactory" %>
<%@ page import="unc.group16.data.annotations.DisplayName" %>
<%@ page import="unc.group16.data.interfaces.TableRecord" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.io.File" %>
<%
    final String ID_STR = request.getParameter("id");
%>

<%@ include file="jspf/header.jspf" %>
<form method="get">
    <select name="table">
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
    &nbsp;ID:
    <input type="text" name="id" value="<%=ID_STR != null ? ID_STR : "" %>">
    <input type="submit" value="Query">
</form><br><br>

<table>
    <%

        String currentDir = new File("").getAbsolutePath();

        System.out.println("4:" + currentDir);
        String currentDir2 = System.getProperty("user.dir");

        System.out.println("3:" + currentDir2);
        OracleManagerFactory factory = new OracleManagerFactory();
        try {
            Long id = Long.parseLong(ID_STR);

            Manager manager = factory.getManager(request.getParameter("table"));
            TableRecord record = manager.read(id);
            if (record != null) {
                Field[] fields = record.getClass().getDeclaredFields();
                int i = 0;
                for (Field field : fields) {
                    field.setAccessible(true);
                    Object data = field.get(record);

                    out.print("<tr><td>" + record.getDisplayColumnName(i++) + "</td><td>" +
                            ((data != null) ? data : "") + "<tr></tr>");
                }
            } else {
                out.print("Record is not found");
            }
        } catch (Exception e) {

        }
    %>
</table>
<%@ include file="jspf/footer.jspf" %>
