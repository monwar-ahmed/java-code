public class Bullseye {
    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("Bullseye");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        BullseyePanel panel = new BullseyePanel();      
        frame.add(panel);       
          frame.setSize(400, 400);
        frame.setVisible(true);
    }
} 