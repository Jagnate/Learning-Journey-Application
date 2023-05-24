package boundary;

import java.awt.event.MouseAdapter;
import java.io.*;

import javax.swing.*;

import control.AchControl;
import control.CourseControl;
import control.SkillsControl;

public class ProfileFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JLabel 		nameJLabel   = new JLabel("Name:");
	private JLabel		nameValue	 = new JLabel("Jin");
	private JLabel 		schoolJLabel = new JLabel("School:");
	private JLabel		schoolValue	 = new JLabel("BUPT");
	private JLabel 		majorJLabel  = new JLabel("Major:");
	private JLabel		majorValue	 = new JLabel("Telecommunication");
	private JLabel 		courseJLabel = new JLabel("Curriculum:");
	private JLabel 		skillJLabel	 = new JLabel("Skills:");
	private JLabel 		achJLabel 	 = new JLabel("Achievement:");
	
	private JLabel 		course1		 = new JLabel("1");
	private JLabel 		course2		 = new JLabel("2");
	private JLabel 		course3		 = new JLabel("3");
	
	private JTextField  skillField1  = new JTextField();
	private JTextField  skillField2  = new JTextField();
	private JTextField  skillField3  = new JTextField();
	
	private JTextField  achField1 	 = new JTextField();
	private JTextField  achField2 	 = new JTextField();
	private JTextField  achField3 	 = new JTextField();
	
	private JButton		genButton	 = new JButton("Generate my CV!");
	
	private JPanel		mainPanel	 = new JPanel();
	
	private CourseControl courseControl;
	private SkillsControl skillsControl;
	private AchControl achControl;
	
	public ProfileFrame(String name,String school,String major, String ID, int year) {
		super("Your Profile");
		this.nameValue.setText(name);
		this.schoolValue.setText(school);
		this.majorValue.setText(major);
		
		this.courseControl = new CourseControl(ID, year);
		this.skillsControl = new SkillsControl(ID);
		this.achControl = new AchControl(ID);
		this.setLayout();
		this.setFrame();
		this.addListener();
		this.setVisible(true);
	}
	
	private void setLayout() {
		mainPanel.setLayout(null);
		this.add(mainPanel);
		
		nameJLabel.setBounds(20,10,100,50);
		mainPanel.add(nameJLabel);
		
		nameValue.setBounds(120,10,200,50);
		mainPanel.add(nameValue);
		
		schoolJLabel.setBounds(20,60,100,50);
		mainPanel.add(schoolJLabel);
		
		schoolValue.setBounds(120,60,200,50);
		mainPanel.add(schoolValue);
		
		majorJLabel.setBounds(20,110,100,50);
		mainPanel.add(majorJLabel);
		
		majorValue.setBounds(120,110,200,50);
		mainPanel.add(majorValue);
		
		courseJLabel.setBounds(20,160,100,50);
		mainPanel.add(courseJLabel);
		
		course1.setBounds(120,170,200,30);
		course1.setText(courseControl.top3[0].getCourseName()+" "+courseControl.top3[0].getGPA());
		mainPanel.add(course1);
		
		course2.setBounds(120,200,200,30);
		course2.setText(courseControl.top3[1].getCourseName()+" "+courseControl.top3[1].getGPA());
		mainPanel.add(course2);
		
		course3.setBounds(120,230,200,30);
		course3.setText(courseControl.top3[2].getCourseName()+" "+courseControl.top3[2].getGPA());
		mainPanel.add(course3);
		
		skillJLabel.setBounds(20,250,100,50);
		mainPanel.add(skillJLabel);
		
		skillField1.setBounds(110,260,200,30);
		if(skillsControl.skillslist.size()>0) {
			skillField1.setText(skillsControl.skillslist.get(0).getSkillName());
		}
		mainPanel.add(skillField1);
		
		skillField2.setBounds(110,290,200,30);
		if(skillsControl.skillslist.size()>1) {
			skillField2.setText(skillsControl.skillslist.get(1).getSkillName());
		}
		mainPanel.add(skillField2);
		
		skillField3.setBounds(110,320,200,30);
		if(skillsControl.skillslist.size()>2) {
			skillField3.setText(skillsControl.skillslist.get(2).getSkillName());
		}
		mainPanel.add(skillField3);
		
		achJLabel.setBounds(20,350,100,50);
		mainPanel.add(achJLabel);
		
		achField1.setBounds(110,360,200,30);
		if(achControl.ach_list.size()>0) {
			achField1.setText(achControl.ach_list.get(0).getName());
		}
		mainPanel.add(achField1);
		
		achField2.setBounds(110,390,200,30);
		if(achControl.ach_list.size()>1) {
			achField2.setText(achControl.ach_list.get(1).getName());
		}
		mainPanel.add(achField2);
		
		achField3.setBounds(110,420,200,30);
		if(achControl.ach_list.size()>2) {
			achField3.setText(achControl.ach_list.get(2).getName());
		}
		mainPanel.add(achField3);
		
		genButton.setBounds(65,460,200,50);
		mainPanel.add(genButton);
	}
	
	private void setFrame() {
		this.setSize(330,550);
		this.setResizable(false);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void genCV() {
        String profile = "<!DOCTYPE html>\n"
        		+ "<html lang=\"en\">\n"
        		+ "<head>\n"
        		+ "    <meta charset=\"UTF-8\">\n"
        		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
        		+ "    <title>Resume</title>\n"
        		+ "    <link rel=\"stylesheet\" href=\"CV.css\">\n"
        		+ "</head>\n"
        		+ "<body>\n"
        		+ "\n"
        		+ "<div class=\"container\">\n"
        		+ "    <div class=\"topline\" >\n"
        		+ "        <div class=\"top_left\" ></div>\n"
        		+ "        <div class=\"top_right\">\n"
        		+ "            <p>Personal Resume</p>\n"
        		+ "        </div>\n"
        		+ "    </div>\n"
        		+ " \n"
        		+ "    <div class=\"mid\">\n"
        		+ "        <div class=\"personal\">\n"
        		+ "            <h3 style=\"margin-bottom: -8px;\"><span style=\"border-bottom: 3px solid black\">Personal Information</span></h3>\n"
        		+ "            <hr>\n"
        		+ "            <p>Name:&nbsp; "+this.nameValue.getText()+"</p>\n"
        		+ "            <p>University: &nbsp;"+this.schoolValue.getText()+"</p>\n"
        		+ "            <p>Major:&nbsp; "+this.majorValue.getText()+" </p>\n"
        		+ "\n"
        		+ "        </div>\n"
        		+ " \n"
        		+ " \n"
        		+ "        <div class=\"courses\">\n"
        		+ "            <h3 style=\"margin-bottom: -8px\"><span style=\"border-bottom: 3px solid black\">A+ Courses</span></h3>\n"
        		+ "            <hr>\n"
        		+ "            <p>"+this.course1.getText().split(" ")[0]+" &nbsp; &nbsp; &nbsp; "+this.course1.getText().split(" ")[1]+"</p>\n"
        		+ "            <p>"+this.course2.getText().split(" ")[0]+" &nbsp; &nbsp; &nbsp; "+this.course2.getText().split(" ")[1]+"</p>\n"
        		+ "            <p>"+this.course3.getText().split(" ")[0]+" &nbsp; &nbsp; &nbsp; "+this.course3.getText().split(" ")[1]+"</p>\n"
        		+ "        \n"
        		+ " \n"
        		+ "        </div>\n"
        		+ " \n"
        		+ "        <div class=\"skill\">\n"
        		+ "            <h3 style=\"margin-bottom: -8px\"><span style=\"border-bottom: 3px solid black\">Skills</span></h3>\n"
        		+ "            <hr>\n"
        		+ "            <p>"+this.skillField1.getText()+"</p>\n"
        		+ "            <p>"+this.skillField2.getText()+"</p>\n"
        		+ "            <p>"+this.skillField3.getText()+"</p>\n"
        		+ "        </div>\n"
        		+ " \n"
        		+ "        <div class=\"ach\">\n"
        		+ "            <h3 style=\"margin-bottom: -8px\"><span style=\"border-bottom: 3px solid black\">Achievements</span></h3>\n"
        		+ "            <hr>\n"
        		+ "                <p>"+this.achField1.getText()+"</p>\n"
        		+ "                <p>"+this.achField2.getText()+"</p>\n"
        		+ "                <p>"+this.achField3.getText()+"</p>\n"
        		+ "        </div>\n"
        		+ " \n"
        		+ "    \n"
        		+ " \n"
        		+ "    </div>\n"
        		+ "    <div class=\"bottomline\" >\n"
        		+ "        <div class=\"bottom_left\" ></div>\n"
        		+ "        <div class=\"bottom_right\">\n"
        		+ "        </div>\n"
        		+ "    </div>\n"
        		+ " \n"
        		+ "</div>\n"
        		+ "</body>\n"
        		+ "</html>\n";
        try {
        	FileWriter fileWriter = new FileWriter(this.nameValue.getText()+".html");
           	BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(profile);
        	bufferedWriter.close();
        }catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Create Error!");
		}
        JOptionPane.showMessageDialog(null, "Create Successfully!");
	}
	
	private void addListener() {
		genButton.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent e){        
                genCV();
            }
        });
	}
}
