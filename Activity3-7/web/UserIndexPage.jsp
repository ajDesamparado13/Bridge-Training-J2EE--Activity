<%-- 
    Document   : UserIndexPage
    Created on : 05 6, 15, 3:17:15 PM
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
            String name = request.getParameter("name");
            String course= request.getParameter("course");
            String languages [] = request.getParameterValues("languages");
            String comment = request.getParameter("comment");
            String idol = request.getParameter("fan");
           
            out.println(type); 
            
            
        %>        
        
        
    </body>
</html>
