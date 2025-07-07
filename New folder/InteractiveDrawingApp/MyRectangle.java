import java.awt.*;

public class MyRectangle extends MyShape {
    private boolean filled;

    public MyRectangle(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color);
        this.filled = filled;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int width = Math.abs(x1 - x2);
        int height = Math.abs(y1 - y2);

        if (filled) g.fillRect(x, y, width, height);
        else g.drawRect(x, y, width, height);
    }
}