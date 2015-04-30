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
public class Hero implements Character {
    String name;
    String type;
    String attack;
    String Block;
    int iSkills=0;
    String [] Skills = new String [5];
    
    public Hero(String name,String type)            
    {
        this.name=name;
        this.type=type;
    }
    
    public String Attack(int attackWith)
    {
        attack+="Attacking with "+Skills[attackWith];
        
        return attack;
    }
    
    public String Block()
    {
        return "Blocked!";
    }
    
    public void CharacterType(String type)
    {
       this.type=type;
    }
    
    public void SkillsList()
    {
        for(int i =0;i<=iSkills;i++){
        System.out.println(Skills[iSkills]);
        }
    }
    
    public void addSkill(String skillName)
    {
        Skills[iSkills]=skillName;
        
    }
    
    public void setHeroName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
}
