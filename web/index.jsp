<%@ page import="java.util.Locale" %>
<%@ include file="jspf/header.jspf" %>
<%-- При первом запуске очищаем все в web/xml/ --%>
<%!
    int deleteConstat = 0;
    void purgeDirectory(File dir) {
        try{
            for (File file: dir.listFiles()) {
                if (file.isDirectory()){
                    purgeDirectory(file);
                }
                file.delete();
            }
        }
        catch (NullPointerException e){
            System.out.println("Ошибка при удалении: " + e);
        }
    }
%>
<%
    if (deleteConstat == 0){
        File dir = new File("web/xml/");
        purgeDirectory(dir);
        deleteConstat++;
    }
%>
Hello
<%@ include file="jspf/footer.jspf" %>

