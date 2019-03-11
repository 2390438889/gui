package shape;

import base.*;
import base.Point;

import java.awt.*;

/**
 * @author Hearts
 * @date 2019/3/8
 * @desc
 */
public class TableGraphic extends AbstractGraphicShape{

    private int lengthOfSide;

    private int row;

    private int col;

    public TableGraphic() {
    }

    public TableGraphic(int lengthOfSide, int row, int col, int startX, int startY) {

        super(new Point(startX,startY));
        this.lengthOfSide = lengthOfSide;
        this.row = row;
        this.col = col;

    }

    /*private TableGraphic(){}
        private static class TableHolder{
            public static TableGraphic tableGraphic = new TableGraphic();
        }
        public static TableGraphic getTableGraphic(){
            return TableHolder.tableGraphic;
        }
    */
    @Override
    public void draw(Graphics graphics) {
        int pointX = startPoint.getX();
        int pointY = startPoint.getY();

        //绘制横向线条
        for (int i = 0; i < row+1; i++) {
            graphics.drawLine(pointX,pointY+i*lengthOfSide,pointX + col*lengthOfSide,pointY+i*lengthOfSide);
        }

        //绘制纵向线条
        for (int i = 0; i < col+1; i++) {
            graphics.drawLine(pointX+i*lengthOfSide,pointY,pointX+i*lengthOfSide,pointY + row*lengthOfSide);
        }
    }


    /**
     * 更改行数和列数
     * @param row
     * @param col
     */
    public void changeSize(int row,int col){
        this.row = row;
        this.col = col;
    }

    /**
     * 更改表格的大小
     * @param lengthOfSize
     */
    public void changeLengthOfSize(int lengthOfSize){
        this.lengthOfSide = lengthOfSize;
    }
}