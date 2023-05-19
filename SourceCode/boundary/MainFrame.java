/**
 *  Title      : MainFrame.java
 *  Description: This class is the main interface of the learning journey application 
 *  which shows the basic information
 * 
 *  In this version, I set up basic components.
 *  @author  Jin Si
 *  @version 1.0
 * 
 */

package boundary;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;

import control.MainControl;

public class MainFrame extends JFrame{

    private static final long serialVersionUID = 1L;
	private JMenuBar    menuBar     = new JMenuBar();
    private JMenu       courseMenu  = new JMenu("Courses");
    private JMenu       skillsMenu  = new JMenu("Skills");
    private JMenu       achMenu  	= new JMenu("Achivement");
    private JPanel      mainPlane   = new JPanel();
    private JLabel      IDLabel     = new JLabel();
    private JLabel      nameLabel   = new JLabel();
    private JLabel      birthLabel  = new JLabel();
    private JLabel      majorLabel  = new JLabel();
    private JLabel      schoolLabel = new JLabel();
    private JLabel      yearLabel   = new JLabel();
    private JLabel[]    infoTitle   = new JLabel[6];

    public MainControl  control     = new MainControl();

    private SkillsFrame skillsFrame;
    private CourseFrame courseFrame;
    private AchFrame	achFrame;

    public MainFrame(){
        this.setTitle(judegYear());
        this.setInfoTitle();
        this.setFrame();
        this.setMenu();
        this.mainLayout();
        this.setSkilsFrame();
        this.setCourseFrame();
        this.setAchFrame();
    }

    private String judegYear(){
        String title;
        Calendar date = Calendar.getInstance();
        if(control.stu.getYear()+4>date.get(Calendar.YEAR)){
            title = "Welcome Back to your Learning Journey!";
        }else{
            title = "Welcome to your Learning Journey!";
        }
        return title;
    }

    private void setFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,400);
        this.setResizable(false);
    }

    private void setMenu(){
        menuBar.add(courseMenu);
        menuBar.add(skillsMenu);
        menuBar.add(achMenu);
        this.setJMenuBar(menuBar);
    }

    public void setInfoTitle(){
        String[] titleStrings = {"ID: ","Name: ","Birth: ","Major: ","Schoool: ","Year: "};
        for(int i =0;i<6;i++){
            infoTitle[i] = new JLabel();
            infoTitle[i].setText(titleStrings[i]);
        }
    }

    public void showInfo(){
        //Wait LoginControl to input the valid studentID
        control.readInfo();
        IDLabel.setText(control.stu.getID());
        nameLabel.setText(control.stu.getName());
        birthLabel.setText(Integer.toString(control.stu.getBirth()));
        majorLabel.setText(control.stu.getMajor());
        schoolLabel.setText(control.stu.getSchool());
        yearLabel.setText(Integer.toString(control.stu.getYear()));
    }

    private void mainLayout(){
        this.add(mainPlane);
        mainPlane.setLayout(null);

        //showInfo();
        IDLabel.setBounds(120, 20, 100, 50);
        mainPlane.add(IDLabel);

        nameLabel.setBounds(120, 60, 50, 50);
        mainPlane.add(nameLabel);

        birthLabel.setBounds(120, 100, 50, 50);
        mainPlane.add(birthLabel);

        majorLabel.setBounds(120, 140, 150, 50);
        mainPlane.add(majorLabel);

        schoolLabel.setBounds(120, 180, 100, 50);
        mainPlane.add(schoolLabel);

        yearLabel.setBounds(120, 220, 100, 50);
        mainPlane.add(yearLabel);

        for(int i=0;i<6;i++){
            infoTitle[i].setBounds(30, 20+i*40, 70, 50);
            mainPlane.add(infoTitle[i]);
        }
    }

    private void setSkilsFrame(){
        skillsMenu.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent e){        
                skillsFrame = new SkillsFrame(control.stu.getID());
            }
        });
    }

    private void setCourseFrame(){
        courseMenu.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent e){        
                courseFrame = new CourseFrame(control.stu.getID(),control.stu.getYear());
            }
        });
    }
    
    private void setAchFrame(){
        achMenu.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent e){        
                achFrame = new AchFrame("");
            }
        });
    }
}
