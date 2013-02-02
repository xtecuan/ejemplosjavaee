<%-- 
    Document   : index
    Created on : Feb 2, 2013, 9:34:52 AM
    Author     : xtecuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Base de datos de alumnos</title>
        <link href="${pageContext.request.servletContext.contextPath}/css/estilos_ugb.css" rel="stylesheet" media="screen" type="text/css"/>
    </head>
    <body>
        <h1>Sistema de gestion de alumnos</h1>
        
        
        <table border="1" width="800" cellspacing="1" cellpadding="1">
            <thead>
                <tr>
                    <th>Opción</th>
                    <th>Enlace</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Busqueda de Alumnos</td>
                    <td><a href="busquedaAlumnos.jsp"><img src="${pageContext.request.servletContext.contextPath}/images/arrow.jpg" width="64" height="64" alt="arrow"/>
                        </a></td>
                </tr>
                <tr>
                    <td>Ingreso de Alumnos</td>
                    <td><a href="ingresoAlumnos.jsp"><img src="${pageContext.request.servletContext.contextPath}/images/arrow.jpg" width="64" height="64" alt="arrow"/></a></td>
                </tr>
                <tr>
                    <td>Listado de Alumnos</td>
                    <td><a href="listadoAlumnos.jsp"><img src="${pageContext.request.servletContext.contextPath}/images/arrow.jpg" width="64" height="64" alt="arrow"/></a></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
