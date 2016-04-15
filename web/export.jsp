<%@ page import="java.util.Objects" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<%@ include file="jspf/header.jspf" %>
<form action="export" method="post">
  &nbsp;Choose table to export:<br>
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
  <span class="error">${messages.error}</span>
  <p>
    <input type="submit" name="export" value="Export">
    <span class="success">${messages.success}</span>
  </p>
</form><br><br>

<%@ include file="jspf/footer.jspf" %>
