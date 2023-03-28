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

import Control.MainControl;

public class MainFrame extends JFrame{

    //private String      stuID      = new String();
    
    private JMenuBar    menuBar    = new JMenuBar();
    private JMenu       courseMenu = new JMenu("Courses");
    private JMenuItem   compItem   = new JMenuItem("Compulsory");
    private JMenuItem   eleItem    = new JMenuItem("Elective"); //To be confirmed
    private JPanel      mainPalne  = new JPanel();
    private JLabel      nameLabel  = new JLabel();
    private JLabel      birthLabel = new JLabel();
    private JLabel      majorLabel = new JLabel();
    private JLabel      schoolLabel= new JLabel();
    private JLabel      yearLabel  = new JLabel();  

    private MainControl control    = new MainControl();

    public MainFrame(){
        super("Start your Learning Journey!");
        setFrame();
        setMenu();
        mainLayout();
        //this.setVisible(true);
    }


    private void setFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,700);
    }

    private void setMenu(){
        menuBar.add(courseMenu);
        courseMenu.add(compItem);
        courseMenu.add(eleItem);
        this.setJMenuBar(menuBar);
    }

    private void showInfo(){
        //Wait LoginControl to input the valid studentID
        control.readInfo("jp2020213326");
        nameLabel.setText(control.stu.getName());
        birthLabel.setText(Integer.toString(control.stu.getBirth()));
        majorLabel.setText(control.stu.getMajor());
        schoolLabel.setText(control.stu.getSchool());
        yearLabel.setText(control.stu.getSchool());
    }

    private void mainLayout(){
        this.add(mainPalne);
        mainPalne.setLayout(null);

        showInfo();
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
}
