<%-- 
    Document   : index
    Created on : Jan 12, 2013, 11:37:55 AM
    Author     : xtecuan
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <%

            Date fecha = new Date();


        %>

        <h1 style="color: aquamarine"> <%=fecha%> </h1>

        <ul>

            <%

                for (int i = 1; i <= 100; i++) {

            %>

            <li><%=i%></li>

            <%                        }

            %>
        </ul>

    </body>
</html>
