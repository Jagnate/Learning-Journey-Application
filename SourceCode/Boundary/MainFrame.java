/**
 *  Title      : MainFrame.java
 *  Description: This class is the main interface of the learning journey application 
 *  which shows the basic information
 * 
 *  In this version, I set up the physical keyboard and 30 blocks for basic game style
 *  @author  Jin Si
 *  @version 1.0
 * 
 */

package Boundary;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;

import Control.MainControl;

public class MainFrame extends JFrame{

    private JMenuBar    menuBar     = new JMenuBar();
    private JMenu       courseMenu  = new JMenu("Courses");
    private JMenu       skillsMenu  = new JMenu("Skills");
    private JPanel      mainPalne   = new JPanel();
    private JLabel      nameLabel   = new JLabel();
    private JLabel      birthLabel  = new JLabel();
    private JLabel      majorLabel  = new JLabel();
    private JLabel      schoolLabel = new JLabel();
    private JLabel      yearLabel   = new JLabel();  

    public MainControl  control     = new MainControl();
    private SkillsFrame skillsFrame;

    public MainFrame(){
        this.setTitle(judegYear());
        this.setFrame();
        this.setMenu();
        this.mainLayout();
        this.setSkilsFrame();
        //this.setVisible(true);
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
        this.setSize(500,700);
    }

    private void setMenu(){
        menuBar.add(courseMenu);
        menuBar.add(skillsMenu);
        // courseMenu.add(compItem);
        // courseMenu.add(eleItem);
        this.setJMenuBar(menuBar);
    }

    public void showInfo(){
        //Wait LoginControl to input the valid studentID
        control.readInfo();
        nameLabel.setText(control.stu.getName());
        birthLabel.setText(Integer.toString(control.stu.getBirth()));
        majorLabel.setText(control.stu.getMajor());
        schoolLabel.setText(control.stu.getSchool());
        yearLabel.setText(Integer.toString(control.stu.getYear()));
    }

    private void mainLayout(){
        this.add(mainPalne);
        mainPalne.setLayout(null);

        //showInfo();
        nameLabel.setBounds(30, 20, 50, 50);
        mainPalne.add(nameLabel);

        birthLabel.setBounds(80, 20, 50, 50);
        mainPalne.add(birthLabel);

        majorLabel.setBounds(130, 20, 150, 50);
        mainPalne.add(majorLabel);

        schoolLabel.setBounds(280, 20, 100, 50);
        mainPalne.add(schoolLabel);

        yearLabel.setBounds(400, 20, 100, 50);
        mainPalne.add(yearLabel);
    }

    private void setSkilsFrame(){
        skillsMenu.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent e){        
                skillsFrame = new SkillsFrame(control.stu.getID());
            }
        });
    }
}
