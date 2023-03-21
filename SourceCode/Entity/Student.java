public class Student {
    private String stuID;             //The ID of student
    private String stuPassWord;       //The password to log in our system
    private String stuMajor;          //The major of student
    private String stuSchool;         //The school of student
    private String stuGrade;          //The grade of student
  
    public String getID() {
        return this.stuID;
    }
  
    public void setID(String ID) {
        this.stuID = ID;
    }

    public String getPassWord() {
        return this.stuPassWord;
    }
 
    public void setPassWord(String PW) {
        this.stuPassWord = PW;
    }

    public String getMajor() {
        return this.stuMajor;
    }
 
    public void setMajor(String major) {
        this.stuMajor = major;
    }

    public String getSchool() {
        return this.stuSchool;
    }
 
    public void setSchool(String school) {
        this.stuSchool = school;
    }

    public String getGrade() {
        return this.stuGrade;
    }    
}