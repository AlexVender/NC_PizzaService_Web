<%@ page import="unc.group16.data.entity.*" %>
<%@ page import="unc.group16.controller.interfaces.Manager" %>
<%@ page import="unc.group16.controller.managers.oracle.*" %>
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
//    Manager<Order> manager = new OracleOrdersManager();
//    Order order = manager.read(1L);


//    System.out.println("ID: " + order2.getId());
//    System.out.println("CLNTID: " + order2.getClientId());
//    System.out.println("OrderDate: " + order2.getOrderDate());
//    System.out.println("DeliveryDate: " + order2.getDeliveryDate());
//    System.out.println("DESCR: " + order2.getDescription());
%>

            <%--<%=order == null%>--%>

        </div>
    </div>
</body>
</html>
