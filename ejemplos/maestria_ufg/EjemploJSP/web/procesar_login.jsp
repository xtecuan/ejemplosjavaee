<%-- 
    Document   : procesar_login
    Created on : 04-08-2013, 07:36:47 PM
    Author     : xtecuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesar Login</title>
    </head>
    <body>

        <%!            private String userSys = "admin";
            private String passwdSys = "adminadmin";
        %>


        <%

            String outcome = "login.jsp";

            String user = request.getParameter("usuario");
            String clave = request.getParameter("clave");

            if (user != null && user.length() > 0 && clave != null && clave.length() > 0) {

                boolean result = user.equals(userSys) && clave.equals(passwdSys);

                if (result) {
                    outcome = "index.jsp";
                } else {

                    session.setAttribute("error", "Usuario y/o clave invalidos!!!");
                }
            }


        %>

        <jsp:forward page="<%=outcome%>"/>

    </body>
</html>
