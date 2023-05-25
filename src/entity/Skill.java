package entity;

import java.util.ArrayList;

public class Skill {

    public  ArrayList<Integer> courseList = new ArrayList<Integer>();
    private String             skillName;
    public boolean            accquired;

    public String getSkillName()                {return this.skillName;}
  
    public void setSkillName(String skillName)  { this.skillName = skillName; }

    public boolean getAccquired()               { return this.accquired; }
 
    public void setAccquired(boolean accquired) { this.accquired = accquired; }
}
