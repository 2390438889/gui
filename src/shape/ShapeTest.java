package shape;

import tool.ThreadTool;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hearts
 * @date 2019/3/8
 * @desc
 */
public class ShapeTest {

    public static JFrame jFrame;

    public static JPanel jPanel;

    public static void main(String[] args) {

        //1.tableGraphic();

        //2.parobalaGraphic();

        coodinatesGraphic();

    }

    public static void coodinatesGraphic(){
        CoodinatesGraphic coodinatesGraphic = new CoodinatesGraphic();
        for (int i = 0; i < 10; i++) {
            coodinatesGraphic.addPoint(i*i,i);
        }
        init(coodinatesGraphic);
    }

    /**
     * 测试ParobalaGraphic
     */
    public static void parobalaGraphic(){
        ParobalaGraphic parobalaGraphic = new ParobalaGraphic();

        init(parobalaGraphic);

    }

    /**
     * 测试TableGraphic
     */
    public static void tableGraphic(){

        TableGraphic tableGraphic = new TableGraphic();

        tableGraphic.move(20, 20);

        tableGraphic.changeLengthOfSize(20);

        tableGraphic.changeSize(20, 20);

        init(tableGraphic);

        ThreadTool.sleep(1_000);

        tableGraphic.move(30, 30);

        repaint();

    }

    /**
     * 初始化窗体和内容窗格
     * @param shape
     */
    public static void init(GraphicsShape shape){

        jPanel = new JPanel(){
            @Override
            public void paint(Graphics graphics) {

                //必须先调用父类的paint方法,否则在调用repaint方法的时候,
                //之前绘制的图案不会被清除
                super.paint(graphics);
                shape.draw(graphics);
                
            }
        };

        jFrame = createNewJFrame("paint",jPanel);
    }

    public static void repaint(){
        jPanel.repaint();
    }

    public static JFrame createNewJFrame(String name,JPanel jPanel){

        JFrame jFrame = new JFrame(name);

        //设置窗体大小
        jFrame.setSize(500, 500);

        //设置默认关闭模式
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置窗体居中
        jFrame.setLocationRelativeTo(null);

        //设置内容面板
        jFrame.setContentPane(jPanel);

        //设置窗体可见
        jFrame.setVisible(true);

        return jFrame;



    }


}
