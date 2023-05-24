package boundary;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;

import control.CourseControl;

public class CourseFrame extends JFrame {
	
    private static final long serialVersionUID = 1L;
    private JPanel	mainJPanel = new JPanel();
    private JProgressBar      jProgressBar;
    private JComboBox<String> comboBox1      = new JComboBox<String>();
    private JComboBox<String> comboBox2      = new JComboBox<String>();
    private String[]          tableHeader    = {"Course","year","Type","Credit","GPA"};
    private JButton           refreshButton  = new JButton("Refresh");
    private JButton           analysisButton = new JButton("Analysis");
    private JScrollPane		  scrollPane;
    private JLabel			  progressJLabel = new JLabel("Completion: ");
    private JLabel			  gpaJLabel 	 = new JLabel("GPA: ");

    private JTable jTable;
    private int[] filter = {-1,-1};  

    private CourseControl control;
    private LineFrame line ;

    public CourseFrame(String ID,int year){
    	super("My Courses");
        control = new CourseControl(ID, year);
        jProgressBar = new JProgressBar(SwingConstants.HORIZONTAL,0,control.courselist.size());
        this.setTable();
        this.setLayout();
        this.setListner();
        this.setFrame();
    }
    
    private void setLayout() {
    	this.add(mainJPanel);
    	mainJPanel.setLayout(null);
    	
    	comboBox1.addItem("All Courses");
        comboBox1.addItem("Completed");
        comboBox1.addItem("Uncompleted");
        comboBox1.setBounds(0,0,130,50);
        comboBox1.setSelectedIndex(0);
        mainJPanel.add(comboBox1);
        
        comboBox2.addItem("All Courses");
        comboBox2.addItem("Compulsory");
        comboBox2.addItem("Optional");
        comboBox2.setBounds(130,0,130,50);
        comboBox2.setSelectedIndex(0);
        mainJPanel.add(comboBox2);
        
        analysisButton.setBounds(260,5,80,40);
        mainJPanel.add(analysisButton);
        refreshButton.setBounds(340,5,80,40);
        mainJPanel.add(refreshButton);
        
        scrollPane.setBounds(10,60,400,300);
        mainJPanel.add(scrollPane);
        
        progressJLabel.setBounds(10, 370,200, 40);
        mainJPanel.add(progressJLabel);
        
        jProgressBar.setBounds(100, 370, 200, 50);
        this.setJProgressBar();
        mainJPanel.add(jProgressBar);
        
        gpaJLabel.setBounds(320, 370, 100, 50);
        mainJPanel.add(gpaJLabel);
        gpaJLabel.setText("GPA: "+control.getGPA());
    	
    }
    
    private void setFrame() {
    	this.setSize(420,450);
    	this.setVisible(true);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void setListner() {
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
            	line = new LineFrame("Your Trend",control.GPA);
            	line.chart();
            }
        });
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
        for(int m=0;m<control.courselist.size();m++)
        {
            for(int n=0;n<5;n++)
            {
            	
                jTable.setValueAt(null, m, n);
            }
        }//清空
        int j=0;
        for(int i=0;i<control.courselist.size();i++)
        {
            if(filter[0]==-1&filter[1]==0)//所有必修
            {
                if(control.courselist.get(i).getCourseType()==true){
                    doTable(i,j);
                    j++;
                }
            }else if(filter[0]==-1&filter[1]==1)//所有选修
            {
                if(control.courselist.get(i).getCourseType()==false){
                    doTable(i,j);
                    j++;
                }
            }else if(filter[0]==0&filter[1]==-1){
                if(control.courselist.get(i).getCompleted()==true){
                    doTable(i,j);
                    j++;
                }
            }else if(filter[0]==0&filter[1]==0){
                if(control.courselist.get(i).getCourseType()==true&control.courselist.get(i).getCompleted()==true){
                    doTable(i,j);
                    j++;
                }
            }else if(filter[0]==0&filter[1]==1){
                if(control.courselist.get(i).getCourseType()==false&control.courselist.get(i).getCompleted()==true){
                    doTable(i,j);
                    j++;
                }
            }else if(filter[0]==1&filter[1]==-1){
                if(control.courselist.get(i).getCompleted()==false) {
                    doTable(i,j);
                    j++;
                }
            }else if(filter[0]==1&filter[1]==0){
                if(control.courselist.get(i).getCourseType()==true&control.courselist.get(i).getCompleted()==false){
                    doTable(i,j);
                    j++;
                }
            }else if(filter[0]==1&filter[1]==1){
                if(control.courselist.get(i).getCourseType()==false&control.courselist.get(i).getCompleted()==false){
                    doTable(i,j);
                    j++;
                }
            }else if(filter[0]==-1&filter[1]==-1)
            {
                if(true) {
                    doTable(i,j);
                    j++;
                }
            }
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
    	String[][] dataStrings = new String[control.courselist.size()][5] ;
    	System.out.println(control.courselist.size());
        for(int i=0;i<control.courselist.size();i++) {
        	dataStrings[i][0] = control.courselist.get(i).getCourseName();
        	dataStrings[i][1] =	Integer.toString(control.courselist.get(i).getYear());
        	dataStrings[i][2] = convert(control.courselist.get(i).getCourseType());
        	dataStrings[i][3] = Integer.toString(control.courselist.get(i).getCredit());
        	dataStrings[i][4] = Integer.toString(control.courselist.get(i).getGPA());
        }
        jTable = new JTable(dataStrings,tableHeader);
        this.setcolum();
        scrollPane = new JScrollPane(jTable);
    }
    
    private void doTable(int i,int j)
    {
        this.jTable.setValueAt(control.courselist.get(i).getCourseName(), j, 0);
        this.jTable.setValueAt(Integer.toString(control.courselist.get(i).getYear()), j, 1);
        this.jTable.setValueAt(convert(control.courselist.get(i).getCourseType()), j, 2);
        this.jTable.setValueAt(Integer.toString(control.courselist.get(i).getCredit()), j, 3);
        this.jTable.setValueAt(Integer.toString(control.courselist.get(i).getGPA()), j, 4);
    }
    
}