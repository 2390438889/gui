package shape;

import java.awt.*;

/**
 * @author Hearts
 * @date 2019/3/8
 * @desc
 */
public class ParobalaGraphic extends AbstractGraphicShape{


    @Override
    public void draw(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.drawLine(1,1,30,30);
    }
}
