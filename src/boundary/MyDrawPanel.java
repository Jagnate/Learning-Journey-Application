/**
 *  Title      : MyDrawPanel.java
 *  Description: A class that provides the colorful background panel.
 * 
 *  @author  Zhang Dan
 *  @version 1.0
 */
package boundary;
import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel{
    private static final long serialVersionUID = 1L;

    /**
     * #Description Make my own panel with gradient background.
     * @param g
     * @auther ZhangDan
     */
    public void paintComponent(Graphics g) {
        //Generate a two-dimensional gradient panel.
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(20,60 , new Color(250,240,230),
                280,90, new Color(250,210,203));
        g2d.setPaint(gradient);

        //With infinity wide and high, this panel can change follow the size of frame.
        double d = Double.POSITIVE_INFINITY;
        int d1 = (int)d;
        g2d.fillRect(0,0,d1,d1);
    }
}
