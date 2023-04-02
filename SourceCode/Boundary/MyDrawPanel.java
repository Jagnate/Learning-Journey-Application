/**
 * @version 2.1
 * @auther ZhangDan
 * @data 2023/3/25 20:10
 */

package Boundary;

import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel{
    /**
     * #Description Make my own panel with gradient background.
     * @param g
     * @auther ZhangDan
     */
    public void paintComponent(Graphics g) {
        //Generate a two-dimensional gradient panel.
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(20,60 , new Color(110,180,251),
                280,90, new Color(155,150,235));
        g2d.setPaint(gradient);

        //With infinity wide and high, this panel can change follow the size of frame.
        double d = Double.POSITIVE_INFINITY;
        int d1 = (int)d;
        g2d.fillRect(0,0,d1,d1);
    }
}