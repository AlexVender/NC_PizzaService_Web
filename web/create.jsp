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
    <input type="submit" value="Create">
</form><br>
<%@ include file="jspf/footer.jspf" %>