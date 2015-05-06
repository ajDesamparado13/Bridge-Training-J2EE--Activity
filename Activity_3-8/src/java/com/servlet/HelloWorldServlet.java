/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author asi
 */
public class HelloWorldServlet extends HttpServlet {
    
    public void init() throws ServletException{
        
    }
    
    public void doGet( HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
                
    }
    
    public void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        
        String type=request.getParameter("type");
        
        RequestDispatcher rd;
        if(type.equals("Admin")){
             rd= request.getRequestDispatcher("/AdminIndexPage.jsp");
             rd.forward(request, response);
        }
        else if(type.equals("User")){        
            rd=request.getRequestDispatcher("/UserIndexPage.jsp");
            rd.forward(request, response);
        }
        
    }
    
    public void destroy(){
        
    }
    
}
