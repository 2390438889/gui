package shape;

import base.Point;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Hearts
 * @date 2019/3/8
 * @desc
 */
public class CoodinatesGraphic extends AbstractGraphicShape{

    /**
     * 单位长度
     */
    private int unitLength;

    /**
     * 横坐标单位数量
     */
    private int abscissaUnits;

    /**
     * 纵坐标单位数量
     */
    private int ordinateUnits;

    /**
     * 坐标轴原点
     */
    private Point imported;

    /**
     * 坐标轴标记长度
     */
    private int signLength;

    /**
     * 绘制画笔
     */
    private Graphics graphics;

    private ArrayList<Point> points;

    public CoodinatesGraphic(){
        this(new Point(20, 20), 20, 20, 20);
    }

    public CoodinatesGraphic(Point startPoint, int unitLength, int abscissaUnits, int ordinateUnits) {
        super(startPoint);
        this.unitLength = unitLength;
        this.abscissaUnits = abscissaUnits;
        this.ordinateUnits = ordinateUnits;
        init();
    }

    public int getUnitLength() {
        return unitLength;
    }

    public void setUnitLength(int unitLength) {
        this.unitLength = unitLength;
    }

    public int getAbscissaUnits() {
        return abscissaUnits;
    }

    public void setAbscissaUnits(int abscissaUnits) {
        this.abscissaUnits = abscissaUnits;
    }

    public int getOrdinateUnits() {
        return ordinateUnits;
    }

    public void setOrdinateUnits(int ordinateUnits) {
        this.ordinateUnits = ordinateUnits;
    }

    public int getSignLength() {
        return signLength;
    }

    public void setSignLength(int signLength) {
        this.signLength = signLength;
    }

    private void init() {
        imported = new Point();
        points = new ArrayList<>();
        moveImported();
        signLength = 5;
    }

    @Override
    public void draw(Graphics graphics) {

        if (this.graphics != graphics){
            this.graphics = graphics;
        }
        //绘制坐标轴
        drawCoodinates();

        //绘制坐标轴上的点
        drawPoints();

        //将所有的点连接
        drawPointConnect();

    }

    private void drawPointConnect() {
        for (int i = 0; i < points.size() -1; i++) {
            Point start = coodinateThransform(points.get(i));
            Point end = coodinateThransform(points.get(i+1));
            graphics.drawLine(start.getX(),start.getY(),end.getX(),end.getY());
        }
    }

    /**
     * 绘制坐标上所有点
     */
    private void drawPoints() {
        points.forEach(point -> {
            drawPoint(point);
        });
    }

    /**
     * 绘制坐标上单个点
     * @param point
     */
    private void drawPoint(Point point) {
        //将逻辑坐标转化为真实坐标
        point = coodinateThransform(point);

        //graphics.drawString(".",point.getX(),point.getY()+1);

        graphics.fillOval(point.getX()-2,point.getY()-2,4,4);

    }

    public void addPoint(Point point){
        points.add(point);
    }

    public void addPoint(int x,int y){
        addPoint(new Point(x,y));
    }

    /**
     * 将逻辑坐标转化为真实坐标
     * @param point
     * @return
     */
    private Point coodinateThransform(Point point){
        return new Point(imported.getX()+point.getX()*unitLength,imported.getY() - point.getY()*unitLength);
    }

    /**
     * 绘制坐标轴
     */
    private void drawCoodinates() {
        int x = startPoint.getX();
        int y = startPoint.getY();
        //绘制纵轴
        graphics.drawLine(x + unitLength/2,y,x + unitLength/2,y + (ordinateUnits + 1) * unitLength);

        //绘制纵轴箭头
        int maxOrdX = x + unitLength/2;
        graphics.drawLine(maxOrdX,y,maxOrdX - signLength,y+signLength*2);
        graphics.drawLine(maxOrdX,y,maxOrdX + signLength,y+signLength*2);

        //绘制横轴
        graphics.drawLine(x,y+(2*ordinateUnits+1)*unitLength/2,x + (abscissaUnits + 1)*unitLength,y+(2*ordinateUnits+1)*unitLength/2);

        //绘制横轴箭头
        int maxAbscX = x + (abscissaUnits + 1)*unitLength;
        int maxAbscY = y+(2*ordinateUnits+1)*unitLength/2;
        graphics.drawLine(maxAbscX,maxAbscY,maxAbscX -signLength*2,maxAbscY-signLength);
        graphics.drawLine(maxAbscX,maxAbscY,maxAbscX-signLength*2,maxAbscY+signLength);

        //纵轴每一个单位绘制标记
        for (int i = 0; i < ordinateUnits; i++) {
            Point real = coodinateThransform(new Point(0,i));
            int signX = real.getX();
            int signY = real.getY();
            graphics.drawLine(signX,signY,signX+signLength,signY);
            if (i % 5 ==0 && i>0){
                //绘制数字的坐标
                graphics.drawString(i+"",signX-signLength*3,signY +signLength/2);
            }
        }

        //横轴每个单位绘制图标
        for (int i = 0; i < abscissaUnits; i++) {
            Point real = coodinateThransform(new Point(i,0));
            int signX = real.getX();
            int signY = real.getY();
            graphics.drawLine(signX,signY,signX,signY-signLength);
            if (i % 5 ==0 && i>0){
                //绘制数字的坐标
                graphics.drawString(i+"",signX - signLength/2,signY +signLength*3);
            }
        }

    }


    /**
     * 修改原点的位置
     */
    private void moveImported(){
        imported.setX(startPoint.getX() + unitLength/2);
        imported.setY(startPoint.getY() + (2*ordinateUnits +1)*unitLength/2);
    }
}
