package Control;

import java.util.*;
import java.io.*;

import Entity.Skill;

public class SkillsControl {
    
    public ArrayList<Skill>        skillslist         = new ArrayList<Skill>();
    public ArrayList<Integer>      GPAlist            = new ArrayList<Integer>();
    public ArrayList<Integer>      CourseLearnedList  = new ArrayList<Integer>();
    public ArrayList<Integer>      toLearnSkillList   = new ArrayList<Integer>();

    private int maxCourses;

    public SkillsControl(String ID){
        readtoLearnSkills(ID);
        readSkills();
        readLearnedCourses(ID);
        isAccquired();
    }

    public void readtoLearnSkills(String ID){
        try{
            FileReader     fileReader     = new FileReader("./Entity/StuCourse.txt");
            //FileReader     fileReader     = new FileReader("StuCourse.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();
            //Read a line one by one
            //The index in txt files are in order by default.
            while(oneline!=null){
                String[] oneInfo = oneline.split(" ");
                if(oneInfo[0].equals(ID)){
                    String[] tempCourse = oneInfo[1].split("_");
                    String[] tempList = oneInfo[2].split("_");
                    this.maxCourses = Integer.parseInt(tempCourse[tempCourse.length-1]);
                    for(int i=0;i<tempList.length;i++){
                        toLearnSkillList.add(Integer.parseInt(tempList[i]));
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
            System.exit(-1);;
        }
    }

    public void readSkills(){
        try{
            FileReader     fileReader     = new FileReader("./Entity/Skills.txt");
            //FileReader     fileReader     = new FileReader("Skills.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();
            //Read a line one by one
            //The index in txt files are in order by default.
            int sum = 0;
            oneline = bufferedReader.readLine();
            while(oneline!=null){
                String[] oneInfo = oneline.split(" ");
                if(toLearnSkillList.get(sum)==Integer.parseInt(oneInfo[0])){
                    skillslist.add(new Skill());
                    skillslist.get(sum).setSkillName(oneInfo[1]);
                    String[] tempList = oneInfo[2].split("_");
                    for(int j=0;j<tempList.length;j++){
                        skillslist.get(sum).courseList.add(Integer.parseInt(tempList[j]));
                    }
                    sum++;
                    if(sum==toLearnSkillList.size()){
                        break;
                    }
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

    public void readLearnedCourses(String ID){
        try{
            FileReader     fileReader     = new FileReader("./Entity/StuGPA.txt");
            //FileReader     fileReader     = new FileReader("StuGPA.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();
            //Read a line one by one
            //The index in txt files are in order by default.
            while(oneline!=null){
                String[] oneInfo = oneline.split(" ");
                if(oneInfo[0].equals(ID)){
                    CourseLearnedList.add(Integer.parseInt(oneInfo[1]));
                    GPAlist.add(Integer.parseInt(oneInfo[2]));
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

    public void isAccquired(){
        int[] flag = new int[maxCourses+1];
        for(int j=0;j<CourseLearnedList.size();j++){
                    flag[CourseLearnedList.get(j)-1] = 1;
                }
        for(int i=0;i<skillslist.size();i++){
            
            if(skillslist.get(i).courseList.size()>CourseLearnedList.size()){
                skillslist.get(i).setAccquired(false);
                continue;
            }else{
                
                for(int k=0;k<skillslist.get(i).courseList.size();k++){
                    skillslist.get(i).setAccquired(true);
                    if(flag[skillslist.get(i).courseList.get(k)-1]!=1){
                        skillslist.get(i).setAccquired(false);
                        break;
                    }
                }
            }
        }
        
    }
}
