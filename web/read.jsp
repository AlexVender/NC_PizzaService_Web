<%@ page import="unc.group16.controller.interfaces.Manager" %>
<%@ page import="unc.group16.controller.managers.oracle.OracleManagerFactory" %>
<%@ page import="unc.group16.data.interfaces.TableRecord" %>
<%@ page import="javax.persistence.Column" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    final String[] TABLE_NAMES = {
            "Drink", "Pizza", "Ingredient", "MeasurementUnit", "Order", "Pizza", "Sauce"
    };
%>

<%
    final String ID_STR = request.getParameter("id");
%>

<html>
<head>
    <title>Pizza Service</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="wrap">
        <div class="menu">
            <%@ include file="jspf/menu.jspf" %>
        </div>
        <div class="content">
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
                ID:
                <input type="text" name="id" value="<%=ID_STR != null ? ID_STR : "" %>">
                <input type="submit" value="Query">
            </form><br><br>

            <table>
<%
    OracleManagerFactory factory = new OracleManagerFactory();
    try {
        Long id = Long.parseLong(ID_STR);

        Manager manager = factory.getManager(request.getParameter("table"));
        TableRecord record = manager.read(id);
        if (record != null) {
            Field[] fields = record.getClass().getDeclaredFields();
            for (Field field : fields) {
                Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
                field.setAccessible(true);

                out.print("<tr><td>");
                out.print(columnAnnotation.name());
                out.print("</td><td>");
                out.print(field.get(record));
                out.print("<tr></tr>");
            }
        }
    } catch (Exception e) {

    }
%>
            </table>
        </div>
    </div>
</body>
</html>