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
    Hero heroes [] = new Hero [5];
    int currentHeroes=0;
    
    public void newHero(String name,String type,String skill)
    {
        heroes[0]=new Hero(name,type);
        heroes[0].addSkill(skill);
    }
    
}
