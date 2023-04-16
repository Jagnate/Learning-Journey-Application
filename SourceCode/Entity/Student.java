package Entity;

public class Student {

    public static String userLog  = "StudentLogin.txt";
    public static String database = "StudentInfo.txt";

    private String stuID;             //The student's ID
    private String stuPassWord;       //The password to log in student's journey
    private String stuName;
    private int    stuBirth;
    private String stuMajor;          //The major of student
    private String stuSchool;         //The school of student
    private int    stuYear;           //The year when student enter the college

    public String getID()                  { return this.stuID; }
  
    public void   setID(String ID)         { this.stuID = ID; }

    public String getPassWord()            { return this.stuPassWord; }
 
    public void   setPassWord(String PW)   { this.stuPassWord = PW; }

    public String getName()                { return this.stuName; }
  
    public void   setName(String name)     { this.stuName = name; }

    public int    getBirth()               { return this.stuBirth; }
  
    public void   setBirth(int birth)      { this.stuBirth = birth; }

    public String getMajor()               { return this.stuMajor;}
 
    public void   setMajor(String major)   { this.stuMajor = major; }

    public String getSchool()              { return this.stuSchool; }
 
    public void   setSchool(String school) { this.stuSchool = school; }

    public int    getYear()                { return this.stuYear; }

    public void   setYear(int year)        { this.stuYear = year; }

}
