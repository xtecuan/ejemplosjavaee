<%-- 
    Document   : principal
    Created on : 04-10-2013, 08:35:20 PM
    Author     : xtecuan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina principal Sistema de Alumnos</title>
        <%@include file="/WEB-INF/jspf/estilos.jspf" %>
    </head>
    <body>
        <h1>Sistema de Alumnos pagina Principal</h1>
        <hr>
        <h6>Bienvenido al Sistema: <c:out value="${usuariologin.login}"/></h6>

        <table border="1" cellspacing="1" cellpadding="1">

            <tbody>
                <tr>
                    <td>Listado de Alumnos</td>
                    <c:url value="/find.ufg" var="findurl">

                        <c:param name="find" value="all"/>
                        <c:param name="errorPage" value="/app/principal.jsp"/>
                        <c:param name="viewPage" value="/app/alumnosGrid.jsp"/>

                    </c:url>
                    <td><a href="${findurl}">Ir</a></td>
                </tr>
                <tr>
                    <td>Agregar Alumno</td>
                    <td><a href="alumnosCrear.jsp">Ir</a></td>
                </tr>
                <tr>
                    <td>Buscar Alumno</td>
                    <td><a href="alumnosBuscar.jsp">Ir</a></td>
                </tr>
            </tbody>
        </table>


    </body>
</html>
