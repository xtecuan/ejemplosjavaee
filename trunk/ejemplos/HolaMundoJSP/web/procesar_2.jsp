<%-- 
    Document   : procesar
    Created on : Jan 19, 2013, 11:44:43 AM
    Author     : xtecuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de usuario</title>
    </head>
    <body>
        <jsp:useBean id="pajarito" scope="page" class="beans.Usuario" />


        <jsp:setProperty name="pajarito" property="*" />

        <table border="1" width="800" cellspacing="1" cellpadding="1">

            <tbody>
                <tr>
                    <td>Nombres:</td>
                    <td>${pajarito.nombres}</td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td>${pajarito.apellidos}</td>
                </tr>

                <tr>
                    <td>Apellidos</td>
                    <td>${pajarito.dia} / ${pajarito.mes} / ${ pajarito.annio }</td>
                </tr>

            </tbody>
        </table>



    </body>
</html>
