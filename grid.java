import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
// import java.awt.Polygon;
// import java.util.ArrayList;
// import java.util.List;

public class grid {

    protected static Graphics g = null;

    public static Graphics getG() {
        return g;
    }

    public static void attachGraphics(Graphics _g) {
        g = _g;
        g.setColor(Color.black);
        System.out.println("Attached New Graphics To Drawing (static)");
    }

    public static void printXY(int x, int y) {
        System.out.printf("(%d,%d)\t", x, y);
    }

    public static void plotDot(int x, int y) {
        // g.fillRect(x, y, 1, 1);
        // int rad = 4;
        drawGeneralDot(x, y, 1);
    }

    public static void drawGeneralDot(Point p, int rad) {
        g.fillRect(p.x, p.y, rad, rad);
    }

    public static void drawGeneralDot(int x, int y, int rad) {
        g.fillRect(x, y, rad, rad);
    }

    public static void drawGrid(int width, int height, int nrows, int ncols) {
        int dw = width / ncols;
        int dh = height / nrows;

        g.setColor(Color.black);
        for (int y = 0; y < nrows; y++) {
            for (int x = 0; x < ncols; x++) {
                int xx = x * dw;
                int yy = y * dh;
                String s = String.format("%d,%d", xx, yy);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 8));
                g.drawString(s, xx, yy);
                drawGeneralDot(xx, yy, 3);
            }
        }
    }
}