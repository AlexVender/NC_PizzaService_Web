<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="jspf/header.jspf" %>

<form name="sendform" enctype="multipart/form-data"action="import" method="post">
Выберите файл для импорта в БД: <input type="File" name="file_send"> <br>
<p>
  <input type="submit" value="Импортировать">
</p>
</form>
<%@ include file="jspf/footer.jspf" %>