import java.util.ArrayList;

public class Course {
    
    private ArrayList<Skill> skillList = new ArrayList<Skill>();
    private String  courseName;
    private int     credit;
    private int     GPA;
    private boolean completed; 
    private boolean pass;
    private boolean courseType; //true compuslory; false optional
    private int     year;

    public Skill getSkill(int index){
        return skillList.get(index);
    }

    public void setSkill(Skill newSkill){
        skillList.add(newSkill);
    }

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
