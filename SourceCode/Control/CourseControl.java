package Entity;
import java.util.ArrayList;
import java.io.*;
      
public class CourseControl{

    public ArrayList<Course> course1 = new ArrayList<Course>();  //主函数
    Course course2 = new Course();

    public void readInfo(String ID, int year){

        try{

            FileReader     fileReader     = new FileReader("Courses.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();

            //Read a line one by one
            while(oneline!=null){

                String[] oneInfo = oneline.split(" ");

                course2.setIndex(Integer.parseInt(oneInfo[0]));
                course2.setCourseName(oneInfo[1]);
                course2.setCredit(Integer.parseInt(oneInfo[2]));
                course2.setCourseType(Boolean.valueOf(oneInfo[3]));
                course2.setYear(Integer.parseInt(oneInfo[4]));

                String[] oneInfo2 = oneInfo[5].split(".");
                int len = oneInfo2.length;
                for (int i = 0; i < len; i++) {
                    course2.skillList.add(Integer.parseInt(oneInfo2[i]));
                }
                course1.add(course2);
                oneline = bufferedReader.readLine();
            }

            fileReader.close();
            bufferedReader.close();

        }catch(IOException e){
            //To be updated with UI
            System.err.println(e);
            System.exit(-1);
        }

        
        try{

            FileReader     fileReader     = new FileReader("StuCourse.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();

            //Read a line one by one
            while(oneline!=null){

                String[] oneInfo = oneline.split(" ");

                if(oneInfo[0].equals(ID)){
                    String[] oneInfo2 = oneInfo[1].split(".");
                    int len = oneInfo2.length;
                    for (int i = 0; i < len; i++) {
                             course1.get(Integer.parseInt(oneInfo2[i])).setTolearn(true);
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

        try{

            FileReader     fileReader     = new FileReader("StuGPA.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();

            //Read a line one by one
            while(oneline!=null){

                String[] oneInfo = oneline.split(" ");

                if(oneInfo[0].equals(ID)){
                    course1.get(Integer.parseInt(oneInfo[1])).setGPA(Integer.parseInt(oneInfo[2]));
                    course1.get(Integer.parseInt(oneInfo[1])).setCompleted(true);
                    if(Integer.parseInt(oneInfo[2])<60){
                        course1.get(Integer.parseInt(oneInfo[1])).setPass(false);
                    }
                    else{
                        course1.get(Integer.parseInt(oneInfo[1])).setPass(true);
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
        
        for (Course i : course1) {
            if(i.getYear()<year-2020 && i.getTolearn()==true){
                i.setCompleted(false);
            }
            if(i.getYear()>=year-2020 && i.getTolearn()==true){
                i.setCompleted(true);
            }
        }

    }

    public static void main(String[] args) {
        CourseControl test = new CourseControl();
       test.readInfo("aaaa",2022);
    }


}
