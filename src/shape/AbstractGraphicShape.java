package shape;

import base.Point;

/**
 * @author Hearts
 * @date 2019/3/8
 * @desc
 */
public abstract class AbstractGraphicShape implements GraphicsShape{

    /**
     * 图案起点
     */

    protected Point startPoint;

    public AbstractGraphicShape(Point startPoint) {
        this.startPoint = startPoint;
    }

    public AbstractGraphicShape() {
    }

    /**
     * 移动到指定坐标
     * @param x
     * @param y
     */
    public void move(int x,int y){
        this.startPoint.setX(x);
        this.startPoint.setY(y);
    }

}
