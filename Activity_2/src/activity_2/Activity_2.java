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
     int iOption=-1,iOption2;
     int data,selectedHero,iSkill;
     String Sname;    
     String Stype;
     String sSkill;
     char c;
     boolean bStop=false;
     
     System.out.println(
      "**************************\n"
     +"*Hello welcome to my game*\n"
     +"**************************\n"        
     );
     System.out.println(
      "************************\n"
     +"*Enter your player name*\n"
     +"************************\n"        
     );
     Sname=input.next()+input.nextLine();
     Player player1= new Player(Sname);
     
     while(bStop==false)
     {
         System.out.println(
          "*************************\n"
         +"*(1) New Hero           *\n"
         +"*(2) Select Hero to act *\n"
         +"*(9) Exit               *\n"
         +"*************************\n");
         
         iOption=input.nextInt();
         
         switch(iOption)
         {
             case 1:
                    System.out.println(
                     "*********************\n"        
                    +"*Creating a new Hero*\n"
                    +"*********************\n"
                    +"Enter hero name");
                    
                    Sname=input.next()+input.nextLine();                    
                    System.out.println("Enter Hero Attribute Type");
                    Stype=input.next()+input.nextLine();
                    System.out.println("Add Hero Skill");
                    sSkill=input.next()+input.nextLine();  
                    player1.newHero(Sname, Stype, sSkill);
                    break;
                 
             case 2:
                    if(player1.noHeroes())
                        System.out.println(
                         "#########################################\n"        
                        +"#You currently don't have hero, Create 1#\n"
                        +"#########################################\n");
                    else{
                    iOption2=-1;
                    player1.getHeroes();
                    selectedHero=input.nextInt();
                        while(iOption2!=9)
                        {                       
                        System.out.println(
                         "***********************\n"
                        +"*(1) Attack           *\n"
                        +"*(2) Block            *\n"
                        +"*(3) Add new Skill    *\n"
                        +"*(9) Back to Main menu*\n"
                        +"***********************");
                        iOption2=input.nextInt();
                        switch(iOption2)
                        {
                            case 1:
                                   System.out.println("Select Skill to Use");
                                   player1.getHeroSkills(selectedHero);
                                   iSkill=input.nextInt();
                                   player1.attackAction(selectedHero, iSkill);
                                   break;
                            case 2:
                                    player1.blockAction(selectedHero);
                                    break;
                            case 3:
                                    System.out.println("Enter new Skill");
                                    sSkill=input.next()+input.nextLine();
                                    player1.upGradeHero(selectedHero, sSkill);
                                    break;
                            case 9:
                                                                  
                                    break;
                            default:
                                    System.err.println("Invalid option try agaian");
                        }
                        System.out.println("Press Any Key to Continue");
                        c=input.next().charAt(0);
                    }}
                    break;
             case 9:
                    bStop=true;
                    break;
             default:
                    System.err.println("Invalid option try agaian");  
                 
         }         
         System.out.println("Press Any Key to Continue");
         c=input.next().charAt(0);
     }
    }
    
}
/*
 *Implement a program with the following remarks
 * a. HERO with attack or block method and attributes name/skills
 *  b. Multiple Heroes
 * c. Attack opponent with a different set of skills anytime
*/