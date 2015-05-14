/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity3;

/**
 *
 * @author asi
 */
public class AccountNotification extends Subscribers {
    
    public AccountNotification(UserSubscriptions subscription){
      this.subscription = subscription;
      this.subscription.attach(this);
   }

   @Override
   public void update() {
      System.out.println( "User TravelSite Account notification: " +  subscription.getState()  ); 
   }
}
