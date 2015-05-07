<%-- 
    Document   : profile
    Created on : 05 6, 15, 4:27:21 PM
    Author     : asi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control","no-store, must revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", -1);
    
    if(session.getAttribute("username")!=null){
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>        
    </head>
    
    <body>
        <ul>
            <li><a href="home.jsp">HOME</a></li>
            <li><a href="profile.jsp">Profile</a></li>
            <li><a href="logout"><input type="button" value="Logout"></a></li>            
        </ul>
        
        <h1> Hello <% out.println(session.getAttribute("username")); %> </h1>
        
    </body>
    
</html>

<%
    }else
        response.sendRedirect("index.html");
%>