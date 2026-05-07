package frame;

import game.Game;
import java.awt.*;
import javax.swing.*;


public class GamePanel extends JPanel {

    private CanvasPanel canvasPanel;
    private JLabel status = new JLabel("Awaiting selection...");
    private JPanel inventoryPanel;

    public GamePanel(Game game) {
        System.out.println("GamePanel created.");
        this.canvasPanel = new CanvasPanel(game.getMiningManager(), this::updateStatus);

        this.setLayout(new BorderLayout());
        this.add(status, BorderLayout.NORTH);

        this.setFocusable(true);
        
        this.add(canvasPanel, BorderLayout.CENTER);

        inventoryPanel = new InventoryPanel(game.getInventory());
        this.add(inventoryPanel, BorderLayout.EAST);

    }

    public void updateStatus(String message) {
        status.setText(message);
    }
    
}
