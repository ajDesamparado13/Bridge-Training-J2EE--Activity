/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity3;

import java.util.Scanner;

/**
 *
 * @author asi
 */
public class TravelSite {

    /**
     * @param args the command line arguments
     */ 
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
    UserSubscriptions newSite = new UserSubscriptions();
    int option=-1;  
    String Message;
    char c;
    boolean Stop=false;  
      
    new EmailSubscriber(newSite);
    new SMSSubscriber(newSite);
    new AccountNotification(newSite);
     while(Stop!=true){
    System.out.println(
    "******************************\n"+
    "*TRAVELSITE    ADMINISTRATOR *\n"+   
    "******************************\n"+
    "*(0)Add New Notification     *\n"+
    "*(1)Add New Subscription type*\n"+
    "*(2)Remove Subscription  type*\n"+
    "*(3)Notify All Subscribers   *\n"+
    "*(4)Get latest notification  *\n"+   
    "*(5)Add New User             *\n"+
    "*(9)Exit                     *\n"+
    "******************************"
    );
    option=input.nextInt();
    switch(option){
        case 0:
                Message=input.next()+input.nextLine();
                newSite.setState(Message);
                break;
        case 1:
                System.out.println("Enter Subscriber name");
                Message=input.next()+input.nextLine();                
                newSite.attach(null);
                break;
        case 2:
                newSite.detach(null);
                break;
        case 3:
                newSite.notifyAllSubscribers();
                break;
        case 4:
                System.out.println(newSite.listOfSubscribers());
                break;
        case 5:
                System.err.println("Not yet implemented");
        case 9:
                Stop=true;
                break;
        default:
                System.err.println(
                "*************************\n"+
                "*Invalid input try again*\n"+
                "*************************");
    }
    System.out.println("Press Any Key to Continue");
    c=input.next().charAt(0);
         
     }
      
    }
    
}
