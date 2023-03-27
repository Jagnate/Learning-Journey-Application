package SourceCode.Control;

import java.io.*;

import SourceCode.Entity.Student;

public class LoginControl {
    
    // -1 = Not Found StudentID; 0 = Success ; 1 = Wrong Password
    public int checkID(String ID, String PassWord){
        int resStatus = -1;
        try{
            
            FileReader     fileReader     = new FileReader(Student.userLog);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();

            //Read a line one by one
            while(oneline!=null){
                String[] oneInfo = oneline.split(" ");
                if(oneInfo[0].equals(ID)){
                    if(oneInfo[1]==PassWord){
                        //To be updated with UI
                        System.out.println("Successfully!");
                        resStatus = 0;
                    }
                    else{
                        //To be updated with UI
                        System.out.println("Wrong PassWord!");
                        resStatus = 1;
                    }
                    break; 
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

        return resStatus;
    }
}
