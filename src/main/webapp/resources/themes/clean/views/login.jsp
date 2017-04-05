<%-- 
    Document   : login
    Created on : 2016-09-07, 13:58:43
    Author     : pawlik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LOGIN</h1>
        <c:set var="loginUrl"><c:url value="/login"/></c:set>
        <form method="post" action="${loginUrl}">
           login <input type="text" name="email" />
            hasło <input type="password" name="password" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Zaloguj" />
        </form>
    </body>
</html>
