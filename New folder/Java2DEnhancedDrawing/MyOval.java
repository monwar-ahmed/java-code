import java.awt.*;

public class MyOval extends MyShape {
    public MyOval(int x1, int y1, int x2, int y2, Paint paint, Stroke stroke, boolean filled) {
        super(x1, y1, x2, y2, paint, stroke, filled);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setPaint(paint);
        g2d.setStroke(stroke);
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int w = Math.abs(x2 - x1);
        int h = Math.abs(y2 - y1);
        if (filled) g2d.fillOval(x, y, w, h);
        else g2d.drawOval(x, y, w, h);
    }
}