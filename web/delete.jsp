<%@ page import="unc.group16.controller.interfaces.Manager" %>
<%@ page import="unc.group16.controller.managers.oracle.OracleManagerFactory" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    final String[] TABLE_NAMES = {
            "Client", "Drink", "Ingredient", "MeasurementUnit", "Order", "Pizza", "Sauce"
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
            <input type="submit" value="Delete">
        </form><br>

            <%
                OracleManagerFactory factory = new OracleManagerFactory();
                try {
                    Long id = Long.parseLong(ID_STR);

                    Manager manager = factory.getManager(request.getParameter("table"));
                    if (manager.delete(id)) {
                        out.print("Successfuly deleated");
                    } else {
                        out.print("Record not found");
                    }
                } catch (Exception e) {
                    out.print("<br>");
                }
            %>
    </div>
</div>
</body>
</html>