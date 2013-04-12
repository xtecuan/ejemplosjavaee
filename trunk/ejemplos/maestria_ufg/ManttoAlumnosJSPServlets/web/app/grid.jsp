<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1" cellspacing="1" cellpadding="1">
    <thead>
        <tr>
            <th>Id</th>
            <th>Carnet</th>
            <th>Nombres</th>
            <th>Apellidos</th>
            <th>Correo</th>
            <th>Fecha Nac</th>
        </tr>
    </thead>
    <tbody>

        <c:if test="${not empty respuesta}">

            <c:forEach items="${respuesta}" var="alumno">
                <tr>
                    <td>${alumno.id}</td>
                    <td>${alumno.carnet}</td>
                    <td>${alumno.nombres}</td>
                    <td>${alumno.apellidos}</td>
                    <td>${alumno.correo}</td>
                    <td>
                        <fmt:formatDate value="${alumno.fechanac}" pattern="dd/MM/yyyy"/>
                    </td>
                </tr>
            </c:forEach>

            <c:remove scope="session" var="respuesta"/>

        </c:if>

        <c:if test="${not empty errores}">

            <c:forEach items="${errores}" var="error">

                <tr>
                    <td colspan="6">${error}</td>
                </tr>

            </c:forEach>
            <c:remove scope="session" var="errores"/>
        </c:if>
    </tbody>
</table>