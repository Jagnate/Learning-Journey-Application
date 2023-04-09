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
    JPanel       p2 = new JPanel();
    JProgressBar jProgressBar = new JProgressBar(SwingConstants.HORIZONTAL,0,6);
    int          value = 0;
    boolean[]    tick = new boolean[6];
    boolean[]    isSelected = new boolean[6];

    public void init(String title){
        setTitle(title);
        setBounds(100, 100, 400, 500);
        setLayout(new FlowLayout(FlowLayout.CENTER,400,50));
        addSkills();
        setP1();
        setP2();
        setJProgressBar();
        Container container = getContentPane();
        container.add(p1);
        container.add(p2);
    }

    public void addSkills(){
        check = new JCheckBox[6];
        isSelected[0] = true;
        isSelected[1] = true;
        isSelected[2] = false;
        isSelected[3] = true;
        isSelected[4] = false;
        isSelected[5] = true;
        for(int i=0; i<=5; i++){
            if(isSelected[i]){
                check[i] = new JCheckBox("Skill", true);
            }
            else{
                check[i] = new JCheckBox("Skill");
            }
        }
        for(int i=0; i<=5; i++){
            EventListener[] listeners = check[i].getListeners(MouseListener.class); 
            for (EventListener eventListener : listeners) { 
                check[i].removeMouseListener((MouseListener) eventListener); 
            } 
            check[i].setFocusable(false); 
        }        
    }

    public void setP1(){
        for (int i = 0; i < 6; i++) {
            p1.add(check[i]);
        }
        p1.setLayout(new FlowLayout(FlowLayout.CENTER,400,15));
        p1.setPreferredSize(new Dimension(300,270));
        p1.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void setP2() {
        JLabel jLabel = new JLabel("Completion Progress: ");
        p2.add(jLabel);
        p2.add(jProgressBar);
        p2.setLayout(new FlowLayout());
    }

    public void setJProgressBar(){
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

