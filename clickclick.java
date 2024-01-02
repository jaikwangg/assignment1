import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class clickclick extends JPanel {

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
