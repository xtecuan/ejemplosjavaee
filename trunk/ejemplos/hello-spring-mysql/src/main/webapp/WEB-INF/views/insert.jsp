<%-- 
    Document   : insert
    Created on : 05-18-2013, 10:56:22 AM
    Author     : xtecuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de insert</title>
    </head>
    <body>
        <h1>Mantto Estados</h1>
        
        <form name="form1" action="${pageContext.servletContext.contextPath}/insert.do" method="post">
            
           
                
                <table border="1" width="600" cellspacing="1" cellpadding="1">
                   
                    <tbody>
                        <tr>
                            <td>Id:</td>
                            <td> <input type="text" name="id" value="" /> </td>
                        </tr>
                        <tr>
                            <td> statecode: </td>
                            <td> <input type="text" name="statecode" value="" /> </td>
                        </tr>
                        <tr>
                            <td> name: </td>
                            <td> <input type="text" name="name" value="" /> </td>
                        </tr>
                    </tbody>
                </table>

                
            <input type="submit" value="Guardar" name="guardar" />
            
            
        </form>
    </body>
</html>
