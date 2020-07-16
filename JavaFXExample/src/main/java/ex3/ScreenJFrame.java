package ex3;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ScreenJFrame {
    public static void main(String[] args) {
        ImageIcon imageIcon;
        JFrame jFrame = new JFrame("v.1.0");
        JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);

        JLabel jLabel = new JLabel("jLabel");
        JScrollPane  jScrollPane1 = new JScrollPane(jLabel);

        JTextField  jTextField = new JTextField();
        jTextField.setEditable(false);
        jTextField.setText("jTextField");
        JScrollPane jScrollPane2 = new JScrollPane(jTextField);

        jTabbedPane.add("jScrollPane1", jScrollPane1);
        jTabbedPane.add("jScrollPane2", jScrollPane2);

        jFrame.setBounds(100, 100, 400, 400);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.add(jTabbedPane, BorderLayout.CENTER);

        try {
            Robot robot = new Robot();
            BufferedImage buf = robot.createScreenCapture(new Rectangle(100, 100, 400, 400));
            imageIcon = new ImageIcon(buf);
            jLabel.setIcon(imageIcon); //
        } catch (AWTException e) {
            e.printStackTrace();
        }

        jFrame.setVisible(true);
    }
}
