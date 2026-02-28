package frame;

import java.awt.*;
import javax.swing.*;

public class CanvasPanel extends JPanel {

    private static final int NODE_WIDTH = 50;
    private static final int NODE_HEIGHT = 25;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // custom rendering options below
        g.drawRect(20, 20, NODE_WIDTH, NODE_HEIGHT);
    }
}
