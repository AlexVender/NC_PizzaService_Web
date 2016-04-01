<%@ page import="unc.group16.data.entity.Drink" %>
<%@ page import="unc.group16.controller.interfaces.Manager" %>
<%@ page import="unc.group16.controller.managers.oracle.OracleDrinksManager" %>
<%@ page import="unc.group16.controller.managers.oracle.OracleOrdersManager" %>
<%@ page import="unc.group16.data.entity.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <option value="Drinks">Drinks</option>
                    <option value="Pizzas">Pizzas</option>
                </select>
                ID:
                <input type="text" name="id" value="">
                <input type="submit" value="Query">
            </form><br><br>

<%
    Manager<Order> manager = new OracleOrdersManager();
//    String stringID = request.getParameter("id");
    try {
        Long id = Long.parseLong("1");

        Order order = manager.read(Long.parseLong("1"));
        if (order != null) {
%>
            ID: <%=order.getId()%><br>
            CLNTID: <%=order.getClientId()%><br>
            OrderDate: <%=order.getOrderDate()%><br>
            DeliveryDate: <%=order.getDeliveryDate()%><br>
            DESCR: <%=order.getDescription()%><br>
<%
        }
    } catch (Exception e) {
    System.out.println("get_by_id failed" + e);
    }
%>

        </div>
    </div>
</body>
</html>