/**
 *  Title      : CourseControl.java
 *  Description: This program is used to read and store all course information and each student's course information.
 *
 *  In this version, I implemented all of the above functions.
 *  @author  Yilun Deng
 *  @version 1.0
 *  
 *  In this version, Jin Si fix some bugs.
 *  @author Jin Si
 *  @version 1.1
 */
package control;

import java.util.ArrayList;
import java.util.Arrays;

import entity.Course;

import java.io.*;


public class CourseControl{

    public ArrayList<Course>  courselist  = new ArrayList<Course>();
    public ArrayList<Integer> courseIndex = new ArrayList<Integer>();

    public double GPA[] = new double[4];
    private double total;
    
    public Course[] top3 = new Course[3];
    
    public CourseControl(String ID, int year){
        this.readCourses(ID);
        this.readGeneralInfo();
        this.readPersonInfo(ID,year);
        this.calGPA();
        this.top3Course();
    }
    
    public void calGPA() {
    	int all_score = 0;
    	int all_credit = 0;
    	int total_score[]= {0,0,0,0};
    	int total_credit[]= {0,0,0,0};
    	for(int i=0;i<courselist.size();i++) {
    		if(courselist.get(i).getCompleted()==true){
    			all_credit += courselist.get(i).getCredit();
				all_score += courselist.get(i).getCredit()*courselist.get(i).getGPA();
    			if(courselist.get(i).getYear()==1) {
    				total_credit[0] += courselist.get(i).getCredit();
    				total_score[0] += courselist.get(i).getCredit()*courselist.get(i).getGPA();
    			}
    			else if(courselist.get(i).getYear()==2) {
    				total_credit[1] += courselist.get(i).getCredit();
    				total_score[1] += courselist.get(i).getCredit()*courselist.get(i).getGPA();
    			}
    			else if(courselist.get(i).getYear()==3) {
    				total_credit[2] += courselist.get(i).getCredit();
    				total_score[2] += courselist.get(i).getCredit()*courselist.get(i).getGPA();
    			}
    			else if(courselist.get(i).getYear()==4) {
    				total_credit[3] += courselist.get(i).getCredit();
    				total_score[3] += courselist.get(i).getCredit()*courselist.get(i).getGPA();
    			}
    		}
    	}
    	this.total = all_score/all_credit;
    	for(int i=0;i<4;i++) {
    		if(total_credit[i]==0) {
    			GPA[i] = 0;
    		}else {
    			GPA[i] = total_score[i]/total_credit[i];
    		}
    		
    	}
    }
    
    public double getGPA() {
    	return this.total;
    }
    
    public void top3Course() {
    	int[] maxIndex = {-1,-1,-1,-1};
    	int[] index = new int[courselist.size()];
    	int[] course	= new int[courselist.size()];
    	for(int i=0;i<courselist.size();i++) {
    		course[i] = courselist.get(i).getGPA();
    		index[i] = course[i];
    	}
    	Arrays.sort(course);
    	for(int i=courselist.size()-3;i<courselist.size();i++) {
    		
    		for(int j=0;j<courselist.size();j++) {
    			int flag = 0;
    			if(course[i]==index[j]) {
    				for(int k=0;k<3;k++) {
    					if(maxIndex[k]==j) {
    						flag=1;
    					}
    				}
    				if(flag==1) {
    					continue;
    				}
    				maxIndex[i-courselist.size()+3] = j;
    				break;
    			}
    		}
    	}
    	this.top3[0]=courselist.get(maxIndex[0]);
    	this.top3[1]=courselist.get(maxIndex[1]);
    	this.top3[2]=courselist.get(maxIndex[2]);
    }

    public void readCourses(String ID){
        try{
            FileReader     fileReader     = new FileReader("entity/StuCourse.txt");
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
            FileReader     fileReader     = new FileReader("entity/Courses.txt");
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
            FileReader     fileReader     = new FileReader("entity/StuGPA.txt");
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
                                    courselist.get(j).setCompleted(true);
                                    if(Integer.parseInt(oneInfo[2])<60){
                                        courselist.get(j).setPass(false);
                                    }else{
                                        courselist.get(j).setPass(true);
                                    }
                                }
                            }
                            break;
                        }
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
    
}
