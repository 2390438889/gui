package window;

import javax.swing.*;

/**
 * @author Hearts
 * @date 2019/3/7
 * @desc
 */
public class test {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame();

        jFrame.setSize(800, 800);

        jFrame.setTitle("test");

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setLocationRelativeTo(null);

        jFrame.setVisible(true);

        EnnewLineContainer ennewLineContainer = new EnnewLineContainer(20,20,20,20,20,20, jFrame);



        JTextField jtf1 = new JTextField("hai");
        jtf1.setSize(40, 40);
        ennewLineContainer.addComponent(jtf1);
        ennewLineContainer.nextLine();
        JTextField jtf2 = new JTextField("hai");
        jtf2.setSize(40, 40);
        ennewLineContainer.addComponent(jtf2);

        JTextField jtf3 = new JTextField("hai");
        jtf3.setSize(40,40);
        ennewLineContainer.addComponent(jtf3);
        ennewLineContainer.nextLine();

    }
}
