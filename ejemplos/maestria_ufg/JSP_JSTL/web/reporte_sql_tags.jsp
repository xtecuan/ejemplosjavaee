<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : reporte_sql_tags
    Created on : 04-09-2013, 10:56:13 PM
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de Alumnos</title>
    </head>
    <body>
        <h1>Reporte de Alumnos</h1>

        <sql:query var="result" dataSource="jdbc/alumnos">
            select * from alumnos
        </sql:query>

        <table border="1">
            <!-- column headers -->
            <tr>
            <c:forEach var="columnName" items="${result.columnNames}">
                <th><c:out value="${columnName}"/></th>
            </c:forEach>
        </tr>
        <!-- column data -->
        <c:forEach var="row" items="${result.rowsByIndex}">
            <tr>
            <c:forEach var="column" items="${row}">
                <td><c:out value="${column}"/></td>
            </c:forEach>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
