/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.UserBean;
import com.mysql.jdbc.Connection;
import com.util.dbUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asi
 */
public class UserDao {
    
    public static boolean isValid(UserBean user){
        boolean result = false;
        dbUtil db = new dbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement(""+
                    "select * from users where username=? and password=?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                result=true;
            }
            rs.close();
            stmt.close();
            db.disconnect();
        }catch(SQLException e){
            System.out.println("CONNECTION PROBLEM.");
            e.printStackTrace();
        }
        return result;
    }
    
    public static void AddUser(UserBean user){
        dbUtil db = new dbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement(""+
                    "insert into users values(?,?) ");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();
                        
            rs.close();
            stmt.close();
            db.disconnect();
        }catch(SQLException e){
            System.out.println("CONNECTION PROBLEM.");
            e.printStackTrace();
        }                
    }
    
    public static void DeleteUser(int userId)
    {        
        dbUtil db = new dbUtil();
        Connection connection = db.getConnection();
        try{
            Statement stmt = db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("Delete from users where userid="+userId);
            
            
            rs.close();
            stmt.close();
            db.disconnect();
        }catch(SQLException e){
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,e);
        }  
    }
    
    public static void UpdateUser(UserBean updatedUser)
    {
        
       dbUtil db = new dbUtil();
       Connection connection = db.getConnection();
       try{
           PreparedStatement stmt = connection.prepareStatement(
           "Update users SET username=?,password=? Where userid=?");
           stmt.setString(1,updatedUser.getUsername());
           stmt.setString(2,updatedUser.getPassword());
           stmt.setString(3,Integer.toString(updatedUser.getUserID()));
           ResultSet rs = stmt.executeQuery();
           
           rs.close();
           stmt.close();
           db.disconnect();
       }catch(SQLException e){
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,e);
        
    }
    }
    
    public static UserBean getUserById( int userId)
    {
       UserBean user= new UserBean();
       
       dbUtil db = new dbUtil();
       Connection connection = db.getConnection();
       try{
        Statement stmt = db.getConnection().createStatement();
       ResultSet rs = stmt.executeQuery("select * from users where userid="+userId);
       user.setPassword(rs.getString("password"));
       user.setUsername(rs.getString("username"));
       user.setUserId(userId);
           
       rs.close();
       stmt.close();
       db.disconnect();
       
       }catch(SQLException e){
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,e);
       }
    return user;
    }
    
    public static List<UserBean> getAllUsers(){
        List<UserBean> users = new ArrayList();
        dbUtil db = new dbUtil();       
        try{
            Statement stmt = db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while(rs.next()){
                UserBean user = new UserBean();
                user.setUserId(rs.getInt("userid"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                users.add(user);
            }
            rs.close();
            stmt.close();
            db.disconnect();
        }catch(SQLException e){
            
        }  
        return users;
    }  
    
    public static void main(String [] args)
            
    {
        for(UserBean user:UserDao.getAllUsers())
        System.out.println(user.toString());
    }
}

