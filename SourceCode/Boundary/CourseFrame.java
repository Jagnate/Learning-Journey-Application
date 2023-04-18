package Boundary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

import Control.CourseControl;

public class CourseFrame extends JFrame {
    JPanel       filterSelect = new JPanel();
    JPanel       putTable = new JPanel();
    JPanel       showPercentage = new JPanel();
    JProgressBar jProgressBar;
    JComboBox<String> comboBox1 = new JComboBox<String>();
    JComboBox<String> comboBox2 = new JComboBox<String>();
    String[] tableHeader = {"Course","year","Type","Credit","GPA"};
    String[][] info;

    private JTable jTable;
    private int[] filter = {-1,-1};  

    CourseControl control;

    public CourseFrame(String ID,int year){
        control = new CourseControl(ID, year);
        jProgressBar = new JProgressBar(SwingConstants.HORIZONTAL,0,control.courselist.size());
        this.init();
        this.setVisible(true);
    }
    

    public void init(){
        jTable = new JTable(20,5);
        setTitle("MyCourses");
        setBounds(100, 100, 400, 500);
        setP1();
        setP3();
        setJProgressBar();
        Container container = getContentPane();
        setLayout(new BorderLayout(30,100));
        container.add(filterSelect,BorderLayout.NORTH);
        container.add(putTable,BorderLayout.CENTER);
        container.add(showPercentage,BorderLayout.SOUTH);
        setTable();
        this.loadTable();
    }

    public void setP1(){
        comboBox1.addItem("All Courses");
        comboBox1.addItem("Completed");
        comboBox1.addItem("Uncompleted");
        comboBox1.setBounds(0,0,200,40);
        comboBox1.setSelectedIndex(0);
        filterSelect.add(comboBox1);
        comboBox2.addItem("All Courses");
        comboBox2.addItem("Compulsory");
        comboBox2.addItem("Optional");
        comboBox2.setBounds(200,0,200,40);
        comboBox2.setSelectedIndex(0);
        filterSelect.add(comboBox2);

        comboBox1.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(comboBox1.getSelectedItem().equals("Completed")){
                    filter[0]=0;
                }else if(comboBox1.getSelectedItem().equals("Uncompleted")){
                    filter[0]=1;
                }else{
                    filter[0]=-1;
                }
                loadTable();
                refresh();
            }
        });
        
        comboBox2.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(comboBox2.getSelectedItem().equals("Compulsory")){
                    filter[1]=0;
                }else if(comboBox2.getSelectedItem().equals("Optional")){
                    filter[1]=1;
                }else{
                    filter[1]=-1;
                }
                loadTable();
                refresh();
                //System.out.println("!!");
            }
        });
    }
    public void setP3() {
        JLabel jLabel = new JLabel("Courses Progress: ");
        showPercentage.add(jLabel);
        showPercentage.add(jProgressBar);
        showPercentage.setLayout(new FlowLayout());
    }

    public void setJProgressBar(){
        jProgressBar.setStringPainted(true);
        jProgressBar.setFont(new Font("Arial", Font.PLAIN, 18));
        jProgressBar.setValue(completedCourse());
    }

    public int completedCourse(){
        int num = 0;
        for(int i=0;i<this.control.courselist.size();i++){
            if(this.control.courselist.get(i).getCompleted()==true){
                num++;
            }
        }
        System.out.println(num);
        return num;
    }

    //filter: 0 all; 1 
    public void loadTable(){
        int j=0;
        for(int i=1;i<control.courselist.size()+1;i++){
            if(filter[0]==-1&filter[1]==0){
                if(!control.courselist.get(i-1).getCourseType()){
                    i++;
                    j--;
                }
            }else if(filter[0]==-1&filter[1]==1){
                if(control.courselist.get(i-1).getCourseType()){
                    i++;
                    j--;
                }
            }else if(filter[0]==0&filter[1]==-1){
                if(!control.courselist.get(i-1).getCompleted()){
                    i++;
                    j--;
                }
            }else if(filter[0]==0&filter[1]==0){
                if(!control.courselist.get(i-1).getCourseType()||!control.courselist.get(i-1).getCompleted()){
                    i++;
                    j--;
                }
            }else if(filter[0]==0&filter[1]==1){
                if(!control.courselist.get(i-1).getCourseType()||control.courselist.get(i-1).getCompleted()){
                    i++;
                    j--;
                }
            }else if(filter[0]==1&filter[1]==-1){
                if(control.courselist.get(i-1).getCourseType()){
                    i++;
                    j--;
                }
            }else if(filter[0]==1&filter[1]==0){
                if(control.courselist.get(i-1).getCourseType()||!control.courselist.get(i-1).getCompleted()){
                    i++;
                    j--;
                }
            }else if(filter[0]==1&filter[1]==1){
                if(control.courselist.get(i-1).getCourseType()||control.courselist.get(i-1).getCompleted()){
                    i++;
                    j--;
                }
            }else if(filter[0]==-1&filter[1]==-1){
                jTable.setValueAt(control.courselist.get(i-1).getCourseName(), i, 0);
                jTable.setValueAt(control.courselist.get(i-1).getYear(), i, 1);
                jTable.setValueAt(convert(control.courselist.get(i-1).getCourseType()), i, 2);
                jTable.setValueAt(control.courselist.get(i-1).getCredit(), i, 3);
                jTable.setValueAt(control.courselist.get(i-1).getGPA(), i, 4);
            }
            j++;
            infoDefine(j, i);
            //System.out.println(i);
        }
    }

    public void infoDefine(int j,int i){
        info = new String[control.courselist.size()+1][5];
        info[j][0]=control.courselist.get(i-1).getCourseName();
        info[j][1]=Integer.toString(control.courselist.get(i-1).getYear());
        info[j][2]=convert(control.courselist.get(i-1).getCourseType());
        info[j][3]=Integer.toString(control.courselist.get(i-1).getCredit());
        info[j][4]=Integer.toString(control.courselist.get(i-1).getGPA());
    }

    public String convert(Boolean type){
        String res;
        if(type){
            res = "Compulsory";
        }else{
            res = "Optional";
        }
        return res;
    }

    public void refresh(){
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setDataVector(info, tableHeader);
        jTable.updateUI();
    }

    public void setTable()
    {
        this.jTable.setValueAt("Course", 0, 0);
        this.jTable.setValueAt("Year", 0, 1);
        this.jTable.setValueAt("Type", 0, 2);
        this.jTable.setValueAt("Credit", 0, 3);
        this.jTable.setValueAt("GPA", 0, 4);
        putTable.add(jTable);
    }
}
