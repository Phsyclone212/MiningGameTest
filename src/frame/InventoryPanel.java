package frame;

import game.Inventory;
import game.Item;
import java.awt.*;
import java.util.Map;
import javax.swing.*;

public class InventoryPanel extends JPanel {

    private Inventory inventory;

    public InventoryPanel(Inventory inventory) {
        this.inventory = inventory;
        setPreferredSize(new Dimension(150, 0));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawString("Inventory:", 10, 20);
        int y = 40;
        for(Map.Entry<Item, Integer> entry : inventory.getInventory().entrySet()) {
            g.drawString(entry.getKey().getName() + ": " + entry.getValue(), 10, y);
            y += 20;
        }
    }
    
}
