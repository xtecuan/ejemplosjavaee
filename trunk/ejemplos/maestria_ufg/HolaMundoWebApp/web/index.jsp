<%-- 
    Document   : index
    Created on : 04-05-2013, 06:15:59 PM
    Author     : xtecuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="${pageContext.servletContext.contextPath}/hola">Ir a Hola Mundo Servlet</a>
        <br>
        <a href="app/capturaAlumnos.jsp">Captura de Alumnos</a>
    </body>
</html>
