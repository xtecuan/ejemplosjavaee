<%-- 
    Document   : index
    Created on : 04-09-2013, 09:54:08 PM
    Author     : Administrador
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP 2 Ejemplos</title>
    </head>
    <body>
        <h1>JSP 2 Ejemplos</h1>
        
        <form name="form1" action="procesar_formulario.jsp" method="POST">
            
            <table border="1" cellspacing="1" cellpadding="1">
                
                <tbody>
                    <tr>
                        <td>Nombres</td>
                        <td><input type="text" name="nombres" value="" /></td>
                    </tr>
                    <tr>
                        <td>Apellidos</td>
                        <td><input type="text" name="apellidos" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="cancelar" /></td>
                        <td><input type="submit" value="Procesar" /></td>
                    </tr>
                </tbody>
            </table>

            
        </form>
        
        <a href="reporte_sql_tags.jsp">reporte</a>
        
    </body>
</html>
