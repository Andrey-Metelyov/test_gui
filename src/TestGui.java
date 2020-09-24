import javax.swing.*;
import java.awt.*;

public class TestGui {
    public static void main(String[] args) {
        TestGui gui = new TestGui();
        gui.go();
    }

    private void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        SpringLayout springLayout = new SpringLayout();
        panel.setBackground(Color.darkGray);
        panel.setLayout(springLayout);

        JTextField textField = new JTextField("Some text");
        JButton button = new JButton("Button1");
        JButton button2 = new JButton("Button2 shmutton");

        panel.add(textField);
        panel.add(button);
        panel.add(button2);

        springLayout.putConstraint(SpringLayout.NORTH, button, 5, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.EAST, button, -5, SpringLayout.EAST, panel);
        springLayout.putConstraint(SpringLayout.WEST, textField, 5, SpringLayout.WEST, panel);
//        springLayout.putConstraint(SpringLayout.WEST, button, 5, SpringLayout.EAST, textField);
        springLayout.putConstraint(SpringLayout.EAST, textField, -5, SpringLayout.WEST, button);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, textField, 0, SpringLayout.VERTICAL_CENTER, button);

        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, button2, 0, SpringLayout.HORIZONTAL_CENTER, button);
        springLayout.putConstraint(SpringLayout.NORTH, button2, 5, SpringLayout.SOUTH, button);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
