package window;

import java.awt.*;

/**
 * @author Hearts
 * @date 2019/3/7
 * @desc
 */
public class EnnewLineContainer {
    /**
     * 上边距
     */
    private final int topPadding;
    /**
     * 下边距
     */
    private final int bottomPadding;
    /**
     * 左边距
     */
    private final int leftPadding;
    /**
     * 右边距
     */
    private final int ringhtPadding;
    /**
     * 行高
     */
    private final int lineSpacing;

    /**
     * 同行每个组件之间的距离
     */
    private final int nextSpacing;

    /**
     * 记录当前的X
     */
    private int x;

    /**
     * 记录当前的Y
     */
    private int y;

    /**
     * 记录当前组件最高
     */
    private int maxHeight;

    private final Container container;

    public EnnewLineContainer(Container container){
        this(0,0,0,0,20,10, container);
    }

    public EnnewLineContainer(int topPadding, int bottomPadding, int leftPadding, int ringhtPadding, int lineSpacing, int nextSpacing, Container container) {
        this.topPadding = topPadding;
        this.bottomPadding = bottomPadding;
        this.leftPadding = leftPadding;
        this.ringhtPadding = ringhtPadding;
        this.lineSpacing = lineSpacing;
        x = leftPadding;
        y = topPadding;
        this.nextSpacing = nextSpacing;
        this.container = container;
    }

    private void newLineXY(){
        x = leftPadding;
        y = y + lineSpacing + maxHeight;
        maxHeight = lineSpacing;
    }

    public void addComponent (Component component){
        container.add(component);
        component.setLocation(x, y);
        nextXY(component.getWidth(),component.getHeight());
    }

    private void nextXY(int width,int height) {
        x = x + width + nextSpacing;
        if (height > maxHeight){
            maxHeight = height;
        }
        if (x >= container.getWidth() - ringhtPadding){
            nextLine();
        }
    }


    public void nextLine(){
        if (y > container.getHeight() - bottomPadding){
            return;
        }
        newLineXY();
    }
}
