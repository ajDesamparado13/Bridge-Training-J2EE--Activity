<%-- 
    Document   : user
    Created on : 05 8, 15, 1:56:54 PM
    Author     : asi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>    
    <body>
         <div>
            <form method="POST" action="home">
                <p>
                    Username: <input type="text" name="username" value="<c:out value="${user.username}"/>"><br>
                    Password: <input type="password" name="password" value="<c:out value="${user.password}"/>">
                    <input type="submit" value="login">                    
                </p>
            </form>
        </div>
    </body>
</html>
