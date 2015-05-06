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
    
    private String username="wew";
    private String password="wew";
    
    public boolean isUserValid(String username,String password)
    {
    
        return this.username.equals(username) && this.password.equals(password);
        
    }
}
