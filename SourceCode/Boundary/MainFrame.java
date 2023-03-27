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
    
    private JMenuBar    menuBar    = new JMenuBar();
    private JMenu       courseMenu = new JMenu("Courses");
    private JMenuItem   compItem   = new JMenuItem("Compulsory");
    private JMenuItem   eleItem    = new JMenuItem("Elective"); //To be confirmed
    private JPanel      mainPalne  = new JPanel();
    private JLabel      nameLabel   = new JLabel();

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
        control.readInfo("jp2020213326");
        nameLabel.setText(control.stu.getName());
    }

    private void mainLayout(){
        this.add(mainPalne);
        mainPalne.setLayout(null);

        showInfo();
        nameLabel.setBounds(50, 50, 50, 50);
        mainPalne.add(nameLabel);
    }

}
