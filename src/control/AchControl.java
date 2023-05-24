package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import entity.*;

public class AchControl {
	
	public ArrayList<Integer>	skill_index_list = new ArrayList<Integer>();
	public ArrayList<Achievement> ach_list = new ArrayList<Achievement>();
	
	public ArrayList<String> getAchlist = new ArrayList<String>();
	public ArrayList<String> suggestedList =  new ArrayList<String>();
	
	public AchControl(String ID) {
		this.readAchlist();
		this.readGetSkills(ID);
		this.readGetAchs(ID);
		this.suggestedAchs();
	}
	
	public void readAchlist() {
		try{
            FileReader     fileReader     = new FileReader("entity/Achievement.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();
            oneline = bufferedReader.readLine();
            //Read a line one by one
            while(oneline!=null){
                String[] oneInfo = oneline.split(" ");
                Achievement ach = new Achievement();
                ach.setName(oneInfo[1]);
                for(int i=0;i<oneInfo[2].split("_").length;i++) {
                	ach.skill_index.add(Integer.parseInt(oneInfo[2].split("_")[i]));
                }
                ach_list.add(ach);
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
	
	public void readGetSkills(String ID) {
		try{
            FileReader     fileReader     = new FileReader("entity/StuCourse.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();
            oneline = bufferedReader.readLine();
            //Read a line one by one
            while(oneline!=null){
                String[] oneInfo = oneline.split(" ");
                if(oneInfo[0].equals(ID)) {
                	for(int i=0;i<oneInfo[2].split("_").length;i++) {
                		skill_index_list.add(Integer.parseInt(oneInfo[2].split("_")[i]));
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
	}
	
	public void readGetAchs(String ID) {
		try{
            FileReader     fileReader     = new FileReader("entity/StuCourse.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String         oneline        = bufferedReader.readLine();
            oneline = bufferedReader.readLine();
            //Read a line one by one
            while(oneline!=null){
                String[] oneInfo = oneline.split(" ");
                if(oneInfo[0].equals(ID)) {
                	for(int i=0;i<oneInfo[3].split("_").length;i++) {
                		getAchlist.add(ach_list.get(Integer.parseInt(oneInfo[3].split("_")[i])-1).getName());
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
	}
	
	public void suggestedAchs() {
		for(int i=0;i<skill_index_list.size();i++) {
			for(int j=0;j<ach_list.size();j++)
				for(int k=0;k<ach_list.get(j).skill_index.size();k++)
					if(ach_list.get(j).skill_index.get(k)==skill_index_list.get(i)&(!getAchlist.contains(ach_list.get(j).getName())&(!suggestedList.contains(ach_list.get(j).getName())))) {
						suggestedList.add(ach_list.get(j).getName());
					}
		}
	}
	
	public static void main(String[] args) {
		AchControl achControl = new AchControl("jp2020213326");
		for(int i=0;i<achControl.suggestedList.size();i++)
			System.out.println(achControl.suggestedList.get(i));
		System.out.println("!");
		for(int i=0;i<achControl.getAchlist.size();i++)
			System.out.println(achControl.getAchlist.get(i));
		System.out.println("!!");
		for(int i=0;i<achControl.ach_list.size();i++)
			System.out.println(achControl.ach_list.get(i).getName());
		System.out.println("!!!");
		for(int i=0;i<achControl.skill_index_list.size();i++)
			System.out.println(achControl.skill_index_list.get(i));
	}
	
}
