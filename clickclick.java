import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class clickclick extends JPanel {

    private Image backgroundImage;

    public clickclick() {
        try {
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("10063949.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        clickclick m = new clickclick();
        JFrame f = new JFrame();
        f.add(m);
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        m.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = MouseInfo.getPointerInfo().getLocation();
                SwingUtilities.convertPointFromScreen(point, m);

                int mouseX = (int) point.getX();
                int mouseY = (int) point.getY();

                System.out.println("Mouse clicked at (" + mouseX + ", " + mouseY + ")");
            }
        });

        f.setVisible(true);
    }
}
