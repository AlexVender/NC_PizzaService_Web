<%@ page import="java.util.Objects" %>
<%@ page import="unc.group16.data.interfaces.TableRecord" %>
<%@ page import="unc.group16.controller.managers.oracle.OracleManagerFactory" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page import="javax.persistence.Column" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="unc.group16.controller.interfaces.Manager" %>
<%@ page import="javax.persistence.Id" %>

<%@ include file="jspf/header.jspf" %>
<form method="post" action="create.jsp">
    Table&nbsp;
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
    <input type="submit" value="Choose">
</form><br>


<%
    String tableName = request.getParameter("table");
    OracleManagerFactory factory = new OracleManagerFactory();
    try {
        TableRecord record = factory.getRecord(tableName);
        int columnsCnt = record.getColumnsCnt();

%>
<form method="post" action="create.jsp">
    <table>
        <%
            for (int i = 1; i < columnsCnt; i++) {
        %>
        <tr>
            <td><%=record.getDisplayColumnName(i)%></td>
            <td><input type="text" name="col<%=i%>" value=""></td>
        </tr>
        <%
            }
        %>
    </table>
    <br>
    <input type="hidden" name="table" value="<%=tableName%>"/>
    <input type="hidden" name="doCreate" value="true"/>
    <input type="submit" value="Create">
</form>
<%
        if (request.getParameter("doCreate") != null) {
            Field[] fields = record.getClass().getDeclaredFields();
            int k = 0;
            for (Field field : fields) {
                Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
                Id idAnnotation = field.getDeclaredAnnotation(Id.class);
                if (columnAnnotation != null && idAnnotation == null)  {
                    field.setAccessible(true);
                    Object data = request.getParameter("col" + ++k);
                    if (field.getType() == Long.class) {
                        data = Long.parseLong((String) data);
                    } else if (field.getType() == Number.class) {
                        data = Double.parseDouble((String) data);
                    }
                    field.set(record, data);
                }
            }

            Manager manager = factory.getManager(tableName);
            Long id = manager.create(record);
            if (id != null) {
                out.print("<br>Successful created with ID " + id);
            } else {
                out.print("<br>Error while creating");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>



<%@ include file="jspf/footer.jspf" %>