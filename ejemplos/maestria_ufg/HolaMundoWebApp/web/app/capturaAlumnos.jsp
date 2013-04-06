<%-- 
    Document   : capturaAlumnos
    Created on : 04-05-2013, 06:32:01 PM
    Author     : xtecuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Captura Alumnos</title>
    </head>
    <body>
        <h1>Entrada de datos de alumnos</h1>
        
        <form name="forma1" action="${pageContext.servletContext.contextPath}/procesar.ufg?guardar=0" method="POST">
        
            <table border="1" width="800" cellspacing="1" cellpadding="1">
                <thead>
                    <tr>
                        <th>Descripción</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Carnet:</td>
                        <td><input type="text" name="carnet" value="" /></td>
                    </tr>
                    <tr>
                        <td>Nombres:</td>
                        <td><input type="text" name="nombres" value="" /></td>
                    </tr>
                    <tr>
                        <td>Apellidos:</td>
                        <td><input type="text" name="apellidos" value="" /></td>
                    </tr>
                    <tr>
                        <td>Correo:</td>
                        <td><input type="text" name="correo" value="" /></td>
                    </tr>
                    <tr>
                        <td>Fecha Nacimiento: (dd/MM/yyyy)</td>
                        <td><input type="text" name="fechanac" value="" /></td>
                    </tr>
                    
                      <tr>
                          <td><input type="reset" value="Borrar" /></td>
                          <td><input type="submit" value="Enviar" /></td>
                    </tr>
                </tbody>
            </table>

        
        </form>
        
    </body>
</html>
