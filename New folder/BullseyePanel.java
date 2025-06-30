import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class BullseyePanel extends JPanel {  
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        g.setColor(Color.RED);
        g.fillOval((width - size) / 2, (height - size) / 2, size, size);
        int middleSize = size * 2 / 3;
        g.setColor(Color.WHITE);
        g.fillOval((width - middleSize) / 2, (height - middleSize) / 2, middleSize, middleSize);
        int innerSize = size / 3;
        g.setColor(Color.BLACK);
        g.fillOval((width - innerSize) / 2, (height - innerSize) / 2, innerSize, innerSize);
    }
}