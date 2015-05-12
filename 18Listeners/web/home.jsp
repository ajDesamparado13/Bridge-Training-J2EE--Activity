<%@page import="com.dao.UserDao"%>
<%@page import="com.listeners.AppEventListeners"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.UserBean"%>

<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
         <p> <a href="userController?action=add">Add</a></p>
   
        <table border="1">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th colspan="2">Action</th>
                </tr>                
            </thead>
            <tbody>                                                
            </tbody>
        </table>
             <hr>
         <p>
             The number of  log-in attempts is <%=session.getAttribute("counter")%><br>
             Number of active Sessions: <%out.print(AppEventListeners.nActiveSessions());%>
         </p>
    </body>
</html>

<%
   }else
       response.sendRedirect("index.html");
       
%>