
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CourseFrame extends JFrame {
    JPanel       p1 = new JPanel();
    JPanel       p2 = new JPanel();
    JPanel       p3 = new JPanel();
    JProgressBar jProgressBar = new JProgressBar(SwingConstants.HORIZONTAL,0,50);
    JComboBox    c1 = new JComboBox();
    JComboBox    c2 = new JComboBox();

    public void init(String title){
        setTitle(title);
        setBounds(100, 100, 400, 500);
        setP1();
        setP3();
        setP2();
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
    }
    public void setP2(){
        JTable jTable = new JTable(10,5);
        p2.add(jTable);

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
        try {
            jProgressBar.setValue(this.progressBarValue());
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
}
