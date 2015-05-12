/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.mysql.jdbc.Connection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author asi
 */
public class dbUtil {
    
    private Connection connection=null;
    
    public Connection getConnection(){
        if(connection != null)
            return connection;
        else
            try{
                Properties prop = new Properties();
                InputStream inputStream = dbUtil.class.getClassLoader().getResourceAsStream("./db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                
                Class.forName(driver);
                connection = (Connection) DriverManager.getConnection(url,user,password);
            }catch(ClassNotFoundException e){
                System.err.println("Class Not Found");
                e.printStackTrace();
            }catch(SQLException e){
                System.err.println("SQL EXCEPTION");
                e.printStackTrace();
            }catch(FileNotFoundException e){
                System.err.println("File Not Found");
                e.printStackTrace();
            }catch(IOException e){
                System.err.println("IOException");
                e.printStackTrace();
            }catch(Exception e){
                System.err.println("GENERIC EXCEPTION");
                e.printStackTrace();
            }
        
            
        return connection;
    }
    
    public boolean disconnect(){
        try{
            connection.close();
        }catch(SQLException se){        
            se.printStackTrace();
        }catch(Exception e){
        
            e.printStackTrace();
        }
        return true;
    }
}
