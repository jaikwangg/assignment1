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

        
        //g2.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
         
        g2.setColor(Color.BLACK);
        // Floor
        g2.setColor(Color.decode("#f1c387"));
        midpointEllipse(g2, 290, 490, 210, 21);
        buffer = floodFill(buffer,  391, 499, Color.WHITE, Color.decode("#f1c387"));
        
        g2.setColor(Color.decode("#c49f6b"));
        BresenhamLine(g2, 30, 30, 560, 30); // upper
        BresenhamLine(g2, 30, 540, 560, 540); // under
        ddaLine(g2, 30, 30, 30, 540); // left
        ddaLine(g2, 560, 30, 560, 540); // right

        
        buffer = floodFill(buffer,  570, 421, Color.WHITE, Color.decode("#c49f6b"));
        

        // Body
        g2.setColor(Color.decode("#cf9040"));
        bezierCurve(g2, 263, 205, 261, 210, 261, 212, 261, 229,1);
        bezierCurve(g2, 262, 237, 267, 259, 275, 280, 283, 303,1);
        bezierCurve(g2, 283, 303, 283, 317, 280, 332, 271, 349,1);
        bezierCurve(g2, 271, 349, 263, 355, 247, 354, 226, 348,1);
        bezierCurve(g2, 226, 348, 219, 340, 199, 331, 183, 336,1);
        bezierCurve(g2, 315, 252, 323, 270, 339, 313, 344, 350,1);
        bezierCurve(g2, 344, 350, 341, 381, 330, 406, 295, 433,1);
        
        g2.setColor(Color.decode("#ffa624"));
        bezierCurve(g2, 394, 276, 400, 294, 407, 327, 409, 350,1);
        bezierCurve(g2, 409, 350, 405, 375, 399, 390, 394, 401,1);
        bezierCurve(g2, 394, 401, 370, 428, 339, 446, 299, 456,1);

        g2.setColor(Color.decode("#b76d24"));
        bezierCurve(g2, 226, 387, 236, 388, 241, 388, 253, 388,1);
        g2.setColor(Color.decode("#cf9040"));
        bezierCurve(g2, 163, 424, 147, 412, 132, 400, 110, 371,1);
        bezierCurve(g2, 252, 443, 237, 443, 221, 442, 204, 439,1);
        g2.setColor(Color.decode("#e97f17"));
        bezierCurve(g2, 265, 460, 239, 460, 217, 457, 198, 452,1);
        bezierCurve(g2, 163, 437, 143, 421, 123, 402, 109, 370,1);
        
        // Tail Add
        g2.setColor(Color.decode("#cf9040"));
        bezierCurve(g2, 111, 371,107, 351,108, 322,118, 294,1);
        bezierCurve(g2, 118, 294,128, 274,151, 257,167, 250,1);
        bezierCurve(g2, 167, 250,195, 245,221, 256,235, 274,1);
        bezierCurve(g2, 235, 274,240, 299,231, 319,216, 328,1);
        bezierCurve(g2, 216, 328,209, 328,202, 322,195, 312,1);
        bezierCurve(g2, 182, 335,173, 320,171, 308,171, 300,1);
        bezierCurve(g2, 171, 300,180, 288,192, 284,202, 284,1);
        bezierCurve(g2, 202, 284,211, 288,219, 299,219, 310,1);
        bezierCurve(g2, 219, 310,211, 315,206, 315,195, 312,1);

        // Leg LF
        bezierCurve(g2, 339, 442, 343, 452, 358, 461, 370, 472,1);
        bezierCurve(g2, 394, 401, 375, 428, 379, 448, 400, 460,1);
        bezierCurve(g2, 360, 463, 365, 456, 371, 446, 382, 437, 1); // shadow
        buffer = floodFill(buffer,  358, 443, Color.WHITE, Color.decode("#b76d24"));

        // Leg RF
        bezierCurve(g2, 252, 443, 255, 447, 267, 464, 288, 480,1);
        bezierCurve(g2, 319, 401, 310, 418, 299, 430, 285, 441,1);
        bezierCurve(g2, 285, 441, 291, 448, 301, 456, 316, 470,1);
        bezierCurve(g2, 267, 381, 262, 400, 255, 427, 253, 444,1);

        // Leg RB
        bezierCurve(g2, 227, 356, 231, 376, 226, 403, 209, 420,1);
        bezierCurve(g2, 167, 368, 167, 373, 167, 380, 168, 392,1);
        bezierCurve(g2, 111, 369, 128, 377, 151, 376, 167, 368,1);
        bezierCurve(g2, 164, 448, 164, 453, 173, 467, 176, 482,1);
        bezierCurve(g2, 208, 416, 209, 431, 203, 440, 197, 452,1);
        bezierCurve(g2, 197, 452, 199, 456, 202, 466, 209, 480,1);
        bezierCurve(g2, 168, 392, 163, 400, 163, 411, 166, 416,1);
        bezierCurve(g2, 166, 416, 163, 421, 165, 432, 165, 448,1);
        bezierCurve(g2, 164, 447, 175, 454, 189, 458, 202, 457, 1);
        bezierCurve(g2, 267, 464, 279, 463, 289, 460, 301, 455, 1);

        // Foot RB
        g2.setColor(Color.decode("#cf9041"));
        bezierCurve(g2, 161, 496, 160, 481, 171, 479, 185, 481,1);
        bezierCurve(g2, 185, 481, 190, 468, 217, 470, 220, 483,1);
        bezierCurve(g2, 215, 475, 221, 465, 240, 478, 241, 496,1);
        bezierCurve(g2, 162, 496, 184, 496, 217, 496, 240, 496,1);
        buffer = floodFill(buffer,  201, 483, Color.decode("#f1c387"), Color.decode("#cf9041"));

        // Foot RF
        bezierCurve(g2, 278, 494, 275, 477, 293, 475, 301, 480,1);
        bezierCurve(g2, 301, 480, 302, 465, 331, 467, 336, 480,1);
        bezierCurve(g2, 332, 474, 337, 466, 358, 478, 358, 496,1);
        bezierCurve(g2, 277, 496, 305, 496, 335, 496, 358, 496, 1);
        buffer = floodFill(buffer,  311, 488, Color.decode("#f1c387"), Color.decode("#cf9041"));

        // Foot LF
        
        g2.setColor(Color.decode("#c0822f"));
        bezierCurve(g2, 365, 485, 365, 468, 379, 466, 387, 468,1);
        bezierCurve(g2, 387, 468, 387, 457, 419, 459, 423, 471,1);
        g2.setColor(Color.decode("#cf9041"));
        bezierCurve(g2, 415, 463, 428, 456, 446, 468, 445, 486,1);
        bezierCurve(g2, 364, 486, 391, 486, 417, 486, 446, 486,1);
        buffer = floodFill(buffer,  407, 462, Color.WHITE, Color.decode("#cf9041"));
        buffer = floodFill(buffer,  391, 480, Color.decode("#f1c387"), Color.decode("#cf9041"));
        
        //leaf upper
        g2.setColor(Color.decode("#ce9141"));
        bezierCurve(g2, 114, 78,112, 98, 120, 116,142, 128,1);
        bezierCurve(g2, 114, 78,132, 93, 138, 106,142, 128,1);
        buffer = floodFill(buffer,  128, 105, Color.WHITE, Color.decode("#ce9141"));

        bezierCurve(g2, 426, 293,443, 281, 466, 275,491, 277,1);
        bezierCurve(g2, 426, 293,450, 303, 471, 288, 491, 277,1);
        buffer = floodFill(buffer,  459, 288, Color.WHITE, Color.decode("#ce9141"));

        // leaf under
        g2.setColor(Color.decode("#a2630c"));
        bezierCurve(g2, 434, 308,455, 311, 475, 317,493, 329,1);
        bezierCurve(g2, 434, 308,450, 324, 467, 330, 493, 329,1);
        buffer = floodFill(buffer,  466, 321, Color.WHITE, Color.decode("#a2630c"));
       
        bezierCurve(g2, 68, 187,86, 171, 108, 165,129, 169,1);
        bezierCurve(g2, 68, 187,92, 187, 113, 182, 129, 169,1);
        buffer = floodFill(buffer,  101, 174, Color.WHITE, Color.decode("#a2630c"));


        //eye
        g2.setColor(Color.decode("#ffa625"));
        midpointEllipse(g2,330, 169, 26,22);
        buffer = floodFill(buffer,  341, 182, Color.WHITE, Color.decode("#ffa625"));
        g2.setColor(Color.WHITE);
        midpointCircle(g2,332, 159,21);
        buffer = floodFill(buffer,  347, 158, Color.decode("#ffa625"), Color.WHITE);
        g2.setColor(Color.decode("#5f2e25"));
        midpointEllipse(g2,333,165,13,11);
        buffer = floodFill(buffer,   334, 166,Color.WHITE,  Color.decode("#5f2e25"));
        g2.setColor(Color.white);
        midpointCircle(g2,325,160,5);
        buffer = floodFill(buffer,  325,160, Color.decode("#5f2e25"), Color.WHITE);
       
        //nose
        g2.setColor(Color.decode("#5f2d24"));
        BezierCurve(g2,417,196,431,201,444,198,448,195);
        BezierCurve(g2,448,195,467,187,456,179,447,176);
        BezierCurve(g2,447,176,448,165,441,158,432,155);
        BezierCurve(g2,432,155,419,159,411,157,401,154);
        BezierCurve(g2,401,154,389, 155,378, 161,374, 177);
        BezierCurve(g2,374, 177,350, 174,347, 183,355, 200);
        BezierCurve(g2,355, 200,374, 212,403, 206,417,196);
        buffer = floodFill(buffer,396, 165, Color.WHITE, Color.decode("#5f2d24"));
        //nose shadow

        g2.setColor(Color.decode("#87473d"));
        BezierCurve(g2,402, 153, 386, 160, 379, 171, 391, 173);
        BezierCurve(g2,391, 173, 403, 160, 427, 170, 445, 163);
        buffer = floodFill(buffer,400, 161,  Color.decode("#5f2d24"), Color.decode("#87473d"));
        //nose detail
        g2.setColor(Color.decode("#4d241d"));
        BezierCurve(g2,373, 176, 378, 181, 388, 186, 397, 189);
        BezierCurve(g2, 418, 158, 424, 165, 427, 175, 421, 183);
        
        //horn
        g2.setColor(Color.decode("#5f2d24"));
        BezierCurve(g2,394, 110,394, 94,392, 86,387, 78);
        BezierCurve(g2,387, 78,376, 72,362, 65,361, 42);
        BezierCurve(g2,361, 42,345, 63,353, 76,363, 86);
        BezierCurve(g2,363, 86,366, 88,370, 100,369, 110);
        ddaLine(g2,394, 110,369, 110);
        BezierCurve(g2,250, 102,235, 102, 204, 86, 208, 53);
        BezierCurve(g2,292, 117 ,286, 100, 269, 101, 250, 102);
        BezierCurve(g2,208, 53,222, 85, 250, 85, 269, 81);
        BezierCurve(g2,269, 81, 285, 79, 325, 98, 326, 125);
        BezierCurve(g2,292, 117,303, 117, 314, 118, 326, 125);
        buffer = floodFill(buffer,  286, 93, Color.WHITE, Color.decode("#5f2d24"));
        buffer = floodFill(buffer,  376, 85, Color.WHITE, Color.decode("#5f2d24"));

        
        //horn shadow
        
        g2.setColor(Color.decode("#320c09"));
        BezierCurve(g2,384, 110,380, 94,380, 86,370, 78);
        BezierCurve(g2,370, 78,362, 72,350, 65,361, 42);
        BezierCurve(g2,361, 42,345, 63,353, 76,363, 86);
        BezierCurve(g2,363, 86,366, 88,370, 100,369, 110);
        ddaLine(g2,394, 110,369, 110);
        BezierCurve(g2,250, 102,235, 102, 204, 86, 208, 53);
        BezierCurve(g2,292, 117 ,286, 100, 269, 101, 250, 102);
        BezierCurve(g2,208, 53,222, 110, 250, 85, 269, 90);
        BezierCurve(g2,269, 90, 280, 85, 320, 98, 326, 125);
        BezierCurve(g2,292, 117,303, 117, 314, 118, 326, 125);
        buffer = floodFill(buffer,  292, 100,  Color.decode("#5f2d24"), Color.decode("#320c09"));
        buffer = floodFill(buffer,  375, 99,  Color.decode("#5f2d24"), Color.decode("#320c09"));
        //horn detail
        g2.setColor(Color.decode("#9f7567"));
        BresenhamLine(g2,369, 104, 393, 104);
        BresenhamLine(g2,368, 93, 391, 88);
        BresenhamLine(g2,361, 86, 378, 71);
        BresenhamLine(g2, 353, 77, 369, 65);
        BresenhamLine(g2,352, 62, 362, 58);
        
        BresenhamLine(g2,309, 118, 323, 115);
        BresenhamLine(g2,289, 114, 312, 97);
        BresenhamLine(g2,280, 105, 293, 50);
        BezierCurve(g2,265, 102, 266, 94, 266, 87, 269, 79);
        BezierCurve(g2,247, 102, 248, 95, 249, 90, 249, 85);
        BezierCurve(g2,228, 95, 232, 90, 233, 86, 234, 81);
        BezierCurve(g2,217, 80, 219, 77, 219, 76, 222, 73);
        //eyebrow
        g2.setColor(Color.decode("#a6671b"));
        bezierCurve(g2,306, 171, 294, 169, 283, 162, 274, 151,1);
        bezierCurve(g2,274, 151, 274, 139, 280, 125, 292, 117,1);
        bezierCurve(g2, 326, 123, 343, 135, 361, 149, 377, 170, 1);
        bezierCurve(g2, 306, 170, 306, 159, 314, 151, 333, 147, 1);
        bezierCurve(g2, 333, 147,355, 155, 357, 165, 355, 180, 1);
        buffer = floodFill(buffer,   307, 143, Color.WHITE,  Color.decode("#a6671b"));
        
        //shadow
        g2.setColor(Color.decode("#b76d24"));
        BezierCurve(g2,418, 129,420, 124,419, 117,416, 112);
        BezierCurve(g2,416, 112,427, 116,431, 127,428, 137);
        BezierCurve(g2,428, 137,425, 132,421, 130,418, 129);

        BezierCurve(g2,209, 173,199, 170, 196, 165, 188, 157);
        BezierCurve(g2,188, 157,205, 170, 231, 145, 254, 165);
        BezierCurve(g2,254, 165,234, 159, 219, 160,209, 173);
        bezierCurve(g2, 246, 119, 251, 112, 255, 107, 259, 102, 1);
        
        // Scale
        g2.setColor(Color.decode("#5f2d24"));
        bezierCurve(g2, 137, 415, 129, 419, 124, 413, 123, 408,1);
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
        bezierCurve(g2, 241, 324, 239, 340, 227, 341, 219, 342,1);
        bezierCurve(g2, 197, 335, 193, 325, 195, 325, 195, 321,1);
        bezierCurve(g2, 195, 321, 181, 310, 179, 299, 187, 285, 1);
        // buffer = floodFill(buffer,  106, 293, Color.WHITE, Color.decode("#5f2d24"));

        //more scale
        bezierCurve(g2, 248, 355, 250, 344, 258, 340, 268, 342, 1);
        bezierCurve(g2, 268, 342, 266, 334, 272, 324, 279, 322, 1);
        bezierCurve(g2, 279, 322, 273, 315, 269, 301, 275, 290, 1);
        bezierCurve(g2, 275, 290, 267, 285, 260, 269, 262, 255, 1);
        bezierCurve(g2, 262, 255, 257, 252, 247, 248, 244, 233, 1);
        bezierCurve(g2, 244, 233, 230, 233,  215, 212, 243, 193, 1);

        
        //face
        g2.setColor(Color.decode("#cf9040"));
        bezierCurve(g2, 394, 110,401, 109, 409, 105, 416, 112,1);
        bezierCurve(g2, 410, 156, 415, 145, 418, 137, 418, 129,1);
        bezierCurve(g2, 369, 110,359, 105, 352, 97, 344, 89, 1);
        bezierCurve(g2, 344, 89,   337, 78, 317, 68, 293, 73, 1);
        bezierCurve(g2, 293, 73,306, 76, 317, 85, 321, 95, 1);
        bezierCurve(g2, 305, 92, 309, 91, 307, 91, 321, 95, 1);
        
        bezierCurve(g2, 431, 261, 428, 270, 418, 278, 405, 281, 1);
        bezierCurve(g2, 405, 281, 410, 275, 411, 271, 410, 265,1);
        bezierCurve(g2, 410, 265, 400, 275, 385, 280, 365, 282,1);
        bezierCurve(g2, 365, 282,370, 276, 373, 271, 373, 266,1);
        bezierCurve(g2, 373, 266, 360, 271, 342, 270, 326, 263, 1);
        bezierCurve(g2, 326, 263,332, 262, 336, 259, 341, 257, 1);
        bezierCurve(g2, 341, 257, 331, 253, 317, 253, 305, 253,1);
        bezierCurve(g2, 431, 261,435, 264, 436, 270,436, 276,1);
        bezierCurve(g2, 442, 250,444, 254,443, 266,436, 276,1);
        bezierCurve(g2, 305, 253, 307, 250, 309, 247, 315, 244,1);
        bezierCurve(g2, 315, 244, 290, 248, 272, 230, 250, 240, 1);
        bezierCurve(g2, 250, 240, 260, 230, 274, 220, 286, 216,1);
        bezierCurve(g2, 286, 216,  272, 213, 260, 203, 250, 196,1);
        bezierCurve(g2, 250, 196,220, 185, 223, 202, 189, 195, 1);
        bezierCurve(g2, 189, 195,  200, 192, 209, 184, 209, 173, 1);
        bezierCurve(g2, 209, 173,188, 161, 179, 132, 180, 104, 1);
        bezierCurve(g2, 180, 104, 189, 121, 203, 133, 223, 136,1);
        bezierCurve(g2, 223, 136,218, 127, 219, 114, 224, 106, 1);
        bezierCurve(g2, 224, 106,   224, 120, 234, 130, 264, 128, 1);
        bezierCurve(g2, 264, 128,260, 120, 252, 120, 244, 123, 1);
        bezierCurve(g2, 244, 123, 257, 114, 278, 112, 292, 117,1);
        //left eye
        g2.setColor(Color.decode("#ffa625"));
        BezierCurve(g2,415, 136, 428, 143, 428, 150, 427, 157);
        BezierCurve(g2,428, 137, 432, 144, 433, 149, 433, 156);
        buffer = floodFill(buffer,425, 137, Color.WHITE,  Color.decode("#ffa625"));
        g2.setColor(Color.decode("#5f2d24"));
        BezierCurve(g2,415, 145, 421, 143, 423, 148, 424, 157);
        buffer = floodFill(buffer, 420, 150, Color.WHITE,  Color.decode("#5f2d24"));
        //mouth
        
        g2.setColor(Color.decode("#5f2d24"));
        bezierCurve(g2, 317, 229, 298, 227, 288, 220, 304, 212,1);
        bezierCurve(g2, 317, 229, 338, 260, 394, 265, 443, 250,1);
        bezierCurve(g2, 443, 250, 450, 240, 448, 239, 446, 237,1);
        bezierCurve(g2, 446, 237, 413, 245, 361, 265, 322, 217, 1);
        bezierCurve(g2, 304, 212,  308, 214, 315, 215, 322, 217, 1);
        buffer = floodFill(buffer, 386, 250, Color.WHITE, Color.decode("#5f2d24"));
        // BREAD BIG
        g2.setColor(Color.decode("#a6671b"));
        bezierCurve(g2, 350, 217,364, 226,397, 236,415, 205,1);
        bezierCurve(g2, 276, 171,289, 220,313, 217,350, 217,1);
        bezierCurve(g2, 352, 184,326, 190,300, 191,276, 171,1);
        bezierCurve(g2, 415, 205, 431, 220, 465, 223, 462, 194,1);
        bezierCurve(g2, 462, 194,476, 200, 480, 167, 472, 152,1);
        bezierCurve(g2, 472, 152,469, 162, 450, 173,447,176,1);
        buffer = floodFill(buffer,  336, 190, Color.decode("#ffa625"), Color.decode("#ad7018"));
        
        buffer = floodFill(buffer,  379, 216, Color.WHITE, Color.decode("#ad7018"));
        //tooth
        g2.setColor(Color.decode("#f7dfb9"));
        BezierCurve(g2,447, 238, 449, 226, 445, 226, 410, 213);
        //tongue
        g2.setColor(Color.decode("#864704"));
        BezierCurve(g2,337, 218, 337, 218, 343, 225, 367, 235);
        BezierCurve(g2,367, 235, 370, 225, 378, 232, 379, 237);
        BezierCurve(g2,379, 237, 399, 237, 421, 237, 440, 232);
        BezierCurve(g2,440, 232,  435, 228, 422, 218, 400, 220);
        
        buffer = floodFill(buffer,  391, 231, Color.WHITE, Color.decode("#864704"));
        //shadow tongue
        g2.setColor(Color.decode("#ac7017"));
        BezierCurve(g2,399, 237, 405, 228, 417, 221, 420, 221);        
        buffer = floodFill(buffer,  424, 227, Color.decode("#864704"), Color.decode("#ac7017"));

        //face detail
        g2.setColor(Color.decode("#f1bb75"));
        bezierCurve(g2, 377, 163, 375, 149, 365, 136, 346, 127,1);
        bezierCurve(g2, 381, 159,380, 148,372, 133,361, 125,1);
        bezierCurve(g2, 398, 153,400, 144,398, 132,392, 125,1);
        bezierCurve(g2, 402, 153,404, 143,403, 125,395, 116, 1);
        bezierCurve(g2, 223, 108, 224, 120, 235, 131, 251, 133, 1);
        bezierCurve(g2, 182, 108, 187, 127, 204, 146, 227, 150, 1);
        bezierCurve(g2, 182, 136, 188, 148, 203, 155, 225, 156, 1);
        bezierCurve(g2, 247, 175, 235, 174, 223, 185, 205, 196, 1);
        bezierCurve(g2, 267, 189, 247, 185, 229, 191, 210, 199, 1);
        bezierCurve(g2,  299, 125, 291, 141, 287, 155, 291, 168, 1);

        bezierCurve(g2, 294, 224, 282, 224, 251, 239, 299, 236, 1);
        // bezierCurve(g2, 288, 233, 253, 237, 357, 255, 351, 259, 1);
        bezierCurve(g2, 339, 262, 328, 262, 371, 257, 363, 264, 1);
        // bezierCurve(g2, 353, 265, 338, 266, 394, 259, 391, 266, 1);
        bezierCurve(g2, 384, 270, 371, 279, 403, 259, 401, 265, 1);
        bezierCurve(g2, 395, 272, 374, 280, 411, 258, 414, 262, 1);
        bezierCurve(g2, 415, 270, 410, 278, 424, 255, 424, 262, 1);
        // bezierCurve(g2, 421, 269, 414, 276, 434, 252, 438, 257, 1);
        bezierCurve(g2, 433, 257, 438, 259, 439, 264, 437, 272, 1);
        
        bezierCurve(g2, 330, 99, 327, 88, 323, 82, 318, 79, 1);
        bezierCurve(g2, 337, 92, 332, 82, 321, 74, 304, 70, 1);
        //body scale
        g2.setColor(Color.decode("#a26116"));
        bezierCurve(g2, 134, 341, 138, 329, 144, 323, 151, 325,1);
        bezierCurve(g2, 151, 325,153, 313, 158, 309, 164, 313, 1);
        bezierCurve(g2, 144, 317, 147, 303, 155, 299, 161, 307,1);
        bezierCurve(g2, 130, 317, 134, 309, 142, 308, 144, 317, 1);
        bezierCurve(g2, 152, 293, 158, 285, 167, 283, 169, 290,1);
        bezierCurve(g2, 136, 294, 141, 288, 149, 287, 152, 293, 1);
        bezierCurve(g2, 153, 277, 158, 272, 166, 271, 169, 279,1);
        bezierCurve(g2, 153, 277, 158, 272, 166, 271, 169, 279,1);
        bezierCurve(g2, 195, 381, 199, 392, 211, 398, 220, 393, 1);
        bezierCurve(g2, 181, 373, 182, 379, 189, 385, 195, 381,1);
        bezierCurve(g2, 185, 394, 186, 401, 195, 404, 201, 401, 1);
        bezierCurve(g2, 177, 406, 179, 412, 186, 415, 194, 410,1);
        bezierCurve(g2, 183, 428, 185, 434, 196, 435, 200, 428,1);
        bezierCurve(g2, 169, 426, 172, 432, 179, 433, 183, 428,1);
        bezierCurve(g2, 173, 438, 177, 444, 184, 445, 187, 441,1);
        bezierCurve(g2, 187, 445, 188, 445, 188, 449, 194, 453,1);
        bezierCurve(g2, 262, 431, 262, 439, 270, 441, 276, 434,1);
        bezierCurve(g2, 261, 420, 261, 425, 267, 428, 272, 424,1);
        bezierCurve(g2, 272, 424, 273, 429, 282, 432, 288, 426,1);
        bezierCurve(g2,  290, 405, 292, 413, 301, 413, 309, 408,1);
        bezierCurve(g2, 273, 398, 273, 408, 284, 410, 290, 405,1);
        bezierCurve(g2, 272, 385, 273, 393, 281, 396, 289, 393,1);
        bezierCurve(g2, 285, 395, 288, 401, 298, 399, 303, 391,1);
        bezierCurve(g2,  289, 355, 285, 365, 295, 369, 301, 366,1);
        bezierCurve(g2, 301, 366, 302, 375, 311, 374, 314, 366,1);
        bezierCurve(g2,  293, 333, 295, 345, 304, 347, 307, 342,1);
        bezierCurve(g2, 306, 334, 307, 342, 315, 345, 321, 339,1);
        bezierCurve(g2,  299, 312, 303, 321, 311, 320, 314, 311,1);
        bezierCurve(g2, 314, 311, 317, 321, 325, 322, 329, 316,1);
        bezierCurve(g2,290, 290, 296, 298, 307, 298, 309, 289,1);
        bezierCurve(g2, 309, 289, 312, 298, 320, 300, 326, 293,1);
        bezierCurve(g2,285, 271, 289, 279, 300, 277, 301, 267,1);
        // bezierCurve(g2,301, 267, 306, 276, 315, 277, 319, 270,1);
        // bezierCurve(g2,275, 250, 279, 258, 289, 262, 293, 256,1);
        // bezierCurve(g2,289, 250, 293, 256, 300, 262, 310, 257,1);
        // ครีปขาขวาหน้า
        bezierCurve(g2, 267, 381, 255, 385, 244, 394, 239, 406, 1);
        bezierCurve(g2, 239, 406, 243, 412, 249, 414, 255, 415, 1);
        bezierCurve(g2, 255, 415, 247, 419, 243, 424, 239, 432, 1);
        bezierCurve(g2, 239, 432, 241, 440, 247, 440, 253, 440, 1);


        //2 beard
        g2.setColor(Color.decode("#5c2f23"));
        bezierCurve(g2,462, 194,487,192,490,189,498,180,3);
        bezierCurve(g2,498,180,499,177,503,164,501,151,3);
        bezierCurve(g2,501,151,498,144,496,140,492,135,3);
        bezierCurve(g2,492,135,488,133,480,130,470,124,3);
        
        bezierCurve(g2,492,135,451, 117, 434, 104, 437, 80,3);

        bezierCurve(g2,480,130,473,115,467,105,473,97,3);
        bezierCurve(g2,492,135,498,144,496,140,492,135,3);
        //neck fill
        buffer = floodFill(buffer,  381, 330, Color.WHITE, Color.decode("#ffa624"));
        
        //shadow head
        //bezierCurve(g2,395, 279, 398, 285, 399, 290, 400, 296,1); 
        
        g2.setColor(Color.decode("#e97f17"));
        bezierCurve(g2, 400, 296, 384, 302, 355, 301, 338, 292, 1);
        bezierCurve(g2, 338, 292, 343, 287, 347, 285, 351, 283, 1);
        bezierCurve(g2, 351, 283, 339, 283, 328, 280, 323, 272, 1);
        buffer = floodFill(buffer,  365, 291, Color.decode("#ffa624"), Color.decode("#e97f17"));
        // buffer = floodFill(buffer,  320, 274, Color.decode("#ffa624"), Color.decode("#e97f17"));
        
        g2.setColor(Color.decode("#b76d24"));
        bezierCurve(g2, 265, 254, 281, 256, 299, 256, 318, 259, 1);
        bezierCurve(g2, 318, 259, 317, 266, 315, 267, 311, 270, 1);
        bezierCurve(g2, 311, 270, 314, 274, 319, 275, 327, 278, 1);
        buffer = floodFill(buffer,   320, 274, Color.WHITE, Color.decode("#b76d24"));
        //shadow neck fill
        g2.setColor(Color.decode("#e97f17"));
        bezierCurve(g2, 323, 403, 331, 423, 364, 432, 397, 400,1);
        buffer = floodFill(buffer,  330, 435, Color.decode("#ffa624"), Color.decode("#e97f17"));
        
        buffer = floodFill(buffer,  144, 418, Color.WHITE, Color.decode("#e97f17"));
        buffer = floodFill(buffer,  230, 453, Color.WHITE, Color.decode("#e97f17"));
        
        
        // Neck Detail
        g2.setColor(Color.decode("#dd8111"));
        bezierCurve(g2, 322, 270, 350, 292, 380, 294, 392, 277,1); // 1
        bezierCurve(g2, 335, 309, 362, 335, 395, 335, 403, 311,1); // 2
        bezierCurve(g2, 343, 352, 363, 375, 391, 379, 409, 351,1); // 3
        bezierCurve(g2, 332, 393, 342, 408, 361, 420, 393, 402,1); // 4
        g2.setColor(Color.decode("#c76005"));
        bezierCurve(g2, 313, 417, 311, 434, 315, 447, 327, 447,1); // 5
        bezierCurve(g2, 247, 444, 243, 448, 242, 453, 247, 460,1); // 6
        bezierCurve(g2, 219, 443, 212, 444, 211, 452, 215, 458,1); // 7
        bezierCurve(g2, 153, 429, 150, 424, 153, 419, 160, 420,1);

        //head fill
        buffer = floodFill(buffer,    269, 164, Color.WHITE, Color.decode("#cf9040"));
        buffer = floodFill(buffer,   313, 235, Color.WHITE, Color.decode("#cf9040"));
        
        buffer = floodFill(buffer,   345, 112, Color.WHITE, Color.decode("#cf9040"));
        //shadow head fill
        buffer = floodFill(buffer,   426, 124, Color.WHITE, Color.decode("#ac7017"));
        buffer = floodFill(buffer,   206, 165, Color.WHITE, Color.decode("#ac5e17"));
        buffer = floodFill(buffer,   268, 219, Color.WHITE, Color.decode("#ac5e17"));
        //body fill
        buffer = floodFill(buffer,  153, 339, Color.WHITE, Color.decode("#cf9040"));
        buffer = floodFill(buffer,  379, 455, Color.WHITE, Color.decode("#cf9040"));
        
        //shadow fill
        buffer = floodFill(buffer,  294, 466, Color.WHITE, Color.decode("#b76d24"));
        buffer = floodFill(buffer,  153, 394, Color.WHITE, Color.decode("#b76d24"));
        buffer = floodFill(buffer,  225, 420, Color.WHITE, Color.decode("#b76d24"));
        buffer = floodFill(buffer,   320, 415, Color.WHITE, Color.decode("#b76d24"));
        buffer = floodFill(buffer,    273, 245, Color.WHITE, Color.decode("#b76d24"));
        buffer = floodFill(buffer,    268, 105, Color.WHITE, Color.decode("#b76d24"));
        buffer = floodFill(buffer,   320, 415, Color.WHITE, Color.decode("#b76d24"));
        
        buffer = floodFill(buffer,  180, 465, Color.WHITE, Color.decode("#b76d24"));
        buffer = floodFill(buffer,   181, 474, Color.decode("#f1c387"), Color.decode("#b76d24"));
        buffer = floodFill(buffer,   297, 473, Color.decode("#f1c387"), Color.decode("#b76d24"));
        //scale fill
        buffer = floodFill(buffer,   110, 293, Color.WHITE, Color.decode("#5f2d24"));
        buffer = floodFill(buffer,   254, 208, Color.WHITE, Color.decode("#5f2d24"));
        buffer = floodFill(buffer,   259, 344, Color.WHITE, Color.decode("#5f2d24"));
        buffer = floodFill(buffer,   256, 410, Color.WHITE, Color.decode("#5f2d24"));
        
        // Beard เส้น Add
        g2.setColor( Color.decode("#5c2f23"));
        bezierCurve(g2, 343, 200, 322, 198, 301, 200, 285, 209, 3);
        bezierCurve(g2, 285, 209, 272, 222, 223, 219, 207, 202,3);
        bezierCurve(g2, 207, 202, 191, 188, 174, 170, 155, 150, 3);
        bezierCurve(g2, 155, 150, 139, 144, 127, 144, 115, 155, 3);
        bezierCurve(g2, 188, 186, 174, 183, 162, 184, 150, 190, 3);
        bezierCurve(g2, 150, 190, 143, 200, 139, 208, 141, 219, 3);
        // เส้นครีบ
        g2.setColor( Color.decode("#a67969"));
        bezierCurve(g2, 111, 377, 104, 380, 92, 380, 84, 379, 1);
        bezierCurve(g2, 106, 347, 95, 344, 87, 339, 82, 332, 1);
        bezierCurve(g2, 111, 309, 102, 304, 97, 298, 95, 292, 1);
        bezierCurve(g2, 127, 274, 124, 268, 122, 263, 120, 256, 1);
        bezierCurve(g2, 157, 252, 158, 245, 160, 238, 162, 232, 1);
        bezierCurve(g2, 191, 246, 196, 240, 200, 236, 210, 229, 1);
        bezierCurve(g2, 222, 256, 231, 252, 239, 252, 247, 252, 1);
        bezierCurve(g2, 236, 276, 245, 279, 251, 281, 259, 287, 1);
        bezierCurve(g2, 239, 304, 245, 307, 250, 312, 254, 320, 1);
        bezierCurve(g2, 231, 322, 234, 328, 234, 334, 232, 340, 1);
        bezierCurve(g2, 195, 311, 198, 300, 203, 299, 207, 306, 1);
        
        bezierCurve(g2, 263, 394, 255, 398, 246, 404, 241, 408, 1);
        bezierCurve(g2, 256, 427, 251, 427, 246, 429, 239, 436, 1);
        bezierCurve(g2, 259, 354, 258, 350, 255, 345, 254, 343, 1);
        bezierCurve(g2, 279, 332, 275, 333, 271, 331, 267, 331, 1);
        bezierCurve(g2, 283, 303, 279, 303, 274, 303, 271, 305, 1);
        bezierCurve(g2, 269, 271, 267, 273, 265, 274, 263, 276, 1);
        bezierCurve(g2, 258, 237, 255, 238, 253, 242, 249, 246, 1);

        // ม้วนครีบบนสุด
        bezierCurve(g2, 244, 236, 249, 232, 254, 228, 255, 223, 1);
        bezierCurve(g2, 255, 216, 251, 212, 243, 212, 237, 216, 1);
        bezierCurve(g2, 235, 220, 235, 223, 236, 225, 239, 228, 1);
        
        //background
        buffer = floodFill(buffer,   77, 143, Color.WHITE, Color.decode("#f7dfb9"));
        buffer = floodFill(buffer,    223, 207, Color.WHITE, Color.decode("#f7dfb9"));
        buffer = floodFill(buffer,   330, 455, Color.WHITE, Color.decode("#f7dfb9"));
        buffer = floodFill(buffer,   77, 143, Color.WHITE, Color.decode("#f7dfb9"));
        buffer = floodFill(buffer,   184, 323, Color.WHITE, Color.decode("#f7dfb9"));

        // เมฆขวาล่าง
        BresenhamLine(g2, 402, 377, 531, 377);
        bezierCurve(g2, 531, 377, 519, 371, 500, 366, 484, 366, 1);
        bezierCurve(g2, 484, 366, 491, 356, 492, 346, 486, 330, 1);
        bezierCurve(g2, 454, 323, 447, 330, 444, 332, 441, 337, 1);
        bezierCurve(g2, 443, 332, 442, 314, 421, 304, 401, 301, 1);

        bezierCurve(g2, 441, 337, 437, 355, 413, 353, 409, 340, 1);
        bezierCurve(g2, 408, 328, 411, 321, 417, 320, 427, 326, 1);

        buffer = floodFill(buffer,449, 359, Color.decode("#f7dfb9"), Color.WHITE);
        buffer = floodFill(buffer,429, 337, Color.decode("#f7dfb9"), Color.WHITE);

        // เมฆซ้ายบน
        BresenhamLine(g2, 246, 253, 261, 253);
        BresenhamLine(g2, 112, 253, 59, 253);
        bezierCurve(g2, 59, 253, 75, 248, 90, 240, 97, 229, 1);
        bezierCurve(g2, 96, 230, 94, 216, 98, 205, 109, 196, 1);
        bezierCurve(g2, 109, 196, 119, 192, 133, 195, 144, 200, 1);
        bezierCurve(g2, 145, 202, 150, 205, 154, 211, 157, 213, 1);
        bezierCurve(g2, 157, 213, 161, 208, 167, 202, 190, 196, 1);

        bezierCurve(g2, 97, 229, 111, 245, 127, 232, 125, 219, 1);
        bezierCurve(g2, 125, 219, 118, 210, 99, 220, 108, 229, 1);

        buffer = floodFill(buffer,128, 236, Color.decode("#f7dfb9"), Color.WHITE);

        // เมฆขวาบน
        BresenhamLine(g2, 445, 164, 465, 164);
        BresenhamLine(g2, 476, 164, 501, 164);
        BresenhamLine(g2, 504, 164, 516, 164);
        bezierCurve(g2, 516, 163, 515, 156, 509, 148, 500, 142, 1);
        bezierCurve(g2, 495, 142, 488, 142, 483, 144, 478, 145, 1);
        bezierCurve(g2, 478, 145, 481, 141, 479, 136, 478, 130, 1);
        bezierCurve(g2, 474, 124, 467, 115, 455, 112, 449, 114, 1);
        bezierCurve(g2, 449, 114, 439, 116, 437, 120, 427, 124, 1);

        bezierCurve(g2, 432, 151, 456, 151, 452, 127, 435, 127, 1);

        buffer = floodFill(buffer,436, 144, Color.decode("#f7dfb9"), Color.WHITE);
        buffer = floodFill(buffer,508, 157, Color.decode("#f7dfb9"), Color.WHITE);

        // หญ้าซ้าย
        BresenhamLine(g2, 172, 467, 56, 467);
        bezierCurve(g2, 56, 467, 66, 462, 82, 461, 99, 460, 1);
        bezierCurve(g2, 99, 460, 90, 454, 83, 448, 77, 437, 1);
        bezierCurve(g2, 77, 437, 87, 440, 97, 448, 104, 451, 1);
        bezierCurve(g2, 104, 451, 99, 438, 91, 420, 86, 392, 1);
        bezierCurve(g2, 84, 392, 84, 392, 99, 402, 131, 444, 1);
        bezierCurve(g2, 131, 444, 131, 444, 129, 435, 127, 419, 1);
        bezierCurve(g2, 127, 419, 155, 433, 157, 442, 162, 437, 1);

        bezierCurve(g2, 113, 466, 104, 457, 94, 451, 78, 438, 1);
        bezierCurve(g2, 128, 465, 116, 446, 106, 428, 86, 392, 1);
        bezierCurve(g2, 145, 466, 142, 452, 138, 434, 130, 423, 1);
        bezierCurve(g2, 229, 467, 230, 464, 231, 463, 232, 460, 1);

        buffer = floodFill(buffer,   87, 464, Color.decode("#f7dfb9"), Color.decode("#ffa624"));
        buffer = floodFill(buffer,    118, 456, Color.decode("#f7dfb9"), Color.decode("#ffa624"));
        buffer = floodFill(buffer,   132, 456, Color.decode("#f7dfb9"), Color.decode("#ffa624"));
        buffer = floodFill(buffer,   155, 456, Color.decode("#f7dfb9"), Color.decode("#ffa624"));
        

        // หญ้ากลาง
        BresenhamLine(g2, 205, 467, 272, 467);

        bezierCurve(g2, 207, 465, 207, 460, 207, 458, 207, 455, 1);

        buffer = floodFill(buffer,239, 464, Color.WHITE, Color.decode("#ffa624"));

        // หญ้าขวา
        BresenhamLine(g2, 430, 463, 524, 463);
        bezierCurve(g2, 524, 463, 515, 457, 500, 454, 480, 455, 1);
        bezierCurve(g2, 480, 455, 483, 448, 486, 440, 486, 433, 1);
        bezierCurve(g2, 486, 433, 468, 446, 463, 449, 463, 449, 1);
        bezierCurve(g2, 463, 449, 473, 420, 477, 391, 477, 391, 1);
        bezierCurve(g2, 477, 391, 445, 426, 429, 448, 429, 448, 1);
        bezierCurve(g2, 429, 448, 429, 429, 425, 421, 425, 421, 1);
        bezierCurve(g2, 425, 421, 413, 440, 409, 447, 409, 447, 1);
        bezierCurve(g2, 409, 447, 398, 429, 388, 422, 388, 422, 1);
        bezierCurve(g2, 388, 422, 386, 430, 387, 436, 386, 447, 1);
        bezierCurve(g2, 352, 459, 349, 460, 345, 462, 342, 464, 1);
        BresenhamLine(g2, 342, 464, 363, 464);

        bezierCurve(g2, 395, 454, 394, 444, 391, 432, 390, 422, 1);
        bezierCurve(g2, 415, 459, 419, 449, 421, 437, 425, 423, 1);
        bezierCurve(g2, 440, 463, 450, 444, 461, 421, 476, 395, 1);
        bezierCurve(g2, 464, 464, 471, 456, 478, 444, 483, 439, 1);

        buffer = floodFill(buffer,   478, 458, Color.decode("#f7dfb9"), Color.decode("#ffa624"));
        buffer = floodFill(buffer,    451, 454, Color.decode("#f7dfb9"), Color.decode("#ffa624"));
        buffer = floodFill(buffer,   430, 452, Color.decode("#f7dfb9"), Color.decode("#ffa624"));
        buffer = floodFill(buffer,   402, 448, Color.decode("#f7dfb9"), Color.decode("#ffa624"));
        buffer = floodFill(buffer,   390, 444, Color.decode("#f7dfb9"), Color.decode("#ffa624"));
        buffer = floodFill(buffer,    354, 462, Color.decode("#f7dfb9"), Color.decode("#ffa624"));
        g.drawImage(buffer, 0, 0, null);
        g.setColor(Color.white);
        // Nail RB
        int [] x0 = {171, 174, 179};
        int [] y0 = {495, 504, 495};
        g.fillPolygon(x0, y0, 3);

        int [] x1 = {203, 207, 211};
        int [] y1 = {495, 503, 495};
        g.fillPolygon(x1, y1, 3);

        int [] x2 = {227, 231, 235};
        int [] y2 = {495, 502, 495};
        g.fillPolygon(x2, y2, 3);

        // Nail RF
        int [] x3 = {287, 291, 295};
        int [] y3 = {493, 502, 493};
        g.fillPolygon(x3, y3, 3);

        int [] x4 = {319, 323, 328};
        int [] y4 = {493, 502, 493};
        g.fillPolygon(x4, y4, 3);

        int [] x5 = {343, 347, 351};
        int [] y5 = {493, 502, 493};
        g.fillPolygon(x5, y5, 3);

        // Nail LF
        int [] x6 = {374, 377, 381};
        int [] y6 = {484, 492, 484};
        g.fillPolygon(x6, y6, 3);

        int [] x7 = {407, 411, 414};
        int [] y7 = {484, 492, 484};
        g.fillPolygon(x7, y7, 3);

        int [] x8 = {429, 434, 438};
        int [] y8 = {484, 492, 484};
        g.fillPolygon(x8, y8, 3);
        
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