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
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public void paintComponent(Graphics g) {
        // BezierCurve(g, 478, 173, 505, 211, 509, 260, 478, 274);
        // BezierCurve(g, 478, 173, 457, 209, 453, 268, 478, 274);
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

    public void ddaLine(Graphics g, int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double m = dy / dx;
        double x, y;
        if (m <= 1 && m >= 0) {
            y = Math.min(y1, y2);
            for (x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                y += m;
                plot(g, (int) x, (int) y);
            }
        } else if (m >= -1 && m < 0) {
            y = Math.max(y1, y2);
            for (x = Math.max(x1, x2); x >= Math.min(x1, x2); x--) {
                y += m;
                plot(g, (int) x, (int) y);
            }
        } else if (m > 1) {
            x = Math.min(x1, x2);
            for (y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                x += 1 / m;
                plot(g, (int) x, (int) y);
            }
        } else {
            x = Math.max(x1, x2);
            for (y = Math.max(y1, y2); y >= Math.min(y1, y2); y--) {
                x += 1 / m;
                plot(g, (int) x, (int) y);
            }
        }
    }

    public void BresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;

        boolean isSwap = false;
        if (dy > dx) {
            swapTemp(dy, dx);
            isSwap = true;
        }
        int D = 2 * dy - dx;
        int x = x1;
        int y = y1;
         for (int i = 1; i <= dx; i++) {
            plot(g, x, y);
            if (D >= 0) {
                if (isSwap)
                    x += sx;
                else
                    y += sy;
                D -= 2 * dx;
            }

            if (isSwap)
                y += sy;
            else
                x += sx;
             D += 2 * dy;
        }
    }

    private void swapTemp(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
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

    private void midpointCircle(Graphics g, int xc, int yc, int r) {
        int x = 0, y = r;
        int Dx = 2 * x, Dy = 2 * y;
        int D = 1 - r;
        while (x <= y) {
            plot(g, xc + x, yc + y);
            plot(g, xc - x, yc + y);
            plot(g, xc + x, yc - y);
            plot(g, xc - x, yc - y);
            plot(g, xc + y, yc + x);
            plot(g, xc - y, yc + x);
            plot(g, xc + y, yc - x);
            plot(g, xc - y, yc - x);
            x = x + 1;
            Dx = Dx + 2;
            D = D + Dx + 1;
            if (D >= 0) {
                y = y - 1;
                Dy = Dy - 2;
                D = D - Dy;
            }
        }
    }

    private void midpointEllipse(Graphics g, int xc, int yc, int a, int b) {
        int a2 = a * a, b2 = b * b;
        int twoA2 = 2 * a2, twoB2 = 2 * b2;
        // REGION 1
        int x = 0;
        int y = b;
        int D = Math.round(b2 - a2 * b + a2 / 4);
        int Dx = 0, Dy = twoA2 * y;
        while (Dx <= Dy) {
            plot(g, xc + x, yc + y);
            plot(g, xc - x, yc + y);
            plot(g, xc + x, yc - y);
            plot(g, xc - x, yc - y);
            x = x + 1;
            Dx = Dx + twoB2;
            D = D + Dx + b2;
            if (D >= 0) {
                y = y - 1;
                Dy = Dy - twoA2;
                D = D - Dy;
            }
        }
        // REGION 2
        x = a;
        y = 0;
        D = Math.round(a2 - b2 * a + b2 / 4);
        Dx = twoB2 * x;
        Dy = 0;
        while (Dx >= Dy) {
            plot(g, xc + x, yc + y);
            plot(g, xc - x, yc + y);
            plot(g, xc + x, yc - y);
            plot(g, xc - x, yc - y);
            y = y + 1;
            Dy = Dy + twoA2;
            D = D + Dy + a2;
            if (D >= 0) {
                x = x - 1;
                Dx = Dx - twoB2;
                D = D - Dx;
            }
        }
    }

    public void plot(Graphics g, int x, int y){
        g.fillRect(x, y, 1, 1);
    }

    public void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }
}