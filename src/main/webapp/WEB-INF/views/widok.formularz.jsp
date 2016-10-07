<%-- 
    Document   : widok.formularz
    Created on : 2016-09-06, 10:50:16
    Author     : pawlik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <sec:authentication property="principal" />
      <sec:authorize access="hasRole('ROLE_USER')">
            Informacja tylko dla zalogowanych
      </sec:authorize>
            <br><br>
            <p>samochod: <spring:message code="car" /></p>
            <br>
            <br>
            <a href="/cymes/formularz?language=en">Amerykański</a>
            <a href="/cymes/formularz?language=pl">Polski</a>
            
   <form:form action="/cymes/formularz" modelAttribute="form" method="post">

        Name: 
        <form:input path="name" id="name"></form:input>
        <c:if test="${pageContext.request.method=='POST'}"><form:errors path="name" /></c:if>
        <br />

        <input type="submit" value="Wyślij formularz" />
</form:form>
    </body>
</html>
