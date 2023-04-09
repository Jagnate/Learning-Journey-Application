import java.util.ArrayList;

public class Course {
    
    private ArrayList<Course> skillList = new ArrayList<Course>();
    
    private String  courseName;
    private int     credit;
    private int     GPA;
    private boolean completed; 
    private boolean pass;
    private boolean courseType; //true compuslory; false optional
}
