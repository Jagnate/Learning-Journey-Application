package Entity;

import java.util.ArrayList;

public class Course {
    
    
    public ArrayList<Integer> skillList = new ArrayList<Integer>();
    private int     Index;
    private String  courseName;
    private int     credit;
    private int     GPA;
    private boolean completed;
    private boolean tolearn;  
    private boolean pass;
    private boolean courseType; //true compuslory; false optional
    private int     year;

    public String getCourseName() {
        return this.courseName;
    }
  
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return this.credit;
    }
 
    public void setCredit(int credit) {
        this.credit = credit;
    }

    public boolean getTolearn() {
        return this.tolearn;
    }
 
    public void setTolearn(Boolean tolearn) {
        this.tolearn = tolearn;
    }

    public int getIndex() {
        return this.Index;
    }
 
    public void setIndex(int Index) {
        this.credit = Index;
    }

    public int getGPA() {
        return this.GPA;
    }
 
    public void setGPA(int GPA) {
        this.GPA = GPA;
    }

    public boolean getCompleted() {
        return this.completed;
    }
 
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean getPass() {
        return this.pass;
    }
 
    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public boolean getCourseType() {
        return this.courseType;
    }
 
    public void setCourseType(boolean courseType) {
        this.courseType = courseType;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getYear(){
        return this.year;
    }
}