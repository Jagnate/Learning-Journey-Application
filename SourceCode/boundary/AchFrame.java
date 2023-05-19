package boundary;

/**
* @version 1.1
* @auther ZhangDan, Liu yuxuan
* @data 2023/4/8 14:59
*/


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

public class AchFrame extends JFrame {

   private static final long serialVersionUID = 1L;
JPanel p1 = new JPanel();
   JPanel p2 = new JPanel();
   JPanel p3 = new JPanel();
   JPanel p4 = new JPanel();
   JPanel center = new JPanel();
   JButton input = new JButton("Import");
   String inputContent = "";
   
   public AchFrame(String input) {
 // TODO Auto-generated constructor stub
    this.init("MyAchievement",input);
     this.setVisible(true);
     // frame.setSize(500, 500);
     this.setResizable(false);
}
   
   public void init(String title, String input){
      setBounds(0, 0, 400, 500);
      setTitle(title);
      setP1();
      setP2(input);
      setP3();
      setP4();
      setC();
      this.getContentPane().add(p1,BorderLayout.NORTH);
      this.getContentPane().add(center);
      this.getContentPane().add(p4,BorderLayout.SOUTH);
      this.getContentPane().setBounds(100, 100, 400, 500);
      //setDefaultCloseOperation(EXIT_ON_CLOSE);
       
   }
   public void addSkills(){
       
   }

   public void setP1(){
       JLabel title = new JLabel("Achievements");
       title.setFont(new Font("Arial",Font.BOLD,25));
       
      //  Icon icon = new ImageIcon("refresh.jpeg");
       JButton refresh = new JButton();
       refresh.setIcon(new ImageIcon("/Users/sijin/eclipse-workspace/Learning_Journey_Application/src/boundary/refresh.jpeg"));
       refresh.setBorderPainted(false);
       refresh.setPreferredSize(new Dimension(20, 20));
  
      
       p1.setLayout(new FlowLayout(FlowLayout.RIGHT,55,20));
       p1.add(title);
       p1.add(refresh);
   }

   DefaultTableModel defaultTableModel = new DefaultTableModel();

   Vector<String> columns = new Vector<>(); 
   Vector<Vector<Object>> data = new Vector<>();
   Vector<Object> rowVector1 = new Vector<>();
   Vector<Object> rowVector2 = new Vector<>();
   Vector<Object> rowVector3 = new Vector<>();
   Vector<Object> rowVector4 = new Vector<>();
   Vector<Object> rowVector5 = new Vector<>();
   JTable jTable1 = new JTable(defaultTableModel);
   
   public void setP2(String input) {
      
    //   DefaultTableModel defaultTableModel = new DefaultTableModel();
    //   defaultTableModel.setRowCount(5);
    //   defaultTableModel.setColumnCount(1);
       // Vector<String> columns = new Vector<>(); 
       columns.addElement("");

       // Vector<Vector<Object>> data = new Vector<>();
       // Vector<Object> rowVector1 = new Vector<>();
       rowVector1.addElement("National English Contest for College Students");
       // Vector<Object> rowVector2 = new Vector<>();
       rowVector2.addElement("Mathematical Contest In Modeling");
       // Vector<Object> rowVector3 = new Vector<>();
       rowVector3.addElement("Student Supercomputer Challenge");
       // Vector<Object> rowVector4 = new Vector<>();
       rowVector4.addElement("'Internet+'Innovation and Entrepreneurship Competition");
       // Vector<Object> rowVector5 = new Vector<>();
        rowVector5.addElement(input);

       data.addElement(rowVector1);
       data.addElement(rowVector2);
       data.addElement(rowVector3);
       data.addElement(rowVector4);
       data.addElement(rowVector5);

       defaultTableModel.setDataVector(data, columns);
      JLabel acquired = new JLabel("Acquired Achievement: ");

    //   JTable jTable1 = new JTable(defaultTableModel);

      acquired.setFont(new Font("Arial",Font.BOLD,15));
      jTable1.setGridColor(Color.BLACK);
      jTable1.setRowHeight(23);
      jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      jTable1.getColumnModel().getColumn(0).setPreferredWidth(340);
      jTable1.setEnabled(false);
      p2.setLayout(new FlowLayout(FlowLayout.LEFT,30,10));
      p2.add(acquired);
      p2.add(jTable1);
   }



   public void setP3() {
      DefaultTableModel defaultTableModel = new DefaultTableModel();
      defaultTableModel.setRowCount(5);
      defaultTableModel.setColumnCount(1);
      Vector<String> columns = new Vector<>(); 
       columns.addElement("");

      Vector<Vector<Object>> data = new Vector<>();
       Vector<Object> rowVector31 = new Vector<>();
       rowVector31.addElement("National Undergraduate Electronics Design Contest");
       Vector<Object> rowVector32 = new Vector<>();
       rowVector32.addElement("The Chinese Mathematics Competition");
       Vector<Object> rowVector33 = new Vector<>();
       rowVector33.addElement("China Undergraduate Physics Tournament");
       Vector<Object> rowVector34 = new Vector<>();
       rowVector34.addElement("College student physics Competition");
       Vector<Object> rowVector35 = new Vector<>();
       rowVector35.addElement("");
       data.addElement(rowVector31);
       data.addElement(rowVector32);
       data.addElement(rowVector33);
       data.addElement(rowVector34);
       data.addElement(rowVector35);

       defaultTableModel.setDataVector(data, columns);
  
      JLabel suggest = new JLabel("Suggested Achievement: ");
      JTable jTable2 = new JTable(defaultTableModel);
      suggest.setFont(new Font("Arial",Font.BOLD,15));
      jTable2.setGridColor(Color.BLACK);
      jTable2.setRowHeight(23);
      jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      jTable2.getColumnModel().getColumn(0).setPreferredWidth(340);
      jTable2.setEnabled(false);
      p3.setLayout(new FlowLayout(FlowLayout.LEFT,30,10));
      p3.add(suggest);
      p3.add(jTable2);
   }
   

   public void setP4() {
       
       // Button export = new Button("Export");
       setInputButton();
       p4.add(input);
       // p4.add(export);
       // p4.setLayout(new FlowLayout(FlowLayout.CENTER,40,30));
       
   }

 public void setInputButton(){
    JDialog importDialog = new JDialog();
    JLabel hint = new JLabel("  please import: ");
    JTextField tField = new JTextField(100);
    JButton confirm = new JButton("confirm");
    JButton cancel = new JButton("cancel");
    input.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e){
          importDialog.setBounds(100, 200, 300, 110);
          importDialog.setTitle("importDialog");
          importDialog.getContentPane().setLayout(new GridLayout(2,2));
          importDialog.add(hint);
          importDialog.add(tField);
          importDialog.add(confirm);
          importDialog.add(cancel);
          importDialog.setVisible(true);
          importDialog.setResizable(false);
          
       }
    });
    confirm.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
          inputContent = tField.getText();       
//          rowVector5.addElement(inputContent);
//          data.addElement(rowVector5);
//          // JTable jTable1 = new JTable(defaultTableModel);
//          p2.add(jTable1);
          dispose();
          AchFrame newFrame = new AchFrame(inputContent);
          // System.out.println(inputContent);
       }
    });
    cancel.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e){
          importDialog.setVisible(false);
       }
    });
 }

   public void setC(){
      center.add(p2);
      center.add(p3);
      center.setLayout(new GridLayout(2, 1));
   }

}