<%-- 
    Document   : index
    Created on : Jan 19, 2013, 11:27:03 AM
    Author     : xtecuan
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de captura de informacion de usuario</title>
    </head>
    <body>
        <h1>Informacion del usuario:</h1>

        <form name="formulario1" action="procesar_2.jsp" method="POST">


            <table border="1" width="800" cellspacing="1" cellpadding="1">
                <thead>
                    <tr>
                        <th>Label</th>
                        <th>Componente</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nombres:</td>
                        <td><input type="text" name="nombres" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Apellidos:</td>
                        <td><input type="text" name="apellidos" value="" /></td>
                    </tr>
                    <tr>

                        <td>
                            Fecha de Nacimiento:

                        </td>

                        <td>

                            <table border="1"  cellspacing="1" cellpadding="1">

                                <tbody>
                                    <tr>
                                        <td>Dia: 
                                            <select name="dia">
                                                <option value="0">Seleccione</option>

                                                <%

                                                    for (int i = 1; i <= 31; i++) {

                                                        out.println("<option value=\"" + i + "\">" + i + "</option>");

                                                    }

                                                %>

                                            </select>

                                        </td>
                                        <td>Mes:

                                            <select name="mes">
                                                <option value="0">Seleccione</option>

                                                <c:forEach begin="1" end="12" step="1" var="j" varStatus="jx">

                                                    <option value="${j}">
                                                        <c:out value="${j}"/>
                                                    </option>

                                                </c:forEach>

                                            </select>

                                        </td>
                                        <td>Annio:
                                        
                                            <select name="annio">
                                                <option value="0">Seleccione</option>

                                                <%

                                                    Date fecha = new Date();
                                                    
                                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                                                    
                                                    String annioStr = sdf.format(fecha);
                                                    int annio = Integer.valueOf(annioStr);
                                                
                                                
                                                    for (int i = 1900; i <= annio; i++) {

                                                        %>
                                                        
                                                        <option value="<%=i%>"><%=i%></option>
                                                        
                                                        <%

                                                    }

                                                %>

                                            </select>
                                        
                                        
                                        </td>
                                    </tr>
                                </tbody>
                            </table>


                        </td>

                    </tr>

                    <tr>
                        <td><input type="reset" value="Limpiar" /></td>
                        <td><input type="submit" value="Saludar Usuario" /></td>
                    </tr>
                </tbody>
            </table>



        </form>


    </body>
</html>
