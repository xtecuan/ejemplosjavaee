<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : Jan 26, 2013, 10:48:56 AM
    Author     : xtecuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda Alumnos</title>
        
        <link href="${pageContext.request.servletContext.contextPath}/css/estilos_ugb.css" rel="stylesheet" media="screen" type="text/css"/>
        
    </head>
    <body>
        <h1>Ingrese el nombre del alumno a buscar</h1>

        <form action="busqueda.ugb" method="POST">


            Nombre del alumno <input type="text" name="nombresLike" value="" size="50" />

            <br>
            <input type="submit" value="Buscar" />

        </form>


        <br><br>


        <table border="1" width="1" cellspacing="1" cellpadding="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Carnet</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Correo</th>
                    <th>Fecha Nac.</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="alumno" items="${respuesta}">

                    <tr>
                        <td>${alumno.id}</td>
                        <td>${alumno.carnet}</td>
                        <td>${alumno.nombres}</td>
                        <td>${alumno.apellidos}</td>
                        <td>${alumno.correo}</td>
                        <td>${alumno.fechanac}</td>
                    </tr>

                    <c:remove scope="session" var="respuesta"/>
                </c:forEach>


                <c:if test="${not empty error}">
                    <tr>
                        <td colspan="6">${error}</td>
                    </tr>

                    <c:remove scope="session" var="error"/>

                </c:if>


            </tbody>
        </table>


    </body>
</html>
