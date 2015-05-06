<%-- 
    Document   : AdminIndexPage
    Created on : 05 6, 15, 3:21:11 PM
    Author     : asi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String type = request.getParameter("type");

            out.println(type);
        %>   
    </body>
</html>
