/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity_2;
import java.util.Scanner;
/**
 *
 * @author asi
 */
public class Activity_2 {

    /**
     * @param args the command line arguments
     */
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
     int iOption=-1;
     int data,selectedHero;
     String Sname;    
     String Stype;
     char c;
     boolean bStop=false;
     
     System.out.println("Hello welcome to my game");
     System.out.println("Enter your player name");
     Sname=input.next()+input.nextLine();
     Player player1= new Player(Sname);
     
     while(bStop==false)
     {
         System.out.println("(1) New Hero");
         System.out.println("(2) Select Hero to act");
         System.out.println("(9) Exit");
         
         iOption=input.nextInt();
         
         switch(iOption)
         {
             case 1:
                    System.out.println("Creating a new Hero");
                    System.out.println("Enter hero name");
                    Sname=input.next()+input.nextLine();                    
                    System.out.println("Enter Hero Type");
                    Stype=input.next()+input.nextLine();
                    
                    break;
             case 2:
                    player1.getHeroes();
                    selectedHero=input.nextInt();
                    System.out.println("(1) Attack");
                    System.out.println("(2) Block");
                    System.out.println("(3) Upgrade");                    
                    data=input.nextInt();
                    if(data<3 && data!=0)
                    {
                        player1.action(data,selectedHero);
                    }
                    else
                        player1.upgradeHero(selectedHero);                        
                    break;
             case 9:
                    bStop=true;
                    break;
             default:
                    System.out.println("Invalid option try agaian");  
                 
         }         
         System.out.println("Press Any Key to Continue");
         c=input.next().charAt(0);
     }
    }
    
}
/*
 *Implement a program with the following remarks
 * a. HERO interface with attack or block method and attributes name/skills
 *  b. Multiple Heroes
 * c. Attack opponent with a different set of skills anytime
*/