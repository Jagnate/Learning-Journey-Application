package Ach;

/**
 * @version 1.1
 * @auther ZhangDan
 * @data 2023/4/8 14:59
 */


 import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

 public class AchFrame extends JFrame {

     JPanel p1 = new JPanel();
     JPanel p2 = new JPanel();
     JPanel p3 = new JPanel();
     JPanel p4 = new JPanel();
     JPanel center = new JPanel();
 

     
     public void init(String title){
        setBounds(0, 0, 400, 500);
        setTitle(title);
        setP1();
        setP2();
        setP3();
        setP4();
        setC();
        this.getContentPane().add(p1,BorderLayout.NORTH);
        this.getContentPane().add(center);
        this.getContentPane().add(p4,BorderLayout.SOUTH);
        this.getContentPane().setBounds(100, 100, 400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         
     }
     public void addSkills(){
         
     }
 
     public void setP1(){
         JLabel title = new JLabel("Achievements");
         title.setFont(new Font("Arial",Font.BOLD,25));
         
        //  Icon icon = new ImageIcon("refresh.jpeg");
         JButton refresh = new JButton();
         refresh.setIcon(new ImageIcon("/Users/sophia/Documents/SoftwareProject/Ach/refresh.jpeg"));
         refresh.setBorderPainted(false);
         refresh.setPreferredSize(new Dimension(20, 20));
    
        
         p1.setLayout(new FlowLayout(FlowLayout.RIGHT,55,20));
         p1.add(title);
         p1.add(refresh);
     }
 
     public void setP2() {
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.setRowCount(5);
        defaultTableModel.setColumnCount(1);
        // defaultTableModel.setDataVector();
        JLabel acquired = new JLabel("Acquired Achievement: ");
        JTable jTable1 = new JTable(defaultTableModel);
        acquired.setFont(new Font("Arial",Font.BOLD,15));
        jTable1.setGridColor(Color.BLACK);
        jTable1.setRowHeight(23);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(340);
        p2.setLayout(new FlowLayout(FlowLayout.LEFT,30,10));
        p2.add(acquired);
        p2.add(jTable1);
        
    
     }



     public void setP3() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.setRowCount(5);
        defaultTableModel.setColumnCount(1);
        // defaultTableModel.setDataVector();
        JLabel suggest = new JLabel("Suggested Achievement: ");
        JTable jTable2 = new JTable(defaultTableModel);
        suggest.setFont(new Font("Arial",Font.BOLD,15));
        jTable2.setGridColor(Color.BLACK);
        jTable2.setRowHeight(23);
        jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(340);
        p3.setLayout(new FlowLayout(FlowLayout.LEFT,30,10));
        p3.add(suggest);
        p3.add(jTable2);
     }

     public void setP4() {
         Button input = new Button("Import");
         Button export = new Button("Export");
         p4.add(input);
         p4.add(export);
         p4.setLayout(new FlowLayout(FlowLayout.CENTER,40,30));
     }

     public void setC(){
        center.add(p2);
        center.add(p3);
        center.setLayout(new GridLayout(2, 1));
     }
 
 
 
 }
 
 