package SourceCode.Control;

import java.io.*;

import SourceCode.Entity.Student;

public class MainControl {

    private Student stu = new Student();

    public void readInfo(String ID){
        try{

            FileReader     fileReader     = new FileReader(Student.database);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();

            //Read a line one by one
            while(oneline!=null){
                //Data format: StuID  StuName    StudentBirth StuMajor   StuSchool  StuYear
                //         oneInfo[0] oneInfo[1]  oneInfo[2]  oneInfo[3] oneInfo[4] oneInfo[5]
                String[] oneInfo = oneline.split(" ");
                if(oneInfo[0]==ID){
                    stu.setName(oneInfo[1]);
                    stu.setBirth(Integer.parseInt(oneInfo[2]));
                    stu.setMajor(oneInfo[3]);
                    stu.setSchool(oneInfo[4]);
                    stu.setYear(Integer.parseInt(oneInfo[5]));
                    break;   
                }
                oneline = bufferedReader.readLine();
            }

            fileReader.close();
            bufferedReader.close();

        }catch(IOException e){
            //To be updated with UI
            System.err.println(e);
            System.exit(-1);;
        }
    }
}
