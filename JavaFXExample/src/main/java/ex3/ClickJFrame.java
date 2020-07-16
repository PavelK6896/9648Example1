package ex3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ClickJFrame extends JFrame {

    private static ClickJFrame clickJFrame;
    private static long lastTime;
    private static Image picture1;
    private static float left = 200;
    private static float top = -100;
    private static float velocity = 200;
    private static int score;

    public static void main(String[] args) throws IOException {

        picture1 = ImageIO.read(ClickJFrame.class.getResourceAsStream("pngA.png"));

        clickJFrame = new ClickJFrame();
        clickJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        clickJFrame.setLocation(200, 100);
        clickJFrame.setSize(1000, 700);

        clickJFrame.setResizable(false); // неизменяемое
        lastTime = System.nanoTime(); // запоминает время

        ClickJPanel clickJPanel = new ClickJPanel(); // игровое поле
        clickJPanel.setBackground(Color.getHSBColor(100, 100, 100));
        clickJPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                float drop_right = left + picture1.getWidth(null);
                float drop_bottom = top + picture1.getHeight(null);
                boolean is_drop = x >= left && x <= drop_right && y >= top && y <= drop_bottom;
                if (is_drop) {
                    top = -100;
                    left = (int) (Math.random() * (clickJPanel.getWidth() - picture1.getHeight(null)));
                    velocity = velocity + 20;
                    score++;
                    clickJFrame.setTitle("Score: " + score); // подщет очьков
                }
            }
        });

        JPanel jPanel2 = new JPanel();
        JButton jButton1 = new JButton("Новая игра");
        jButton1.addActionListener(e -> {
            top = -100;
            left = 200;
            velocity = 100;
            score = 0;
            clickJFrame.setTitle("Score: " + 0); // подщет очьков
        });

        jPanel2.add(jButton1);
        clickJFrame.setLayout(new BorderLayout());
        clickJFrame.add(jPanel2, BorderLayout.SOUTH);

        clickJFrame.add(clickJPanel);
        clickJFrame.setVisible(true);
    }


    private static class ClickJPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            long current_time = System.nanoTime();
            float deltaTime = (current_time - lastTime) * 0.000000001f;
            lastTime = current_time;
            top = top + velocity * deltaTime;

//            graphics = JFrame.getGraphics(); // получить graphics
//            graphics.setPaintMode(); // меняется
//            graphics.setColor(Color.MAGENTA);
//            graphics.fillArc((int) left, (int) top, 100, 100, 0, 360); // нарисовать круг
//            graphics.drawOval((int) left, (int) top, 100, 100); // нарисовать окружность
            graphics.drawImage(picture1, (int) left, (int) top, null); // нарусовать png

            if (top > clickJFrame.getHeight()) { // координата больше высоты
                graphics.drawString("game over " + score, 200, 200);
                clickJFrame.setTitle("Score: " + score + " game over"); // подщет очьков
            }
            repaint(); // перекрашивать
        }
    }

}

