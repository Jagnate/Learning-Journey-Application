package boundary;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;

import control.CourseControl;
import control.LineControl;

public class CourseFrame extends JFrame {
    private static final long serialVersionUID = 1L;
	private JPanel            filterSelect   = new JPanel();
    private JPanel            putTable       = new JPanel();
    private JPanel            showPercentage = new JPanel();
    private JProgressBar      jProgressBar;
    private JComboBox<String> comboBox1      = new JComboBox<String>();
    private JComboBox<String> comboBox2      = new JComboBox<String>();
    //private String[]          tableHeader    = {"Course","year","Type","Credit","GPA"};
    private ImageIcon iconRef = new ImageIcon("iconRef.png");
    private JButton           refreshButton  = new JButton("Refresh");
    private JButton           analysisButton = new JButton("Analysis");
    private String[][]        info;

    private JTable jTable;
    private int[] filter = {-1,-1};  

    private CourseControl control;
    private LineControl line;

    public CourseFrame(String ID,int year){
        control = new CourseControl(ID, year);
        jProgressBar = new JProgressBar(SwingConstants.HORIZONTAL,0,control.courselist.size());
        this.init();
        this.setVisible(true);
        this.setResizable(false);
    }
    

    public void init(){
        jTable = new JTable(20,5);
        setTitle("MyCourses");
        setBounds(100, 100, 450, 500);
        setP1();
        setP2();
        setJProgressBar();
        Container container = getContentPane();
        setLayout(new BorderLayout(30,100));
        container.add(filterSelect,BorderLayout.NORTH);
        container.add(putTable,BorderLayout.CENTER);
        container.add(showPercentage,BorderLayout.SOUTH);
        setTable();
        putTable.add(jTable);
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
        refreshButton.setIcon(iconRef);
        analysisButton.setBounds(300,0,40,40);
        filterSelect.add(analysisButton);
        refreshButton.setBounds(400,0,40,40);
        filterSelect.add(refreshButton);



        refreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(comboBox1.getSelectedItem().equals("Completed")){
                    filter[0]=0;
                }else if(comboBox1.getSelectedItem().equals("Uncompleted")){
                    filter[0]=1;
                }else{
                    filter[0]=-1;
                }
                if(comboBox2.getSelectedItem().equals("Compulsory")){
                    filter[1]=0;
                }else if(comboBox2.getSelectedItem().equals("Optional")){
                    filter[1]=1;
                }else{
                    filter[1]=-1;
                }
                System.out.println(filter[0]+" "+filter[1]);
                loadTable();

            }
        });

        analysisButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                line.chart();
            }
        });
    }
    public void setP2() {
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
        return num;
    }

    //filter: 0 all; 1 
    public void loadTable(){
        for(int m=0;m<control.courselist.size()+1;m++)
        {
            for(int n=0;n<5;n++)
            {
                jTable.setValueAt(null, m + 1, n);
            }
        }//清空
        setTable();
        int j=0;
        for(int i=1;i<control.courselist.size()+1;i++)
        {
            if(filter[0]==-1&filter[1]==0)//所有必修
            {
                if(!control.courselist.get(i-1).getCourseType()){
                    //i++;
                    j--;
                    continue;
                }
            }else if(filter[0]==-1&filter[1]==1)//所有选修
            {
                if(control.courselist.get(i-1).getCourseType()){
                    //i++;
                    j--;
                    continue;
                }
            }else if(filter[0]==0&filter[1]==-1){
                if(!control.courselist.get(i-1).getCompleted()){
                    //i++;
                    j--;
                    continue;
                }
            }else if(filter[0]==0&filter[1]==0){
                if(!control.courselist.get(i-1).getCourseType()||!control.courselist.get(i-1).getCompleted()){
                    //i++;
                    j--;
                    System.out.println(1);
                    continue;
                }
            }else if(filter[0]==0&filter[1]==1){
                if(!control.courselist.get(i-1).getCourseType()||control.courselist.get(i-1).getCompleted()){
                    //i++;
                    j--;
                    continue;
                }
            }else if(filter[0]==1&filter[1]==-1){
                if(control.courselist.get(i-1).getCourseType()){
                    //i++;
                    j--;
                    continue;
                }
            }else if(filter[0]==1&filter[1]==0){
                if(control.courselist.get(i-1).getCourseType()||!control.courselist.get(i-1).getCompleted()){
                    //i++;
                    j--;
                    continue;
                }
            }else if(filter[0]==1&filter[1]==1){
                if(control.courselist.get(i-1).getCourseType()||control.courselist.get(i-1).getCompleted()){
                    //i++;
                    j--;
                    continue;
                }
            }else if(filter[0]==-1&filter[1]==-1)
            {
                if(!control.courselist.get(i-1).getCourseType()||!control.courselist.get(i-1).getCompleted()) {
                    //i++;
                    j--;
                    continue;
                }
            }
            j++;
            jTable.setValueAt(control.courselist.get(i-1).getCourseName(), j, 0);
            jTable.setValueAt(control.courselist.get(i-1).getYear(), j, 1);
            jTable.setValueAt(convert(control.courselist.get(i-1).getCourseType()), j, 2);
            jTable.setValueAt(control.courselist.get(i-1).getCredit(), j, 3);
            jTable.setValueAt(control.courselist.get(i-1).getGPA(), j, 4);


        }
    }

    private String convert(Boolean type){
        String res;
        if(type){
            res = "Compulsory";
        }else{
            res = "Optional";
        }
        return res;
    }//转换


    private void setcolum()//设置列宽度
    {
        TableColumn column1 = jTable.getColumnModel().getColumn(0);
        column1.setPreferredWidth(200);
        TableColumn column2 = jTable.getColumnModel().getColumn(1);
        column2.setPreferredWidth(40);
        TableColumn column3 = jTable.getColumnModel().getColumn(2);
        column3.setPreferredWidth(80);
        TableColumn column4 = jTable.getColumnModel().getColumn(3);
        column4.setPreferredWidth(40);
        TableColumn column5 = jTable.getColumnModel().getColumn(4);
        column5.setPreferredWidth(40);
    }

    private void setTable()//初始化表格
    {
        //this.jTable.setEnabled(false);
        this.setcolum();
        this.jTable.setValueAt("Course", 0, 0);
        this.jTable.setValueAt("Year", 0, 1);
        this.jTable.setValueAt("Type", 0, 2);
        this.jTable.setValueAt("Credit", 0, 3);
        this.jTable.setValueAt("GPA", 0, 4);
        this.putTable.add(jTable);
    }

}
