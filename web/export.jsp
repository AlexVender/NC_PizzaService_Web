<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Export data</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrap">
  <div class="menu">
    <%@ include file="jspf/menu.jspf" %>
  </div>
  <div class="content">
    Choose table to export:<br>
    <form action="export" method="post">
      <select name="table">
        <option value="Client">Clients</option>
        <option value="Drink">Drinks</option>
        <option value="Ingredient">Ingredients</option>
        <option value="Measurement_unit">Measurement_units</option>
        <option value="Order">Orders</option>
        <option value="Orders_drink">Orders_drinks</option>
        <option value="Orders_pizza">Orders_pizzas</option>
        <option value="Orders_sauce">Orders_sauces</option>
        <option value="Pizza">Pizzas</option>
        <option value="Pizzas_ingredient">Pizzas_ingredients</option>
        <option value="Sauce">Sauces</option>
      </select>
      <span class="error">${messages.error}</span>
      <p>
        <input type="submit" name="export" value="Export">
        <span class="success">${messages.success}</span>
      </p>
    </form><br><br>
  </div>
</div>
</body>
</html>
