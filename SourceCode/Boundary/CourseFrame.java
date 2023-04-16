//package Boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

//import Control.CourseControl;

public class CourseFrame extends JFrame {
    JPanel       filterSelect = new JPanel();
    JPanel       putTable = new JPanel();
    JPanel       showPercentage = new JPanel();
    JProgressBar jProgressBar;
    JComboBox<String> comboBox1 = new JComboBox<String>();
    JComboBox<String> comboBox2 = new JComboBox<String>();

    CourseControl control;

    public CourseFrame(){
        this.init("MyCourses");
        this.setVisible(true);
    }

    public void init(String title){
        control = new CourseControl();
        jProgressBar = new JProgressBar(SwingConstants.HORIZONTAL,0,control.course1.size());
        setTitle(title);
        setBounds(100, 100, 400, 500);
        setP1();
        setP3();
        setJProgressBar();
        Container container = getContentPane();
        setLayout(new BorderLayout(30,100));
        container.add(filterSelect,BorderLayout.NORTH);
        container.add(putTable,BorderLayout.CENTER);
        container.add(showPercentage,BorderLayout.SOUTH);
    }

    public void setP1(){
        comboBox1.addItem("Completed");
        comboBox1.addItem("Uncompleted");
        comboBox1.setBounds(0,0,200,40);
        filterSelect.add(comboBox1);
        comboBox2.addItem("Required Course");
        comboBox2.addItem("Optional Course");
        comboBox2.setBounds(200,0,200,40);
        filterSelect.add(comboBox2);
//        filterSelect.setLayout(null);
        comboBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Get the selected item from the first JComboBox
                String selectedItem = (String) comboBox1.getSelectedItem();

                // Generate the appropriate table based on the selected item
                if (selectedItem.equals("Completed"))
                {
                    Boolean flag = true;
                    circlec1(flag);
                }
                else if (selectedItem.equals("Uncompleted")) {
                    Boolean flag = false;
                    circlec1(flag);
                }
            }
        });

        comboBox2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Get the selected item from the first JComboBox
                String selectedItem = (String) comboBox1.getSelectedItem();

                // Generate the appropriate table based on the selected item
                if (selectedItem.equals("Required Course"))
                {
                    Boolean flag = true;
                    circlec2(flag);
                }
                else if (selectedItem.equals("Optional Course")) {
                    Boolean flag = false;
                    circlec2(flag);
                }
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
        for(int i=0;i<this.control.course1.size();i++){
            if(this.control.course1.get(i).getCompleted()==true){
                num++;
            }
        }
        return num;
    }


    //public static void main(String[] args) {
    //     CourseFrame test = new CourseFrame();
    //    test.init("");
    //     test.setVisible(true);
    // }

    public void circlec1(boolean flag){
        JTable jTable = new JTable(10,5);
        putTable.add(jTable);
        for(int m=0;m<50;m++) {
            for(int j=0;j<5;j++)
            {
                {
                    for(int i=0;i<10;i++)
                    {
                        if(control.course1.get(m).getCompleted() == flag)
                        {
                            String courseName = control.course1.get(m).getCourseName();
                            jTable.setValueAt(courseName, i, j);
                        }
                    }
                }
            }
        }
    }
     public void circlec2(boolean flag){
         JTable jTable = new JTable(10,5);
         putTable.add(jTable);
        for(int m=0;m<50;m++) {
            for(int j=0;j<5;j++)
            {
                {
                    for(int i=0;i<10;i++)
                    {
                        if(control.course1.get(m).getCourseType() == flag)
                        {
                            String courseName = control.course1.get(m).getCourseName();
                            jTable.setValueAt(courseName, i, j);
                        }
                    }
                }
            }
        }
     }
}
