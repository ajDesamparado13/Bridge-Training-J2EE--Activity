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
    int iCurrentHeroes=0;
    
    public Player(String name)
    {
        sPlayerName=name;
    }
    
    public void blockAction(int selectedHero)
    {
        System.out.println(
         "********************************\n"
        +" "+heroes[selectedHero].Block()+"\n"
        +"********************************\n");
    }
    public void attackAction(int selectedHero,int skillUse){
        
      System.out.println(
         "********************************\n"
        +" "+heroes[selectedHero].Attack(skillUse)+"\n"
        +"********************************\n");
    }
    
    public void newHero(String name,String type,String skill)
    {
        heroes[iCurrentHeroes]=new Hero(name,type);
        heroes[iCurrentHeroes].addSkill(skill);
        iCurrentHeroes++;
    }
    
    public void upGradeHero(int character,String sUpgrade)
    {
      
        heroes[character].addSkill(sUpgrade);
    }
    
    public void getHeroes()
    {   
        for(int i=0;i<iCurrentHeroes;i++)
            System.out.println("("+i+") "+heroes[i].getName());
    }
    
    public void getHeroSkills(int character)
    {
      heroes[character].SkillsList();
    }
    
    public boolean noHeroes()
    {
        return iCurrentHeroes==0;
    }
    
    
}
