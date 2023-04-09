import javax.swing.JFrame;

/**
 * @version 2.1
 * @auther ZhangDan, Liu Yuxuan
 * @data 2023/4/8 15:06
 */
public class TestSkill {
    public static void main(String[] args) {
        Skill frame = new Skill();
        frame.init("MySkills");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
