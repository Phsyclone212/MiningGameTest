package frame;

import java.awt.*;
import javax.swing.*;

public class CanvasPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // custom rendering options below
        int padX = getWidth() / 30;
        int padY = getHeight() / 20;

        int nodeHeight = getHeight() / 10;
        int nodeWidth = getWidth() / 10;
        g.drawRect(padX, padY, nodeWidth, nodeHeight); /// nodes are going to be what players will click on to mine eventually.

        g.drawRect(padX*2 + nodeWidth, padY, nodeWidth, nodeHeight);
        g.drawRect(padX*3 + nodeWidth*2, padY, nodeWidth, nodeHeight);
        g.drawRect(padX*4 + nodeWidth*3, padY, nodeWidth, nodeHeight);
    }
}
