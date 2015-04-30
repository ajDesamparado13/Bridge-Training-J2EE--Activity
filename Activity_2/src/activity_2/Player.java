/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity_2;

/**
 *
 * @author asi
 */

public class Player{
    
    //maximum number of heroes for a player is 5 
    String sPlayerName;
    Hero heroes [] = new Hero [5];
    int currentHeroes=0;
    
    public Player(String name)
    {
        sPlayerName=name;
    }
    
    public void action(int playerAct,int character)
    {
        switch(playerAct)
        {
            case 1://attack
                    break;
            case 2://block
                   heroes[character].Block();
                    break;
            case 3://upgrade
                    break;
            default:
                    break;                  
        }
    }
    
    public void newHero(String name,String type,String skill)
    {
        heroes[0]=new Hero(name,type);
        heroes[0].addSkill(skill);
    }
    
    public void upgradeHero(int character)
    {
        
    }
    
    public void getHeroes()
    {
        for(int i=0;i<=currentHeroes;i++)
            System.out.println("("+i+") "+heroes[i]);
    }
    
    
}
