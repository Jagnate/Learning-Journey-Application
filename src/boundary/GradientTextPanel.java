/**
 *  Title      : GradientTextPanel.java
 *  Description: A class that provides gradient color for the login title.
 * 
 *  @author  Zhang Dan
 *  @author Liu yu xuan
 *  @version 1.0
 */
package boundary;

import javax.swing.*;
import java.awt.*;

/**
 * This is the method set the font of the title.
 */
public class GradientTextPanel extends JPanel
{
    private static final long serialVersionUID = 1L;

	public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        String value;
        int x = 5;
        int y = 58;
        Font font = new Font("Georgia", Font.ROMAN_BASELINE, 35);
        GradientPaint paint = new GradientPaint(20, 20, Color.BLUE, 100, 120, Color.RED, true);
        g2.setPaint(paint);
        g2.setFont(font);
        value = "Start your Joureny!";
        g2.drawString(value, x, y);
    }
}
