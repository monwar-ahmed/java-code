import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends JPanel {
    private final MyShape[] shapes = new MyShape[1000];
    private int shapeCount = 0;
    private int shapeType = 0;
    private Paint paint = Color.BLACK;
    private Stroke stroke = new BasicStroke(1.0f);
    private boolean filled = false;
    private MyShape currentShape = null;
    private final JLabel statusLabel;

    public DrawPanel(JLabel label) {
        statusLabel = label;
        setBackground(Color.WHITE);
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    public void setShapeType(int t) { shapeType = t; }
    public void setPaint(Paint p) { paint = p; }
    public void setStroke(Stroke s) { stroke = s; }
    public void setFilled(boolean f) { filled = f; }

    public void clearLastShape() {
        if (shapeCount > 0) shapeCount--;
        repaint();
    }

    public void clearDrawing() {
        shapeCount = 0;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < shapeCount; i++) shapes[i].draw(g2d);
        if (currentShape != null) currentShape.draw(g2d);
    }

    private class MouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            int x = e.getX(), y = e.getY();
            switch (shapeType) {
                case 0 -> currentShape = new MyLine(x, y, x, y, paint, stroke);
                case 1 -> currentShape = new MyRectangle(x, y, x, y, paint, stroke, filled);
                case 2 -> currentShape = new MyOval(x, y, x, y, paint, stroke, filled);
            }
        }

        public void mouseReleased(MouseEvent e) {
            currentShape.x2 = e.getX();
            currentShape.y2 = e.getY();
            if (shapeCount < shapes.length) shapes[shapeCount++] = currentShape;
            currentShape = null;
            repaint();
        }

        public void mouseDragged(MouseEvent e) {
            currentShape.x2 = e.getX();
            currentShape.y2 = e.getY();
            statusLabel.setText(String.format("Mouse at (%d, %d)", e.getX(), e.getY()));
            repaint();
        }

        public void mouseMoved(MouseEvent e) {
            statusLabel.setText(String.format("Mouse at (%d, %d)", e.getX(), e.getY()));
        }
    }
}