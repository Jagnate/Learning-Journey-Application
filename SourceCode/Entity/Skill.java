import java.util.ArrayList;

public class Skill {

    private ArrayList<Course> courseList = new ArrayList<Course>();
    private String skillName;
    private boolean gotten;
    private int i;

    public Course getCourse(){
        return courseList.get(i);
    }

    public void setCourse(Course newCourse){
        courseList.add(newCourse);
    }

    public String getSkillName() {
        return this.skillName;
    }
  
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public boolean getGotten() {
        return this.gotten;
    }
 
    public void setGotten(boolean gotten) {
        this.gotten = gotten;
    }
}