package Control;

import Entity.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;


public class CourseControl{

    public ArrayList<Course>  courselist  = new ArrayList<Course>();
    public ArrayList<Integer> courseIndex = new ArrayList<Integer>();

    public int[] sumGPA= new int[5];
    public int[] coursecnt= new int[5];
    public int[] GPA= new int[5];


    public class maxGPA{
        private String             courseName;
        private int                GPA;

       /* public String  getCourseName()                  { return this.courseName; }

        public void    setCourseName(String courseName) { this.courseName = courseName; }

        public int     getGPA()                         { return this.GPA; }

        public void    setGPA(int GPA)                  { this.GPA = GPA; }*/
    }
    
    public maxGPA[] maxGPA= new maxGPA[3];

    public CourseControl(String ID, int year){
        this.readCourses(ID);
        this.readGeneralInfo();
        this.readPersonInfo(ID,year);

    }

    public void readCourses(String ID){
        try{
            FileReader     fileReader     = new FileReader("./Entity/StuCourse.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();
            oneline = bufferedReader.readLine();
            //Read a line one by one
            while(oneline!=null){
                String[] oneInfo = oneline.split(" ");
                if(oneInfo[0].equals(ID)){
                    String[] courseTolearn = oneInfo[1].split("_");
                    for (int i = 0; i < courseTolearn.length; i++) {
                        courseIndex.add(Integer.parseInt(courseTolearn[i]));
                    }
                }
                oneline = bufferedReader.readLine();
            }
            fileReader.close();
            bufferedReader.close();

        }catch(IOException e){
            //To be updated with UI
            System.err.println(e);
            System.exit(-1);
        }
    }

    public void readGeneralInfo(){
        try{
            FileReader     fileReader     = new FileReader("./Entity/Courses.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();
            oneline = bufferedReader.readLine();
            int sum = 0;
            //Read a line one by one
            while(oneline!=null){
                if(sum==courseIndex.size()){
                    break;
                }
                String[] oneInfo = oneline.split(" ");
                if(courseIndex.get(sum)==Integer.parseInt(oneInfo[0])){
                    sum++;
                    Course tempCourse = new Course();
                    tempCourse.setIndex(Integer.parseInt(oneInfo[0]));
                    tempCourse.setCourseName(oneInfo[1]);
                    tempCourse.setCredit(Integer.parseInt(oneInfo[2]));
                    if(oneInfo[3].equals("Compulsory")){
                        tempCourse.setCourseType(true);
                    }
                    else{
                        tempCourse.setCourseType(false);
                    }
                    tempCourse.setYear(Integer.parseInt(oneInfo[4]));
                    this.courselist.add(tempCourse);
                }
                oneline = bufferedReader.readLine();
            }
            fileReader.close();
            bufferedReader.close();

        }catch(IOException e){
            //To be updated with UI
            System.err.println(e);
            System.exit(-1);
        }
    }

    public void readPersonInfo(String ID, int year){
        try{
            FileReader     fileReader     = new FileReader("./Entity/StuGPA.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();
            oneline = bufferedReader.readLine();
            //Read a line one by one
            while(oneline!=null){
                String[] oneInfo = oneline.split(" ");
                if(oneInfo[0].equals(ID)){
                    for(int i=0;i<courseIndex.size();i++){
                        if(courseIndex.get(i)==Integer.parseInt(oneInfo[1])){
                            for(int j=0;j<courselist.size();j++){
                                if(courselist.get(j).getIndex()==courseIndex.get(i)){
                                    courselist.get(j).setGPA(Integer.parseInt(oneInfo[2]));
                                    
                                    for(int k=1;k<=3;k++){
                                        if(courselist.get(j).getGPA()>=maxGPA[i].GPA){
                                            for(int l=3;l<=i+1;l--){
                                                maxGPA[l].courseName=maxGPA[l+1].courseName;
                                                maxGPA[l].GPA=maxGPA[l-1].GPA;                                            
                                            }
                                            maxGPA[k].GPA=courselist.get(j).getGPA();
                                            maxGPA[k].courseName=courselist.get(j).getCourseName();
                                        }
                                    }
                                  
                                    coursecnt[courselist.get(j).getYear()]+=courselist.get(j).getGPA();
                                    sumGPA[courselist.get(j).getYear()]+=courselist.get(j).getGPA()*courselist.get(j).getCredit();
                                    if(Integer.parseInt(oneInfo[2])<60){
                                        courselist.get(j).setPass(false);
                                    }else{
                                        courselist.get(j).setPass(true);
                                    }
                                    Calendar date = Calendar.getInstance();
                                    if(date.get(Calendar.YEAR)-year>=courselist.get(j).getYear()){
                                        courselist.get(j).setCompleted(true);
                                    }else{
                                        courselist.get(j).setCompleted(false);
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }

                oneline = bufferedReader.readLine();
            }

            for(int i=1;i<=4;i++){
                GPA[i]=sumGPA[i]/coursecnt[i];
            }


            fileReader.close();
            bufferedReader.close();

        }catch(IOException e){
            //To be updated with UI
            System.err.println(e);
            System.exit(-1);
        }
    }
}
