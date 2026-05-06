package frame;

import game.managers.MiningManager;
import game.world.OreNode;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.*;

public class CanvasPanel extends JPanel {

    private OreNode[] oreNodes;

    private MiningManager miningManager;

    private Consumer<String> onStatus;

    public CanvasPanel(MiningManager miningManager, Consumer<String> onStatus) {
        this.miningManager = miningManager;
        this.oreNodes = miningManager.getOreNodes();
        this.onStatus = onStatus;

        // mouse listener for mining
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();
                int padX = getWidth() / 30;
                int padY = getHeight() / 20;
                for(OreNode oreNode : oreNodes) {
                    if(mouseX >= padX + oreNode.getPosX() && mouseX <= padX + oreNode.getPosX() + oreNode.getWidth() &&
                       mouseY >= padY + oreNode.getPosY() && mouseY <= padY + oreNode.getPosY() + oreNode.getHeight()) {
                        miningManager.attemptMine(oreNode);
                        onStatus.accept(miningManager.attemptMine(oreNode));
                        repaint();
                        break;
                    }
                }
            }
        };
        this.addMouseListener(mouseAdapter);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // custom rendering options below
        int padX = getWidth() / 30;
        int padY = getHeight() / 20;
        
        // draw ore nodes
        if(oreNodes != null) {
            for(OreNode oreNode : oreNodes) {
                if(!oreNode.isDepleted()) {
                    g.setColor(oreNode.getOreType().getColor());
                    g.fillRect(padX + oreNode.getPosX(), padY + oreNode.getPosY(), oreNode.getWidth(), oreNode.getHeight());
                } else {
                    g.setColor(Color.GRAY);
                    g.fillRect(padX + oreNode.getPosX(), padY + oreNode.getPosY(), oreNode.getWidth(), oreNode.getHeight());
                }
            }
        }
    }
}
