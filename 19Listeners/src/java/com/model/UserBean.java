/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author asi
 */
public class UserBean {
    
    private String username;
    private String password;
    private int userId;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setUserId(int userId)
    {
        this.userId=userId;
    }
    
    public int getUserID(){
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String toString(){
        return "Username:"+username+"Password:"+password;
    }
}
