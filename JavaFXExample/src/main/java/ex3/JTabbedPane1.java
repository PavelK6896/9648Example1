package ex3;

import javax.swing.*;
import java.awt.*;

public class JTabbedPane1 extends JFrame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("JFrame");
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JButton jButton1 = new JButton("JButton");
        JButton jButton2 = new JButton("JButton2");

        jPanel1.add(jButton1);
        jPanel1.setBackground(Color.cyan);
        jPanel1.add(new JLabel("JPanel JLabel"));
        jPanel1.setPreferredSize(new Dimension(100, 100)); // задать размер

        jPanel2.add(jButton2);
        jPanel2.setBackground(Color.ORANGE);
        jPanel2.add(new JLabel("JPanel2 JLabel"));
        jPanel2.setPreferredSize(new Dimension(300, 300)); // задать размер

        JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.TOP); // добавить переключение
        jTabbedPane.add("JPanel", jPanel1);
        jTabbedPane.add("JPanel2", jPanel2);

        // jFrame.getContentPane().add(jTabbedPane, BorderLayout.SOUTH);
        jFrame.add(jTabbedPane, BorderLayout.CENTER);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();// по краям контента
        jFrame.setLocationRelativeTo(null); // посередине
        jFrame.setVisible(true);
        jFrame.setSize(500, 500); // задать размер
    }
}
