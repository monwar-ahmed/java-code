import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends JPanel {
    private MyShape[] shapes = new MyShape[100];
    private int shapeCount = 0;
    private int shapeType = 0;
    private MyShape currentShape = null;
    private Color currentColor = Color.BLACK;
    private boolean fillShape = false;
    private final JLabel statusLabel;

    public DrawPanel() {
        setBackground(Color.WHITE);
        statusLabel = new JLabel("Coordinates: ");
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }

    public void setShapeType(int shapeType) {
        this.shapeType = shapeType;
    }

    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    public void setFillShape(boolean fill) {
        fillShape = fill;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < shapeCount; i++) {
            shapes[i].draw(g);
        }
        if (currentShape != null) currentShape.draw(g);
    }

    public void clearLastShape() {
        if (shapeCount > 0) {
            shapeCount--;
            repaint();
        }
    }

    public void clearDrawing() {
        shapeCount = 0;
        repaint();
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            switch (shapeType) {
                case 0 -> currentShape = new MyLine(e.getX(), e.getY(), e.getX(), e.getY(), currentColor);
                case 1 -> currentShape = new MyRectangle(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, fillShape);
                case 2 -> currentShape = new MyOval(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, fillShape);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            currentShape.setX2(e.getX());
            currentShape.setY2(e.getY());
            if (shapeCount < shapes.length) shapes[shapeCount++] = currentShape;
            currentShape = null;
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            currentShape.setX2(e.getX());
            currentShape.setY2(e.getY());
            statusLabel.setText(String.format("Coordinates: (%d, %d)", e.getX(), e.getY()));
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            statusLabel.setText(String.format("Coordinates: (%d, %d)", e.getX(), e.getY()));
        }
    }
}