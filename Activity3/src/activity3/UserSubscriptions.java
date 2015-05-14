/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity3;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author asi
 */
public class UserSubscriptions {        
    
    private List<Subscribers> SubscriptionTypes = new LinkedList();
    
    private String SubscriptionNotification;

   public String getState() {
      
      return SubscriptionNotification;
   }

   public void setState(String state) {
      this.SubscriptionNotification = state;
      notifyAllSubscribers();
   }

   public void attach(Subscribers subscriber){
      SubscriptionTypes.add(subscriber);		
   }
   
   public void detach(Subscribers subscriber){
      SubscriptionTypes.remove(subscriber);		
   }
   
   public String listOfSubscribers(){
      return SubscriptionTypes.toString();
   }

   public void notifyAllSubscribers(){
      for (Subscribers subscriber : SubscriptionTypes) {
         subscriber.update();
      }
   } 	      
   
   public String getLatestNotification(){
   
       return null;
   }
    
}
