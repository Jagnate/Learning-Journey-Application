/**
 *  Title      : SkillsFrame.java
 *  Description: A class that provides the skills interface for users.
 * 
 *  @author  Zhang Dan
 *  @author Liu yu xuan
 *  @version 1.0
 */
package boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;
import control.SkillsControl;
 
public class SkillsFrame extends JFrame {
 
    private static final long serialVersionUID   = 1L;
	private JCheckBox[]   check;
    private JPanel        p1           		 = new MyDrawPanel();
    private ScrollPane    scrollPane   		 = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
    private JPanel        p2          		 = new JPanel();
    private JProgressBar  jProgressBar;
    private int           value         	 = 0;
    private SkillsControl skillsControl;

    /**
      * This is the constructor of the class.
	  * @param ID the student's ID
      */
    public SkillsFrame(String ID){
        this.init("MySkills",ID);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
      * This method inits the skill user interface.
      * @param ID the stuent's ID number
      * @param title the title for this skill frame
      */
    public void init(String title, String ID){
        skillsControl = new SkillsControl(ID);
        jProgressBar = new JProgressBar(SwingConstants.HORIZONTAL,0,skillsControl.skillslist.size());
        setTitle(title);
        setBounds(100, 100, 350, 450);
        setLayout(new FlowLayout(FlowLayout.CENTER,400,50));
        addSkills();
        setP1();
        setP2();
        setJProgressBar();
        scrollPane.add(p1);
        Container container = getContentPane();
        container.add(scrollPane);
        container.add(p2);  
    }

    /**
      * This is the method of add skills.
      */
    public void addSkills(){
                  check      = new JCheckBox[skillsControl.skillslist.size()];
        boolean[] isSelected = new boolean[skillsControl.skillslist.size()];
        String[]  text       = new String[skillsControl.skillslist.size()];

        for(int j=0;j<skillsControl.skillslist.size();j++){
            text[j]       = skillsControl.skillslist.get(j).getSkillName();
            isSelected[j] = skillsControl.skillslist.get(j).getAccquired();
        }

        for(int i=0; i<skillsControl.skillslist.size(); i++){
            if(isSelected[i]){
                check[i] = new JCheckBox(text[i], true);
            }
            else{
                check[i] = new JCheckBox(text[i]);
            }
        }
        for(int i=0; i<skillsControl.skillslist.size(); i++){
            EventListener[] listeners = check[i].getListeners(MouseListener.class); 
            for (EventListener eventListener : listeners) { 
                check[i].removeMouseListener((MouseListener) eventListener); 
            } 
            check[i].setFocusable(false); 
        }        
    }

    /**
      * This is the method sets table of skills to the interface.
      */
    public void setP1(){
        for (int i = 0; i < skillsControl.skillslist.size(); i++) {
            p1.add(check[i]);
        }
        scrollPane.setBounds(100, 100, 300, 270);
        p1.setLayout(new FlowLayout(FlowLayout.CENTER,400,15));
        p1.setPreferredSize(new Dimension(300,600));
        p1.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    /**
      * This is the method sets progress bar to the interface.
      */
    public void setP2() {
        JLabel jLabel = new JLabel("Completion Progress: ");
        p2.add(jLabel);
        p2.add(jProgressBar);
        p2.setLayout(new FlowLayout());
    }

    /**
      * This is the method sets progress bar which show the process this student has finished .
      */
    public void setJProgressBar(){
        boolean[] tick = new boolean[skillsControl.skillslist.size()];
        this.jProgressBar.setStringPainted(true);
        this.jProgressBar.setFont(new Font("Arial", Font.PLAIN, 18));
        new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < check.length; i++) {
                    if (check[i].isSelected()) {
                    if (!tick[i]){
                        value++;
                        jProgressBar.setValue(value);
                    }
                    tick[i] = true;
                    }
                }
            }
        }).start();
    }
}
