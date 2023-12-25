import java.util.LinkedList;
import java.util.Queue;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Assignment1_65050669_65050776 extends JPanel {
    public static void main(String[] args) {
        Assignment1_65050669_65050776 m = new Assignment1_65050669_65050776();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("First Swing");
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void BezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        for (float t = 0; t <= 1; t += 0.001) {
            int xt = (int) (Math.pow(1 - t, 3) * x1 +
                    3 * t * Math.pow(1 - t, 2) * x2 +
                    3 * Math.pow(t, 2) * (1 - t) * x3 +
                    Math.pow(t, 3) * x4);

            int yt = (int) (Math.pow(1 - t, 3) * y1 +
                    3 * t * Math.pow(1 - t, 2) * y2 +
                    3 * Math.pow(t, 2) * (1 - t) * y3 +
                    Math.pow(t, 3) * y4);

            plot(g, xt, yt, 4);
        }
    }

    public BufferedImage floodFill(BufferedImage m, int x, int y, Color targetColour, Color replacementColour) {
        Graphics2D g2 = m.createGraphics();
        Queue<Point> q = new LinkedList<>();

        if (x >= 0 && x < 600 && y >= 0 && y < 600 && m.getRGB(x, y) == targetColour.getRGB()) {
            g2.setColor(replacementColour);
            plot(g2, x, y, 1);
            q.add(new Point(x, y));
        }

        while (!q.isEmpty()) { // check S -> N -> E -> W for fills the pixel
            Point p = q.poll();

            // South
            if (p.y < 600 && m.getRGB(p.x, p.y + 1) == targetColour.getRGB()) {
                g2.setColor(replacementColour);
                plot(g2, p.x, p.y + 1, 1);
                q.add(new Point(p.x, p.y + 1));
            }
            // North
            if (p.y > 0 && m.getRGB(p.x, p.y - 1) == targetColour.getRGB()) {
                g2.setColor(replacementColour);
                plot(g2, p.x, p.y - 1, 1);
                q.add(new Point(p.x, p.y - 1));
            }
            // East
            if (p.x < 600 && m.getRGB(p.x + 1, p.y) == targetColour.getRGB()) {
                g2.setColor(replacementColour);
                plot(g2, p.x + 1, p.y, 1);
                q.add(new Point(p.x + 1, p.y));
            }
            // West
            if (p.x > 0 && m.getRGB(p.x - 1, p.y) == targetColour.getRGB()) {
                g2.setColor(replacementColour);
                plot(g2, p.x - 1, p.y, 1);
                q.add(new Point(p.x - 1, p.y));
            }
        }
        return m;
    }

    public void plot(Graphics g, int x, int y){
        //g.fillRect(x, y, 1, 1);
    }

    public void plot(Graphics g, int x, int y, int size) {
        //g.fillRect(x, y, size, size);
    }
}