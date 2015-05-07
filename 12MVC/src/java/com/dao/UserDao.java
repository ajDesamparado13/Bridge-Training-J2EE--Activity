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
    /*
    public static void main(String [] args){
        UserBean user = new UserBean();
        user.setPassword("wew");
        user.setUsername("wew");
        
        System.out.println(UserDao.isValid(user));
    }
    */
}

