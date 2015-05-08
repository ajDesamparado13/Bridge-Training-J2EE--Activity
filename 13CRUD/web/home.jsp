<%-- 
    Document   : home
    Created on : 05 6, 15, 3:55:09 PM
    Author     : asi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <h1> Hello World </h1>
         <p> <a href="usersForm?action=add">Add</a></p>
   
        <table border="1">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th colspan="2">Action</th>
                </tr>                
            </thead>
            <tbody>                
                <c:forEach items="${users}"  var="user">
                    <tr>
                        <td><c:out value="${user.username}"/></td>
                        <td><c:out value="${user.password}"/></td>
                        <td><a href="usersForm?action=edit&userId=<c:out value="${user.userId}"/>"/>Edit</td>
                        <td><a href="usersForm?action=delete&userId=<c:out value="${user.userId}"/>"/>Delete</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
    </body>
</html>

<%
   }else
       response.sendRedirect("index.html");
       
%>