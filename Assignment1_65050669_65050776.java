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
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();

        
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600);

        
        // g2.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
         
        g2.setColor(Color.BLACK);
        
        BezierCurve(g2, 200, 306, 200, 302, 204, 317, 220, 307);

        BresenhamLine(g2, 128, 23, 460, 23); // upper
        BresenhamLine(g2, 128, 538, 460, 538); // under
        BresenhamLine(g2, 27, 121, 27, 442); // left
        BresenhamLine(g2, 563, 121, 563, 442); // right

        // Body
        bezierCurve(g2, 263, 205, 261, 210, 261, 212, 260, 216,1);
        bezierCurve(g2, 262, 237, 267, 259, 275, 280, 283, 303,1);
        bezierCurve(g2, 283, 303, 283, 317, 280, 332, 271, 349,1);
        bezierCurve(g2, 271, 349, 263, 355, 247, 354, 226, 348,1);
        bezierCurve(g2, 315, 253, 323, 270, 339, 313, 344, 350,1);
        bezierCurve(g2, 226, 348, 219, 340, 199, 331, 183, 336,1);
        bezierCurve(g2, 344, 350, 341, 381, 330, 406, 295, 433,1);
        bezierCurve(g2, 163, 424, 147, 412, 132, 400, 110, 371,1);
        bezierCurve(g2, 252, 443, 237, 443, 221, 442, 204, 439,1);
        bezierCurve(g2, 394, 278, 400, 294, 407, 327, 409, 350,1);
        bezierCurve(g2, 409, 350, 405, 375, 399, 390, 394, 401,1);
        bezierCurve(g2, 394, 401, 370, 428, 339, 446, 299, 456,1);
        bezierCurve(g2, 260, 460, 239, 460, 217, 457, 198, 452,1);
        bezierCurve(g2, 163, 437, 143, 421, 123, 402, 109, 370,1);
        bezierCurve(g2, 231, 387, 236, 388, 241, 388, 251, 388,1);

        // Neck Detail
        bezierCurve(g2, 322, 270, 350, 292, 380, 294, 392, 277,1); // 1
        bezierCurve(g2, 338, 311, 362, 335, 395, 335, 403, 311,1); // 2
        bezierCurve(g2, 343, 352, 363, 375, 391, 379, 409, 351,1); // 3
        bezierCurve(g2, 336, 393, 342, 408, 361, 420, 393, 402,1); // 4
        bezierCurve(g2, 313, 423, 311, 434, 315, 447, 327, 450,1); // 5
        bezierCurve(g2, 247, 444, 243, 448, 242, 453, 247, 460,1); // 6
        bezierCurve(g2, 219, 443, 212, 444, 211, 452, 215, 458,1); // 7
        bezierCurve(g2, 319, 400, 331, 423, 364, 432, 394, 400,1);
        bezierCurve(g2, 153, 429, 150, 424, 153, 419, 160, 420,1);

        // Leg LF
        bezierCurve(g2, 338, 446, 343, 452, 358, 461, 369, 468,1);
        bezierCurve(g2, 394, 401, 375, 428, 379, 448, 399, 456,1);

        // Leg RF
        bezierCurve(g2, 252, 443, 255, 447, 267, 464, 286, 475,1);
        bezierCurve(g2, 319, 401, 310, 418, 299, 430, 285, 441,1);
        bezierCurve(g2, 285, 441, 291, 448, 301, 456, 311, 466,1);
        bezierCurve(g2, 267, 381, 262, 400, 255, 427, 253, 444,1);

        // Leg RB
        bezierCurve(g2, 227, 356, 231, 376, 226, 403, 209, 420,1);
        bezierCurve(g2, 167, 368, 167, 373, 167, 380, 168, 392,1);
        bezierCurve(g2, 111, 369, 128, 377, 151, 376, 167, 368,1);
        bezierCurve(g2, 164, 448, 164, 453, 173, 467, 176, 477,1);
        bezierCurve(g2, 208, 421, 209, 431, 203, 440, 197, 452,1);
        bezierCurve(g2, 197, 452, 199, 456, 202, 466, 209, 469,1);
        bezierCurve(g2, 168, 392, 163, 400, 163, 411, 166, 416,1);
        bezierCurve(g2, 166, 416, 163, 421, 165, 432, 165, 448,1);

        // Foot RB
        bezierCurve(g2, 161, 496, 160, 481, 171, 479, 185, 481,1);
        bezierCurve(g2, 185, 481, 187, 467, 217, 470, 220, 483,1);
        bezierCurve(g2, 216, 474, 221, 465, 240, 478, 241, 496,1);
        bezierCurve(g2, 162, 496, 184, 496, 217, 496, 240, 496,1);

        // Foot RF
        bezierCurve(g2, 278, 494, 275, 477, 293, 475, 301, 480,1);
        bezierCurve(g2, 301, 480, 302, 465, 331, 467, 336, 480,1);
        bezierCurve(g2, 332, 474, 337, 466, 358, 478, 358, 494,1);
        bezierCurve(g2, 277, 496, 305, 496, 335, 496, 358, 496, 1);

        // Foot LF
        bezierCurve(g2, 365, 485, 365, 468, 379, 466, 387, 468,1);
        bezierCurve(g2, 387, 468, 387, 457, 419, 459, 423, 471,1);
        bezierCurve(g2, 419, 463, 428, 456, 446, 468, 445, 484,1);
        bezierCurve(g2, 364, 486, 391, 486, 417, 486, 443, 486,1);

        // Tail
        // BezierCurve(g2, 110, 370, 107, 348, 107, 326, 111, 308);
        bezierCurve(g2, 319, 93,318, 83,305, 74,293, 72,1);
        bezierCurve(g2, 264, 126,243, 125,230, 118,223, 105,1);
        bezierCurve(g2, 178, 102,188, 119,205, 133,223, 132,1);

        bezierCurve(g2, 347, 213,364, 230,397, 230,412, 202,1);
        bezierCurve(g2, 276, 171,289, 215,313, 212,347, 213,1);
        bezierCurve(g2, 347, 184,326, 183,300, 182,276, 171,1);

        //leaf
        bezierCurve(g2, 114, 78,112, 98, 120, 116,142, 128,1);
        bezierCurve(g2, 114, 78,132, 93, 138, 106,142, 128,1);

        bezierCurve(g2, 426, 293,443, 281, 466, 275,491, 277,1);
        bezierCurve(g2, 426, 293,450, 303, 471, 288, 491, 277,1);


        bezierCurve(g2, 434, 308,455, 311, 475, 317,493, 329,1);
        bezierCurve(g2, 434, 308,450, 324, 467, 330, 493, 329,1);

        bezierCurve(g2, 68, 187,86, 171, 108, 165,129, 169,1);
        bezierCurve(g2, 68, 187,92, 187, 113, 182, 129, 169,1);

        midpointEllipse(g2, 290, 490, 210, 21);

        // paint
        // buffer = floodFill(buffer, 376, 351, Color.WHITE, Color.PINK);
        // g2.drawImage(buffer, 0, 0, null);
        bezierCurve(g2,474,194,487,192,490,189,498,180,3);
        bezierCurve(g2,498,180,499,177,503,164,501,151,3);
        bezierCurve(g2,501,151,498,144,496,140,492,135,3);
        bezierCurve(g2,492,135,488,133,480,130,470,124,3);
        bezierCurve(g2,470,124,498,144,496,140,492,135,3);
        bezierCurve(g2,492,135,498,144,496,140,492,135,3);
        bezierCurve(g2,492,135,498,144,496,140,492,135,3);
        bezierCurve(g2,492,135,498,144,496,140,492,135,3);

        bezierCurve(g2,480,130,473,115,467,105,473,97,3);
        bezierCurve(g2,492,135,498,144,496,140,492,135,3);

        //eye
        midpointEllipse(g2,333,165,13,11);
        midpointCircle(g2,325,160,5);
        
        //nose
        BezierCurve(g2,417,196,431,201,444,198,448,195);
        BezierCurve(g2,448,195,467,187,456,179,447,176);
        BezierCurve(g2,447,176,448,165,441,158,432,155);
        BezierCurve(g2,432,155,419,159,411,157,401,154);
        BezierCurve(g2,401,154,389, 155,378, 161,374, 177);
        BezierCurve(g2,374, 177,350, 174,347, 183,355, 200);
        BezierCurve(g2,355, 200,374, 212,403, 206,417,196);
        //horn
        BezierCurve(g2,394, 110,394, 94,392, 86,387, 78);
        BezierCurve(g2,387, 78,376, 72,362, 65,361, 42);
        BezierCurve(g2,361, 42,345, 63,353, 76,363, 86);
        BezierCurve(g2,363, 86,366, 88,370, 100,369, 110);

        BezierCurve(g2,418, 129,420, 124,419, 117,416, 112);
        BezierCurve(g2,416, 112,427, 116,431, 127,428, 137);
        BezierCurve(g2,428, 137,425, 132,421, 130,418, 129);

        BezierCurve(g2,418, 129,420, 124,419, 117,416, 112);
        BezierCurve(g2,416, 112,427, 116,431, 127,428, 137);
        BezierCurve(g2,428, 137,425, 132,421, 130,418, 129);
        //detail
        
        bezierCurve(g2, 377, 163, 375, 149, 365, 136, 346, 127,1);
        bezierCurve(g2, 381, 159,380, 148,372, 133,361, 125,1);
        bezierCurve(g2, 398, 153,400, 144,398, 132,392, 125,1);
        bezierCurve(g2, 402, 153,404, 143,403, 125,395, 116, 1);

        // Scale
        bezierCurve(g2, 136, 417, 129, 419, 124, 413, 123, 408,1);
        bezierCurve(g2, 123, 408, 111, 406, 107, 397, 112, 392,1);
        bezierCurve(g2, 112, 392, 80, 390, 73, 360, 97, 361,1);
        bezierCurve(g2, 97, 361, 70, 339, 74, 311, 99, 319,1);
        bezierCurve(g2, 99, 319, 78, 296, 91, 268, 114, 284,1);
        bezierCurve(g2, 114, 284, 100, 260, 114, 237, 141, 251,1);
        bezierCurve(g2, 141, 251, 138, 230, 173, 220, 180, 236,1);
        bezierCurve(g2, 180, 236, 195, 211, 223, 227, 219, 240,1);
        bezierCurve(g2, 219, 240, 236, 233, 259, 254, 246, 264, 1);
        bezierCurve(g2, 246, 264, 259, 272, 260, 297, 251, 298,1);
        bezierCurve(g2, 251, 298, 262, 312, 249, 329, 241, 324,1);
        bezierCurve(g2, 241, 324, 239, 340, 227, 341, 217, 337,1);
        bezierCurve(g2, 198, 332, 193, 325, 195, 325, 195, 321,1);
        bezierCurve(g2, 195, 321, 181, 310, 179, 299, 187, 285, 1);
        // Tail Add
        bezierCurve(g2, 111, 371,107, 351,108, 322,118, 294,1);
        bezierCurve(g2, 118, 294,128, 274,151, 257,167, 250,1);
        bezierCurve(g2, 167, 250,195, 245,221, 256,235, 274,1);
        bezierCurve(g2, 235, 274,240, 299,231, 319,216, 328,1);
        bezierCurve(g2, 216, 328,209, 328,202, 322,198, 312,1);
        bezierCurve(g2, 182, 335,173, 320,171, 308,171, 300,1);
        bezierCurve(g2, 171, 300,180, 288,192, 284,202, 284,1);
        bezierCurve(g2, 202, 284,211, 288,219, 299,219, 310,1);
        bezierCurve(g2, 219, 310,211, 315,206, 315,195, 312,1);
        //face
        bezierCurve(g2, 442, 250,444, 254,443, 266,436, 276,1);
        bezierCurve(g2, 436, 276,437, 270, 434, 265, 431, 261,1);
        bezierCurve(g2, 431, 261, 428, 270, 418, 278, 405, 281, 1);
        bezierCurve(g2, 405, 281, 410, 275, 411, 271, 410, 265,1);
        bezierCurve(g2, 410, 265, 400, 275, 385, 280, 365, 282,1);
        bezierCurve(g2, 365, 282,370, 276, 373, 271, 373, 266,1);
        bezierCurve(g2, 373, 266, 360, 271, 342, 270, 326, 263, 1);
        bezierCurve(g2, 326, 263,332, 262, 336, 259, 341, 257, 1);
        bezierCurve(g2, 341, 257, 331, 253, 317, 253, 305, 253,1);
        bezierCurve(g2, 442, 250,444, 254,443, 266,436, 276,1);
        bezierCurve(g2, 436, 276,437, 270, 434, 265, 431, 261,1);
        bezierCurve(g2, 431, 261, 428, 270, 418, 278, 405, 281, 1);
        bezierCurve(g2, 405, 281, 410, 275, 411, 271, 410, 265,1);
        bezierCurve(g2, 410, 265, 400, 275, 385, 280, 365, 282,1);
        bezierCurve(g2, 365, 282,370, 276, 373, 271, 373, 266,1);
        bezierCurve(g2, 373, 266, 360, 271, 342, 270, 326, 263, 1);
        bezierCurve(g2, 326, 263,332, 262, 336, 259, 341, 257, 1);
        bezierCurve(g2, 341, 257, 331, 253, 317, 253, 305, 253,1);

        buffer = floodFill(buffer, 400, 180, Color.WHITE, Color.YELLOW);
        g.drawImage(buffer, 0, 0, null);

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

            plot(g, xt, yt, 1);
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

    public BufferedImage floodFill(BufferedImage m, int x, int y, Color target_colour, Color replacement_Colour) {
        Graphics2D g2 = m.createGraphics();
        Queue<Point> q = new LinkedList<>();

        if (m.getRGB(x, y) == target_colour.getRGB()) {
            g2.setColor(replacement_Colour);
            plot(g2, x, y, 1);
            q.add(new Point(x, y));
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.y < 600 && m.getRGB(p.x, p.y + 1) == target_colour.getRGB()) {
                g2.setColor(replacement_Colour);
                plot(g2, p.x, p.y + 1, 1);
                q.add(new Point(p.x, p.y + 1));
            }
            if (p.y > 0 && m.getRGB(p.x, p.y - 1) == target_colour.getRGB()) {
                g2.setColor(replacement_Colour);
                plot(g2, p.x, p.y - 1, 1);
                q.add(new Point(p.x, p.y - 1));
            }
            if (p.x < 600 && m.getRGB(p.x + 1, p.y) == target_colour.getRGB()) {
                g2.setColor(replacement_Colour);
                plot(g2, p.x + 1, p.y, 1);
                q.add(new Point(p.x + 1, p.y));
            }
            if (p.x > 0 && m.getRGB(p.x - 1, p.y) == target_colour.getRGB()) {
                g2.setColor(replacement_Colour);
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