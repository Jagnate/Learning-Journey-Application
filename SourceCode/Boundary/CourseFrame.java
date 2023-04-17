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
    private JTable jTable;

    CourseControl control;

    public CourseFrame(){
        this.init("MyCourses");
        this.setVisible(true);
    }
    

    public void init(String title){
        control = new CourseControl("jp2020213304", 2020);
        jProgressBar = new JProgressBar(SwingConstants.HORIZONTAL,0,control.courselist.size());
        jTable = new JTable(20,5);
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
        this.loadTalbe();
        setTable();
    }

    public void setP1(){
        comboBox1.addItem("All Courses");
        comboBox1.addItem("Completed");
        comboBox1.addItem("Uncompleted");
        comboBox1.setBounds(0,0,200,40);
        filterSelect.add(comboBox1);
        comboBox2.addItem("All courses");
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
        for(int i=0;i<this.control.courselist.size();i++){
            if(this.control.courselist.get(i).getCompleted()==true){
                num++;
            }
        }
        return num;
    }

    //filter: 0 all; 1 
    public void loadTalbe(){
        for(int i=1;i<control.courselist.size()+1;i++){
            jTable.setValueAt(control.courselist.get(i-1).getCourseName(), i, 0);
            jTable.setValueAt(control.courselist.get(i-1).getYear(), i, 1);
            jTable.setValueAt(control.courselist.get(i-1).getCourseType(), i, 2);
            jTable.setValueAt(control.courselist.get(i-1).getCredit(), i, 3);
            jTable.setValueAt(control.courselist.get(i-1).getGPA(), i, 4);
        }
        putTable.add(jTable);
    }

    public void circlec1(boolean flag){
        putTable.remove(jTable);
        String CourseType = "null";
        int i=1;
        for(int m=0;m<22;m++)
        {
            if (control.courselist.get(m).getCompleted() == flag)
            {
                String courseName = control.courselist.get(m).getCourseName();
                int year = control.courselist.get(m).getYear();
                boolean type = control.courselist.get(m).getCourseType();
                int credit = control.courselist.get(m).getCredit();
                int GPA = control.courselist.get(m).getGPA();
                if(type) {
                    CourseType = "Compulsory";
                }
                else {
                    CourseType = "Optional";
                }
                jTable.setValueAt(courseName, i, 0);
                jTable.setValueAt(year, i, 1);
                jTable.setValueAt(CourseType, i, 2);
                jTable.setValueAt(credit, i, 3);
                jTable.setValueAt(GPA, i, 4);
                i++;
            }
        }
        putTable.add(jTable);
    }

     public void circlec2(boolean flag){
         putTable.remove(jTable);
         String CourseType = "null";
         int i=0;
         for(int m=0;m<22;m++)
         {
             if (control.courselist.get(m).getCourseType() == flag)
             {
                 String courseName = control.courselist.get(m).getCourseName();
                 int year = control.courselist.get(m).getYear();
                 boolean type = control.courselist.get(m).getCourseType();
                 int credit = control.courselist.get(m).getCredit();
                 int GPA = control.courselist.get(m).getGPA();
                 jTable.setValueAt(courseName, i, 0);
                 jTable.setValueAt(year, i, 1);
                 if(type) {
                     CourseType = "Compulsory";
                 }
                 else {
                     CourseType = "Optional";
                 }
                 jTable.setValueAt(CourseType, i, 2);
                 jTable.setValueAt(credit, i, 3);
                 jTable.setValueAt(GPA, i, 4);
                 i++;
             }
             m++;
         }
         putTable.add(jTable);
     }


    public void setTable()
    {
        this.jTable.setValueAt("courseName", 0, 0);
        this.jTable.setValueAt("year", 0, 1);
        this.jTable.setValueAt("CourseType", 0, 2);
        this.jTable.setValueAt("credit", 0, 3);
        this.jTable.setValueAt("GPA", 0, 4);
    }
}
