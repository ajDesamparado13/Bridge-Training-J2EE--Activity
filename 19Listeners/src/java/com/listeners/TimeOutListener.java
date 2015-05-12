/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author asi
 */
public class TimeOutListener implements ServletContextListener, HttpSessionListener {
    
    public void sessionDestroyed(HttpSessionEvent hse){
        HttpSession session = hse.getSession();
        long start = session.getCreationTime();
        long end = session.getLastAccessedTime();
        
        String counter = (String)session.getAttribute("counter");
        log("DESTROY,Session Duration:"+(end-start)+" ms Counter:"+counter,hse);    
      
    }
     @Override
    public void sessionCreated(HttpSessionEvent hse) {       
        log("CREATE:",hse);
   
        
    }
    
    protected void log(String msg){
        System.out.println("["+getClass().getName()+"]"+msg);
    }

    
    private void log(String string, HttpSessionEvent hse) {
        String id = hse.getSession().getId();
        log("SessionID: "+id+" "+string);
        
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
