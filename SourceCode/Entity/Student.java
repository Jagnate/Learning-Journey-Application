package SourceCode.Entity;

import java.io.*;

public class Student {

    private static String database = "StudentInfo.txt";

    private String stuID;             //The student's ID
    private String stuPassWord;       //The password to log in student's journey
    private String stuMajor;          //The major of student
    private String stuSchool;         //The school of student
    private int    stuYear;           //The year when student enter the college
    
    public Student(String ID, String PW){
        readInfo(ID, PW);
    }

    public String getID()                  { return this.stuID; }
  
    public void   setID(String ID)         { this.stuID = ID; }

    public String getPassWord()            { return this.stuPassWord; }
 
    public void   setPassWord(String PW)   { this.stuPassWord = PW; }

    public String getMajor()               { return this.stuMajor;}
 
    public void   setMajor(String major)   { this.stuMajor = major; }

    public String getSchool()              { return this.stuSchool; }
 
    public void   setSchool(String school) { this.stuSchool = school; }

    public int    getYear()                { return this.stuYear; }

    public void   setYear(int year)        { this.stuYear = year; }

    //Return value: -1 = Error; 0 = Success; 1 = Not Found the ID; 2 = WrongPassword;
    public int readInfo(String ID, String PassWord){
        try{
            int resStatus = 1;
            FileReader     fileReader     = new FileReader(database);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();

            //Read a line one by one
            while(oneline!=null){
                //Data format: StuID StuPassWord stuMajor stuSchool stuYear
                //         oneStu[0] oneStu[1]  oneStu[2] oneStu[3] oneStu[4]
                String[] oneStu = oneline.split(" ");
                if(oneStu[0]==ID){
                    if(oneStu[1]==PassWord){
                        this.stuMajor  = oneStu[2];
                        this.stuSchool = oneStu[3];
                        this.stuYear   = Integer.parseInt(oneStu[4]);
                        resStatus = 0;
                        break;   
                    }
                    else{
                        //To be updated with UI
                        resStatus = 2;
                        System.out.println("Wrong PassWord!");
                    }
                }
                oneline = bufferedReader.readLine();
            }

            fileReader.close();
            bufferedReader.close();
            return resStatus;

        }catch(IOException e){
            //To be updated with UI
            System.err.println(e);
            return -1;
        }
    }
}
