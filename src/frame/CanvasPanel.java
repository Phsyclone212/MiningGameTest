package frame;

import game.managers.MiningManager;
import game.world.OreNode;
import java.awt.*;
import javax.swing.*;

public class CanvasPanel extends JPanel {

    private OreNode[] oreNodes;

    private MiningManager miningManager;

    public CanvasPanel(MiningManager miningManager){
        this.miningManager = miningManager;
        this.oreNodes = miningManager.getOreNodes();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // custom rendering options below
        int padX = getWidth() / 30;
        int padY = getHeight() / 20;

        int nodeHeight = getHeight() / 10;
        int nodeWidth = getWidth() / 10;
        
        // draw ore nodes
        if(oreNodes != null) {
            for(OreNode oreNode : oreNodes) {
                if(!oreNode.isDepleted()) {
                    g.setColor(oreNode.getOreType().getColor());
                    g.fillRect(padX + oreNode.getPosX(), padY + oreNode.getPosY(), nodeWidth, nodeHeight);
                } else {
                    g.setColor(Color.GRAY);
                    g.fillRect(padX + oreNode.getPosX(), padY + oreNode.getPosY(), nodeWidth, nodeHeight);
                }
            }
        }
    }
}
