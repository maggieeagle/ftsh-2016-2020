import javax.swing.*;
import java.awt.*;

class MyPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (double i = 0; i <= 800; i++) {
            for (double j = 0; j <= 800; j++) {
                double p = i / 200 - 2;
                double q = 2 - j / 200;

                double x = p;
                double y = q;

                for (int k = 0; k < 1000; k++) {
                    double x_now = x;
                    double y_now = y;
                    x = x_now * x_now - y_now * y_now + p;
                    y = 2 * x_now * y_now + q;

                    if (x * x + y * y > 4) {
                        g2d.setColor(new Color(k % 255, k%255, 100));
                        g2d.drawLine((int) i, (int) j, (int) i, (int) j);
                        break;
                    } else {
                        g2d.setColor(new Color(100, 150, 200));
                        g2d.drawLine((int) i, (int) j, (int) i, (int) j);
                    }
                }
            }
        }
    }
}

class Mandelbrot {

    public static void main(String[] args) {
        JFrame window = new JFrame("Mandelbrot_set");

        int window_x = 800;
        int window_y = 800;

        window.setSize(window_x + 17, window_y + 39);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.add(new MyPanel());

        window.setVisible(true);
    }

}
