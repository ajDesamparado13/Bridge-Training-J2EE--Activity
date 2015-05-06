/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author asi
 */
public class ProcessUserServlet extends HttpServlet {
    
    public void init() throws ServletException{
        
    }
    
    public void doGet( HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        
       
    }
    
    public void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String course= request.getParameter("course");
        String languages [] = request.getParameterValues("languages");
        String comment = request.getParameter("comment");
        String idol = request.getParameter("fan");
        
        out.println("<h1> Hello"+name+"</h1>");
        out.println("Type:"+type);
        out.println("Are you sure you will graduate to that "+course+ " course ");        
        out.println("<br>Then you will need to learn the following languages to passed this course:");
        for(String s : languages)
        out.println("<br>"+s);
        
        out.println("<br>You are a fan of "+idol);
        out.println("and your comment is "+comment);
        
    }
    
    public void destroy(){
        
    }
    
}
