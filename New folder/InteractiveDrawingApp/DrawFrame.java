import javax.swing.JFrame;

public class DrawFrame extends JFrame {
    public DrawFrame() {
        super("Interactive Drawing Application");
        DrawPanel panel = new DrawPanel();
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DrawFrame();
    }
}