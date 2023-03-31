/**
 * A class that provides a login and register interface for users.
 * @author Yuxuan Liu
 * @version 1.0
 * 
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.net.URL;

public class LoginFrame extends JFrame{
	
    private MainControl maincountrol = new MainControl();
    // create a content panel component to add other components
//    private JPanel contentPanel = new JPanel();
    private JPanel contentPanel = new MyDrawPanel();
    // create button components
    private JButton login = new JButton("Log In");
    private JButton register = new JButton("Create your account");
    private JButton hint = new JButton();
   // create label components to provide information
    private GradientTextPanel title = new GradientTextPanel();
//    private JLabel title = new JLabel("Log In");
    private JLabel accHint = new JLabel("Account ID:");
    // create url, icon, image ,buffered image to resize and sett icon components
    private URL urlAcc = LoginFrame.class.getResource("iconAcc.png");
    private Icon iconAcc = new ImageIcon(urlAcc); 
    private Image imgAcc = ((ImageIcon)iconAcc).getImage();
    private int widthAcc = imgAcc.getWidth(null);
    private int heightAcc = imgAcc.getWidth(null);
    private BufferedImage tagAcc = new BufferedImage((int)(0.01 * widthAcc), (int)(0.01 * heightAcc),BufferedImage.TYPE_INT_RGB);
	private Icon newIconAcc = new ImageIcon(tagAcc);

    private JLabel pswHint = new JLabel("Password:");
    private URL urlPsw = LoginFrame.class.getResource("iconPsw.png");
    private Icon iconPsw = new ImageIcon(urlPsw); 
    private Image imgPsw = ((ImageIcon)iconPsw).getImage();
    private int widthPsw = imgPsw.getWidth(null);
    private int heightPsw = imgPsw.getWidth(null);
    private BufferedImage tagPsw = new BufferedImage((int)(0.015 * widthPsw), (int)(0.015 * heightPsw),BufferedImage.TYPE_INT_RGB);
	private Icon newIconPsw = new ImageIcon(tagPsw);

    private JLabel forgetHint = new JLabel("Forget your password?", SwingConstants.CENTER);
    private JLabel regHint = new JLabel("--------New to application?--------", SwingConstants.CENTER);
    // create textField components to collect input
    private JTextField accNum = new JTextField();
    private JTextField psw = new JTextField();

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
        // set the frame title and size
        this.setTitle("Log In");
        this.setSize(350, 500);
        // add components to the content panel and set the layout to a free layout
        contentPanel.setLayout(null);
        add(title);
        add(accHint);
        add(accNum);
        add(pswHint);
        add(psw);
        add(forgetHint);
        add(login);
        add(register);
        add(regHint);
        add(hint);
        // format the title and design absolute position
        title.setBounds(110, 10, 150, 100);

        accHint.setBounds(40, 130, 100, 25);
        accHint.setForeground(new Color(25,25,112));
        accHint.setIcon(newIconAcc);
		tagAcc.getGraphics().drawImage(imgAcc, 0, 0, (int)(0.01 * widthAcc), (int)(0.01 * heightAcc), null); 
        accNum.setBounds(160, 130, 150, 25);
        pswHint.setBounds(40, 200, 100, 25);
        pswHint.setForeground(new Color(25,25,112));
        pswHint.setIcon(newIconPsw);
		tagPsw.getGraphics().drawImage(imgPsw, 0, 0, (int)(0.015 * widthPsw), (int)(0.015 * heightPsw), null);
        psw.setBounds(160, 200, 150, 25);
        forgetHint.setBounds(0, 240, 350, 25);
        forgetHint.setForeground(new Color(25,25,112));
        login.setOpaque(true);
        login.setBounds(75, 275, 200, 50);
        login.setBackground(new Color(200,200,221));
        login.setBorder(BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        regHint.setBounds(0, 350, 350, 25);
        regHint.setForeground(new Color(25,25,112));
        register.setBounds(75, 390, 200, 50);
        register.setOpaque(true);
//        register.setBorderPainted(false);
        register.setBackground(new Color(200,200,221));
        register.setBorder(BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        // components transparency
        accNum.setOpaque(true);
		psw.setOpaque(true);
		contentPanel.setOpaque(false);
		getContentPane().add(contentPanel);
        // set the component border format
        textSet(accNum);
        textSet(psw);
        hint.setBounds(325,205,17,17);

        hint.setOpaque(true);
        hint.setBackground(Color.blue);
        hint.setText("?");

        hint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

    /**
     * This method sets the format of JTextField.
     * @param field to be set
     */
    private void textSet(JTextField field) {
		field.setBackground(new Color(255, 255, 255));
		field.setPreferredSize(new Dimension(150, 28));
		MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192, 192));
		field.setBorder(border);
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

        register.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                registerControl();
            }
        });

        forgetHint.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                JOptionPane.showMessageDialog(null, "hint", "hint", JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }


    public void loginControl(){

    }
    public void registerControl(){

    }



    public static void main(String[] args){
        LoginFrame myFrame = new LoginFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }

}
