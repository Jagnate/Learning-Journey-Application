//package Entity;
import java.util.ArrayList;
import java.io.*;
      
public class Control{

    public ArrayList<Course> course1 = new ArrayList<Course>();  //主函数
    Course course2 = new Course();

    public void readInfo(){
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
    }

    public static void main(String[] args) {
       Control test = new Control();
       test.readInfo();
    }
}
