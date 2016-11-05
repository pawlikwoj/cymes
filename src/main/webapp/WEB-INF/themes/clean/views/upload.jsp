<%-- 
    Document   : upload
    Created on : 2016-09-16, 15:10:58
    Author     : pawlik
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form:form action="/cymes/upload" method="post" enctype="multipart/form-data" >
            <input type="file" name="plik" />
            <input type="submit" value="Wyślij formularz" />
        </form:form>
        
    
    </body>
</html>
