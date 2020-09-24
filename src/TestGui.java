import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestGui {
    private JTextField textField;

    class WindowListenerExample implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {

        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {
            textField.setText("windowIconified");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            textField.setText("windowDeiconified");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            textField.setText("windowActivated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            textField.setText("windowDeactivated");
        }
    }

    class WindowAdapterExample extends WindowAdapter {
        @Override
        public void windowLostFocus(WindowEvent e) {
            super.windowLostFocus(e);
            textField.setText("windowLostFocus");
        }

        @Override
        public void windowGainedFocus(WindowEvent e) {
            super.windowGainedFocus(e);
            textField.setText("windowGainedFocus");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            super.windowActivated(e);
            textField.setText("windowActivated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            super.windowDeactivated(e);
            textField.setText("windowDeactivated");
        }

        @Override
        public void windowClosing(WindowEvent e) {
            super.windowClosing(e);

        }
    }

    public static void main(String[] args) {
        TestGui gui = new TestGui();
        gui.go();
    }

    private void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.addWindowListener(new WindowListenerExample());
        frame.addWindowListener(new WindowAdapterExample());
        JPanel panel = new JPanel();

        SpringLayout springLayout = new SpringLayout();
        panel.setBackground(Color.darkGray);
        panel.setLayout(springLayout);

        textField = new JTextField("Some text");
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
