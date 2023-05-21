/**
 * A class that provides a login and register interface for users.
 * @author Yuxuan Liu
 * @version 1.0
 *
 */

 package boundary; 

 import java.awt.*;
 import java.awt.event.*;
 import java.awt.image.BufferedImage;
 import javax.swing.*;
 import java.net.URL;
 
 import control.*;
 
 public class LoginFrame extends JFrame implements MouseListener
 {
     // create a content panel component to add other components
     // create button components
     // create label components to provide information
     // create url, icon, image ,buffered image to resize and sett icon components
     // create textField components to collect input
 
     private static final long serialVersionUID = 1L;
 
     private JPanel            contentPanel = new JPanel();
     // private JPanel         contentPanel = new MyDrawPanel();
     
     private JButton           login        = new JButton("I'm ready!");
     private JButton           hint         = new JButton();
     private GradientTextPanel title        = new GradientTextPanel();
     // private JLabel title = new JLabel("Log In");
 
     private JLabel            accHint      = new JLabel("Student ID:");
     private URL               urlAcc       = LoginFrame.class.getResource("iconAcc.png");
     private Icon              iconAcc      = new ImageIcon(urlAcc); 
     private Image             imgAcc       = ((ImageIcon)iconAcc).getImage();
     private int               widthAcc     = imgAcc.getWidth(null);
     private int               heightAcc    = imgAcc.getWidth(null);
     private BufferedImage     tagAcc       = new BufferedImage((int)(0.01 * widthAcc), (int)(0.01 * heightAcc),BufferedImage.TYPE_INT_RGB);
     private Icon              newIconAcc   = new ImageIcon(tagAcc);
 
     private JLabel            pswHint      = new JLabel("Password:");
     private URL               urlPsw       = LoginFrame.class.getResource("iconPsw.png");
     private Icon              iconPsw      = new ImageIcon(urlPsw); 
     private Image             imgPsw       = ((ImageIcon)iconPsw).getImage();
     private int               widthPsw     = imgPsw.getWidth(null);
     private int               heightPsw    = imgPsw.getWidth(null);
     private BufferedImage     tagPsw       = new BufferedImage((int)(0.015 * widthPsw), (int)(0.015 * heightPsw),BufferedImage.TYPE_INT_RGB);
     private Icon              newIconPsw   = new ImageIcon(tagPsw);
 
     private JLabel            forgetHint   = new JLabel("Forget your password?", SwingConstants.CENTER);
     private JTextField        accNum       = new JTextField();
     private JTextField        psw          = new JPasswordField();
 
     private MainFrame mainFrame;
 
     private LoginControl logincontrol      = new LoginControl();
 
     /**
      * This is the constructor of the class.
      */
     public LoginFrame(){
         this.init();
         this.addListener();
     }
 
     /**
      * This method inits the user interface.
      */
     public void init(){
         this.setPanel();
         this.setAcc();
         this.setPsw();
         this.setLogin();
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setResizable(false);
     }
 
     // /**
     //  * This method sets the format of JTextField.
     //  * @param field to be set
     //  */
     // private void textSet(JTextField field) {
     //     field.setBackground(new Color(255, 255, 255));
     //     field.setPreferredSize(new Dimension(150, 28));
     //     MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192, 192));
     //     field.setBorder(border);
     // }
 
     public void setPanel(){
         this.setTitle("Log In");
         this.setSize(350, 400);
         contentPanel.setLayout(null);
         add(title);
         add(accHint);
         add(accNum);
         add(pswHint);
         add(psw);
         add(forgetHint);
         add(login);
         add(hint);
         title.setBounds(25, 10, 310, 200);
         contentPanel.setOpaque(false);
         getContentPane().add(contentPanel);
     }
 
     public void setAcc(){
         accHint.setBounds(40, 130, 100, 25);
         accHint.setForeground(new Color(25,25,112));
         accHint.setIcon(newIconAcc);
         tagAcc.getGraphics().drawImage(imgAcc, 0, 0, (int)(0.01 * widthAcc), (int)(0.01 * heightAcc), null); 
         accNum.setBounds(160, 130, 150, 25);
         accNum.setOpaque(true);
     }
 
     public void setPsw(){
         pswHint.setBounds(40, 200, 100, 25);
         pswHint.setForeground(new Color(25,25,112));
         pswHint.setIcon(newIconPsw);
         tagPsw.getGraphics().drawImage(imgPsw, 0, 0, (int)(0.015 * widthPsw), (int)(0.015 * heightPsw), null);
         psw.setBounds(160, 200, 150, 25);
         ((JPasswordField) psw).setEchoChar('\0');
         ((JPasswordField) psw).setEchoChar('*');
         forgetHint.setBounds(0, 240, 350, 25);
         forgetHint.setForeground(new Color(25,25,112));
         psw.setOpaque(true);
         hint.setBounds(325,205,17,17);
         hint.setOpaque(true);
         hint.setBackground(Color.blue);
         hint.setText("?");
         hint.addMouseListener(this);
     }
 
     public void setLogin(){
         login.setOpaque(true);
         login.setBounds(75, 275, 200, 50);
         login.setBackground(new Color(200,200,221));
         login.setBorder(BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
 
     }
     /**
      * This method sets event listening.
      */
     public void addListener(){
         login.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 loginControl();
             }
         });
 
         forgetHint.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e){
                 int length = logincontrol.getLength(accNum.getText());
                 if(length == -1){
                     JOptionPane.showMessageDialog(null, "Hint: Please input your ID firstly! ", "hint", JOptionPane.INFORMATION_MESSAGE);
                 }else
                 JOptionPane.showMessageDialog(null, "Hint: The length of your passwords is "+length, "hint", JOptionPane.INFORMATION_MESSAGE);
                     
 
             }
         });
     }
 
     public void mouseEntered(MouseEvent e) {
         ((JPasswordField) psw).setEchoChar('\0');
         System.out.println("111");
     }
     public void mouseClicked(MouseEvent e){}
     public void mouseReleased(MouseEvent e){}
     public void mousePressed(MouseEvent e){}
     public void mouseExited(MouseEvent e){
         ((JPasswordField) psw).setEchoChar('*');
     }
 
     public void loginControl(){
         String tempID = logincontrol.checkID(accNum.getText(),psw.getText());
         if(tempID.equals("1")){
             JOptionPane.showMessageDialog(null, "Wrong password!");
         }
         else  if(tempID.equals("-1")){
             JOptionPane.showMessageDialog(null, "Opps, not Found StudentID!");
         }
         else{
             mainFrame = new MainFrame();
             mainFrame.control.stu.setID(tempID);
             mainFrame.showInfo();
             JOptionPane.showMessageDialog(null, "Welcome! "+mainFrame.control.stu.getName()+"!");
             mainFrame.setVisible(true);
             this.dispose();
         }
     }
 }
