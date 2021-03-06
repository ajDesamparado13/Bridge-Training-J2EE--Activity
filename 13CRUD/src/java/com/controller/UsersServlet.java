/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.UserDao;
import com.model.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asi
 */

public class UsersServlet extends HttpServlet {
    private static final String addOrEdit = "/user.jsp";
    private static final String home = "/home.jsp";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        
        try (PrintWriter out = response.getWriter()) {
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       String forward = "";
       
       String action =request.getParameter("action");
       
       if(action.equals("edit")){
           int userId = Integer.parseInt(request.getParameter("userId"));
           UserBean user = UserDao.getUserById(userId);
           request.setAttribute("user", user);
           forward = addOrEdit;
       }else if (action.equals("add")){
           forward="addOrEdit";
       }else if (action.equals("delete")){
           int userId = Integer.parseInt(request.getParameter("userId"));
           UserDao.DeleteUser(userId);
           forward= home;
           HttpSession session = request.getSession();
           session.setAttribute("users",UserDao.getAllUsers());
       }
       
       RequestDispatcher rd = request.getRequestDispatcher(forward);
       rd.forward(request, response);
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       RequestDispatcher view;
       
       UserBean user = new UserBean();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        
        String userid = request.getParameter("userId");
        
        if(userid.isEmpty()){
            System.out.println("ADDING USER");
            UserDao.AddUser(user);
        }else{
            user.setUserId(Integer.parseInt(userid));
            System.out.println("EDITING USER");
            UserDao.UpdateUser(user);
            System.out.println("USERID:"+user.getUserID());
        System.out.println("username:"+user.getUsername());
        System.out.println("password:"+user.getPassword());
        }
        HttpSession session = request.getSession();
        session.setAttribute("users", UserDao.getAllUsers());
        RequestDispatcher rd = request.getRequestDispatcher(home);
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
