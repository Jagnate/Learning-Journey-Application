/**
 * @version 2.1
 * @auther ZhangDan, Liu Yuxuan
 * @data 2023/4/8 14:59
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.awt.event.MouseListener;
 
public class SkillsFrame extends JFrame {
 
    JCheckBox[]  check;
    JPanel       p1 = new JPanel();
    ScrollPane   scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
    JPanel       p2 = new JPanel();
    JProgressBar jProgressBar;
    int          value = 0;
    
    SkillsControl skillsControl;

    public void init(String title){
    skillsControl = new SkillsControl("jp2020213326");
    jProgressBar = new JProgressBar(SwingConstants.HORIZONTAL,0,skillsControl.skillslist.size());
        setTitle(title);
        setBounds(100, 100, 400, 500);
        setLayout(new FlowLayout(FlowLayout.CENTER,400,50));
        addSkills();
        setP1();
        setP2();
        setJProgressBar();
        scrollPane.add(p1);
        Container container = getContentPane();
        container.add(scrollPane);
        // container.add(p1);
        container.add(p2);
    }

    public void addSkills(){
        check = new JCheckBox[skillsControl.skillslist.size()];
        boolean[]    isSelected = new boolean[skillsControl.skillslist.size()];
        String[] text = new String[skillsControl.skillslist.size()];
        for(int j=0;j<skillsControl.skillslist.size();j++){
        text[j] = skillsControl.skillslist.get(j).getSkillName();
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

    public void setP1(){
        for (int i = 0; i < skillsControl.skillslist.size(); i++) {
            p1.add(check[i]);
        }
        scrollPane.setBounds(100, 100, 300, 270);
        p1.setLayout(new FlowLayout(FlowLayout.CENTER,400,15));
        p1.setPreferredSize(new Dimension(300,600));
        p1.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void setP2() {
        JLabel jLabel = new JLabel("Completion Progress: ");
        p2.add(jLabel);
        p2.add(jProgressBar);
        p2.setLayout(new FlowLayout());
    }

    public void setJProgressBar(){
    boolean[]    tick = new boolean[skillsControl.skillslist.size()];
        jProgressBar.setStringPainted(true);
        jProgressBar.setFont(new Font("Arial", Font.PLAIN, 18));
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
