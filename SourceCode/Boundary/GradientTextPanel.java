/**
 * @version 2.1
 * @auther ZhangDan
 * @data 2023/3/25 22:24
 */

package Boundary;

import javax.swing.*;
import java.awt.*;

public class GradientTextPanel extends JPanel
{
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
