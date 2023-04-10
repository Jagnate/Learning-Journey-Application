import java.util.ArrayList;

public class Skill {

    private ArrayList<Course> courseList = new ArrayList<Course>();
    private String skillName;
    private boolean gotten;

    public Course getCourse(int index){
        return courseList.get(index);
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
