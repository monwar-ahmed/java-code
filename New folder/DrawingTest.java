import javax.swing.JFrame;
public class DrawingTest {
    public static void main(String[] args) {
        Drawing drawing = new Drawing();
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(drawing);
        application.setSize(300, 300);
        application.setVisible(true);
    }
}