<%-- 
    Document   : procesar_formulario
    Created on : 04-09-2013, 10:02:19 PM
    Author     : Administrador
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado operación</title>
    </head>
    <body>
        <h1>Resultado operación</h1>

        <ul>

            <li><c:out value="${param.nombres}"/></li>
            <li><c:out value="${param.apellidos}"/></li>
        </ul>


        <c:if test="${param.nombres eq 'Julian'}" var="compararJulian">

            <c:out value="Hola Julian"/>

        </c:if>


        <c:if test="${not compararJulian}">

            <c:out value="Hola ${param.nombres} ${param.apellidos}"/>

        </c:if>


        <ul>

            <c:forEach begin="1" end="10" step="1" var="i">

                <li> Iteración ${i}</li>

            </c:forEach>
        </ul>


        <jsp:useBean id="helper" scope="page" class="beans.ListHelper" />

        <ul>
            <c:forEach  items="${helper.nombres}" var="nombre1">


                <li>${nombre1}</li>

            </c:forEach>
        </ul>

        <c:forTokens delims="," items="julian,julio,jonatan" var="j">

            ${j}<br>

        </c:forTokens>

        <c:set var="contador" scope="session" value="100"/>
        
        
        <a href="verificar_contador_session.jsp">Ver variable contador</a>

    </body>
</html>
