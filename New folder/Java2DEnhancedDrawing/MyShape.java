import java.awt.*;

public abstract class MyShape {
    protected int x1, y1, x2, y2;
    protected Paint paint;
    protected Stroke stroke;
    protected boolean filled;

    public MyShape(int x1, int y1, int x2, int y2, Paint paint, Stroke stroke, boolean filled) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.paint = paint;
        this.stroke = stroke;
        this.filled = filled;
    }

    public abstract void draw(Graphics2D g2d);
}