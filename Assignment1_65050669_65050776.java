import java.util.LinkedList;
import java.util.Queue;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Assignment1_65050669_65050776 extends JPanel {
    private Image backgroundImage;
    public Assignment1_65050669_65050776(){
        try {
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("10063949.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        
        Assignment1_65050669_65050776 m = new Assignment1_65050669_65050776();

        JFrame f = new JFrame();
        f.add(m);
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);
    }
    
    public void paintComponent(Graphics g) {
        // BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        // Graphics2D g2 = buffer.createGraphics();

        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        ddaLine(g,128,538,461,538);
        ddaLine(g,128,538,461,538);
        // bezierCurve(g,464,194,487,192,490,189,498,184,3);
        // BezierCurve(g, 478, 173, 505, 211, 509, 260, 478, 274);
        // BezierCurve(g, 478, 173, 457, 209, 453, 268, 478, 274);
        BezierCurve(g, 200, 306, 200, 302, 204, 317, 220, 307);

        // ฺBorder
        // BresenhamLine(g, 128, 23, 460, 23); // upper
        // BresenhamLine(g, 128, 538, 460, 538); // under
        // BresenhamLine(g, 27, 121, 27, 442); // left
        // BresenhamLine(g, 563, 121, 563, 442); // right

        // Body
        bezierCurve(g, 263, 205, 261, 210, 261, 212, 260, 216,1);
        bezierCurve(g, 262, 237, 267, 259, 275, 280, 283, 303,1);
        bezierCurve(g, 283, 303, 283, 317, 280, 332, 271, 349,1);
        bezierCurve(g, 271, 349, 263, 355, 247, 354, 226, 348,1);
        bezierCurve(g, 315, 253, 323, 270, 339, 313, 344, 350,1);
        bezierCurve(g, 226, 348, 219, 340, 199, 331, 183, 336,1);
        bezierCurve(g, 344, 350, 341, 381, 330, 406, 295, 433,1);
        bezierCurve(g, 163, 424, 147, 412, 132, 400, 110, 371,1);
        bezierCurve(g, 252, 443, 237, 443, 221, 442, 204, 439,1);
        bezierCurve(g, 394, 278, 400, 294, 407, 327, 409, 350,1);
        bezierCurve(g, 409, 350, 405, 375, 399, 390, 394, 401,1);
        bezierCurve(g, 394, 401, 370, 428, 339, 446, 299, 456,1);
        bezierCurve(g, 260, 460, 239, 460, 217, 457, 198, 452,1);
        bezierCurve(g, 163, 437, 143, 421, 123, 402, 109, 370,1);
        bezierCurve(g, 231, 387, 236, 388, 241, 388, 251, 388,1);

        // Neck Detail
        bezierCurve(g, 322, 270, 350, 292, 380, 294, 392, 277,1); // 1
        bezierCurve(g, 338, 311, 362, 335, 395, 335, 403, 311,1); // 2
        bezierCurve(g, 343, 352, 363, 375, 391, 379, 409, 351,1); // 3
        bezierCurve(g, 336, 393, 342, 408, 361, 420, 393, 402,1); // 4
        bezierCurve(g, 313, 423, 311, 434, 315, 447, 327, 450,1); // 5
        bezierCurve(g, 247, 444, 243, 448, 242, 453, 247, 460,1); // 6
        bezierCurve(g, 219, 443, 212, 444, 211, 452, 215, 458,1); // 7
        bezierCurve(g, 319, 400, 331, 423, 364, 432, 394, 400,1);
        bezierCurve(g, 153, 429, 150, 424, 153, 419, 160, 420,1);

        // Leg LF
        bezierCurve(g, 338, 446, 343, 452, 358, 461, 369, 468,1);
        bezierCurve(g, 394, 401, 375, 428, 379, 448, 399, 456,1);

        // Leg RF
        bezierCurve(g, 252, 443, 255, 447, 267, 464, 286, 475,1);
        bezierCurve(g, 319, 401, 310, 418, 299, 430, 285, 441,1);
        bezierCurve(g, 285, 441, 291, 448, 301, 456, 311, 466,1);
        bezierCurve(g, 267, 381, 262, 400, 255, 427, 253, 444,1);

        // Leg RB
        bezierCurve(g, 227, 356, 231, 376, 226, 403, 209, 420,1);
        bezierCurve(g, 167, 368, 167, 373, 167, 380, 168, 392,1);
        bezierCurve(g, 111, 369, 128, 377, 151, 376, 167, 368,1);
        bezierCurve(g, 164, 448, 164, 453, 173, 467, 176, 477,1);
        bezierCurve(g, 208, 421, 209, 431, 203, 440, 197, 452,1);
        bezierCurve(g, 197, 452, 199, 456, 202, 466, 209, 469,1);
        bezierCurve(g, 168, 392, 163, 400, 163, 411, 166, 416,1);
        bezierCurve(g, 166, 416, 163, 421, 165, 432, 165, 448,1);

        // Foot RB
        bezierCurve(g, 161, 496, 160, 481, 171, 479, 185, 481,1);
        bezierCurve(g, 185, 481, 187, 467, 217, 470, 220, 483,1);
        bezierCurve(g, 216, 474, 221, 465, 240, 478, 241, 496,1);
        bezierCurve(g, 162, 496, 184, 496, 217, 496, 240, 496,1);

        // Foot RF
        bezierCurve(g, 278, 494, 275, 477, 293, 475, 301, 480,1);
        bezierCurve(g, 301, 480, 302, 465, 331, 467, 336, 480,1);
        bezierCurve(g, 332, 474, 337, 466, 358, 478, 358, 494,1);
        bezierCurve(g, 277, 496, 305, 496, 335, 496, 358, 496, 1);

        // Foot LF
        bezierCurve(g, 365, 485, 365, 468, 379, 466, 387, 468,1);
        bezierCurve(g, 387, 468, 387, 457, 419, 459, 423, 471,1);
        bezierCurve(g, 419, 463, 428, 456, 446, 468, 445, 484,1);
        bezierCurve(g, 364, 486, 391, 486, 417, 486, 443, 486,1);

        // Tail
        // BezierCurve(g, 110, 370, 107, 348, 107, 326, 111, 308);
        bezierCurve(g, 319, 93,318, 83,305, 74,293, 72,1);
        bezierCurve(g, 264, 126,243, 125,230, 118,223, 105,1);
        bezierCurve(g, 178, 102,188, 119,205, 133,223, 132,1);

        bezierCurve(g, 347, 213,364, 230,397, 230,412, 202,1);
        bezierCurve(g, 276, 171,289, 215,313, 212,347, 213,1);
        bezierCurve(g, 347, 184,326, 183,300, 182,276, 171,1);


        bezierCurve(g, 114, 78,112, 98, 120, 116,142, 128,1);
        bezierCurve(g, 114, 78,132, 93, 138, 106,142, 128,1);

        bezierCurve(g, 426, 293,443, 281, 466, 275,491, 277,1);
        bezierCurve(g, 426, 293,450, 303, 471, 288, 491, 277,1);


        bezierCurve(g, 434, 308,455, 311, 475, 317,493, 329,1);
        bezierCurve(g, 434, 308,450, 324, 467, 330, 493, 329,1);

        bezierCurve(g, 68, 187,86, 171, 108, 165,129, 169,1);
        bezierCurve(g, 68, 187,92, 187, 113, 182, 129, 169,1);

        midpointEllipse(g, 290, 480, 210, 21);

        // paint
        // buffer = floodFill(buffer, 376, 351, Color.WHITE, Color.PINK);
        // g.drawImage(buffer, 0, 0, null);
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

    public void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4,int size) {
        for (float t = 0; t <= 1; t += 0.001) {
            int xt = (int) (Math.pow(1 - t, 3) * x1 +
                    3 * t * Math.pow(1 - t, 2) * x2 +
                    3 * Math.pow(t, 2) * (1 - t) * x3 +
                    Math.pow(t, 3) * x4);

            int yt = (int) (Math.pow(1 - t, 3) * y1 +
                    3 * t * Math.pow(1 - t, 2) * y2 +
                    3 * Math.pow(t, 2) * (1 - t) * y3 +
                    Math.pow(t, 3) * y4);

            plot(g, xt, yt, size);
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

    public void midpointCircle(Graphics g, int xc, int yc, int r) {
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

    public void midpointEllipse(Graphics g, int xc, int yc, int a, int b) {
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