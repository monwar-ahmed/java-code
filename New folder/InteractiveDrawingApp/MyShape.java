import java.awt.*;

public abstract class MyShape {
    protected int x1, y1, x2, y2;
    protected Color color;

    public MyShape(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1; this.y1 = y1;
        this.x2 = x2; this.y2 = y2;
        this.color = color;
    }

    public void setX2(int x2) { this.x2 = x2; }
    public void setY2(int y2) { this.y2 = y2; }

    public abstract void draw(Graphics g);
}