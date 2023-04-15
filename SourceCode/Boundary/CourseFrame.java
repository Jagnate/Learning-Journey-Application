
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CourseFrame extends JFrame {
    JPanel       p1 = new JPanel();
    JPanel       p2 = new JPanel();
    JPanel       p3 = new JPanel();
    JProgressBar jProgressBar;
    JComboBox    c1 = new JComboBox();
    JComboBox    c2 = new JComboBox();

    CourseControl control;

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
        container.add(p1,BorderLayout.NORTH);
        container.add(p2,BorderLayout.CENTER);
        container.add(p3,BorderLayout.SOUTH);
    }

    public void setP1(){
        c1.addItem("Completed");
        c1.addItem("Uncompleted");
        c1.setBounds(0,0,200,40);
        p1.add(c1);
        c2.addItem("Required Course");
        c2.addItem("Optional Course");
        c2.setBounds(200,0,200,40);
        p1.add(c2);
//        p1.setLayout(null);
        c1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Get the selected item from the first JComboBox
                String selectedItem = (String) c1.getSelectedItem();

                // Generate the appropriate table based on the selected item
                if (selectedItem.equals("Completed")) {

                    JTable jTable = new JTable(10,5);
                    p2.add(jTable);
                    for(int m=0;m<50;m++)
                    {
                        for(int i=0;i<10;i++)
                        {
                            for(int j=0;j<5;j++)
                            {
                                jTable.setValueAt(control.course1.get(m).getCompleted(), i, j);
                            }
                        }
                    }
                } else if (selectedItem.equals("Uncompleted")) {
                    JTable jTable = new JTable(10,5);
                    p2.add(jTable);
                    for(int m=0;m<50;m++)
                    {
                        for(int i=0;i<10;i++)
                        {
                            for(int j=0;j<5;j++)
                            {
                                jTable.setValueAt(control.course1.get(m).getTolearn(), i, j);
                            }
                        }
                    }
                }
            }
        });

        c2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Get the selected item from the first JComboBox
                String selectedItem = (String) c1.getSelectedItem();

                // Generate the appropriate table based on the selected item
                if (selectedItem.equals("Required Course")) {
                    JTable jTable = new JTable(10,5);
                    p2.add(jTable);
                    for(int m=0;m<50;m++)
                    {
                        for(int i=0;i<10;i++)
                        {
                            for(int j=0;j<5;j++)
                            {
                                {
                                    if(control.course1.get(m).getCourseType() == true)
                                    {
                                        jTable.setValueAt(control.course1.get(m).getCompleted(), i, j);
                                    }
                                }
                            }
                        }
                    }
                } else if (selectedItem.equals("Optional Course")) {
                    JTable jTable = new JTable(10,5);
                    p2.add(jTable);
                    for(int m=0;m<50;m++)
                    {
                        for(int i=0;i<10;i++)
                        {
                            for(int j=0;j<5;j++)
                            {
                                {
                                    if(control.course1.get(m).getCourseType() == false)
                                    {
                                        jTable.setValueAt(control.course1.get(m).getCompleted(), i, j);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }
    public void setP3() {
        JLabel jLabel = new JLabel("Courses Progress: ");
        p3.add(jLabel);
        p3.add(jProgressBar);
        p3.setLayout(new FlowLayout());
    }

    public void setJProgressBar(){
        jProgressBar.setStringPainted(true);
        jProgressBar.setFont(new Font("Arial", Font.PLAIN, 18));
        //try {
            //JProgressBar.setValue(this.progressBarValue());

            jProgressBar.setValue(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int progressBarValue() throws IOException {
        int value = 0;

        FileReader fileReader = new FileReader("course1.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while(bufferedReader.readLine() != null){
            value ++;
        }

        return value;
    }




    public static void main(String[] args) {
        CourseFrame test = new CourseFrame();
        test.init("hi");
        test.setVisible(true);
    }
}
