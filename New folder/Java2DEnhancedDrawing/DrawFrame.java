import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawFrame extends JFrame {
    private final DrawPanel drawPanel;
    private final JLabel statusLabel;
    private Color color1 = Color.BLACK, color2 = Color.WHITE;

    public DrawFrame() {
        super("Java 2D Enhanced Drawing");

        statusLabel = new JLabel("Mouse at (0, 0)");
        drawPanel = new DrawPanel(statusLabel);

        JComboBox<String> shapeBox = new JComboBox<>(new String[]{"Line", "Rectangle", "Oval"});
        shapeBox.addItemListener(e -> drawPanel.setShapeType(shapeBox.getSelectedIndex()));

        JCheckBox filledBox = new JCheckBox("Filled");
        filledBox.addItemListener(e -> drawPanel.setFilled(filledBox.isSelected()));

        JCheckBox gradientBox = new JCheckBox("Use Gradient");

        JButton color1Button = new JButton("Color 1");
        color1Button.addActionListener(e -> {
            color1 = JColorChooser.showDialog(null, "Choose Color 1", color1);
            updatePaint(gradientBox.isSelected());
        });

        JButton color2Button = new JButton("Color 2");
        color2Button.addActionListener(e -> {
            color2 = JColorChooser.showDialog(null, "Choose Color 2", color2);
            updatePaint(gradientBox.isSelected());
        });

        JTextField widthField = new JTextField("1.0", 3);
        JTextField dashField = new JTextField("10.0", 3);
        JCheckBox dashedBox = new JCheckBox("Dashed");

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(e -> drawPanel.clearLastShape());

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> drawPanel.clearDrawing());

        gradientBox.addItemListener(e -> updatePaint(gradientBox.isSelected()));

        ActionListener strokeListener = e -> {
            float width = Float.parseFloat(widthField.getText());
            if (dashedBox.isSelected()) {
                float dash = Float.parseFloat(dashField.getText());
                drawPanel.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND,
                        BasicStroke.JOIN_ROUND, 10, new float[]{dash}, 0));
            } else {
                drawPanel.setStroke(new BasicStroke(width));
            }
        };
        widthField.addActionListener(strokeListener);
        dashField.addActionListener(strokeListener);
        dashedBox.addActionListener(strokeListener);

        JPanel topPanel = new JPanel();
        topPanel.add(undoButton);
        topPanel.add(clearButton);
        topPanel.add(shapeBox);
        topPanel.add(filledBox);
        topPanel.add(gradientBox);
        topPanel.add(color1Button);
        topPanel.add(color2Button);
        topPanel.add(new JLabel("Width:"));
        topPanel.add(widthField);
        topPanel.add(new JLabel("Dash:"));
        topPanel.add(dashField);
        topPanel.add(dashedBox);

        add(topPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        updatePaint(false); // default to solid color
        strokeListener.actionPerformed(null); // apply default stroke
    }

    private void updatePaint(boolean useGradient) {
        if (useGradient) {
            GradientPaint gp = new GradientPaint(0, 0, color1, 50, 50, color2, true);
            drawPanel.setPaint(gp);
        } else {
            drawPanel.setPaint(color1);
        }
    }
}