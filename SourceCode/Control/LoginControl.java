/**
 *  Title      : LoginControl.java
 *  Description: This class is in charge of reading information from interface 
 *  and checking the info from database(i.e. txt file).
 * 
 *  In this version, I set up the basic checkID method
 *  @author  Jin Si
 *  @version 1.0
 *  
 *  In this version, Yilun and Yuanchi fix some bugs and 
 *  use String instead of int as a status so it can return ID directly
 *  @author Yilun Deng
 *  @author Yuanchi Zhou
 */
package Control;

import java.io.*;
import Entity.Student;

public class LoginControl {
    
    // -1 = Not Found StudentID; 0 = Success ; 1 = Wrong Password
    public String checkID(String ID, String PassWord){
        String resStatus = "-1";
        try{
            
            FileReader     fileReader     = new FileReader("./Entity/"+Student.userLog);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();

            //Read a line one by one
            while(oneline!=null){
                String[] oneInfo = oneline.split(" ");
                if(oneInfo[0].equals(ID)){
                    if(oneInfo[1].equals(PassWord)){
                        resStatus = ID;
                    }
                    else{
                        System.out.println(oneInfo[1]);
                        resStatus = "1";
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
