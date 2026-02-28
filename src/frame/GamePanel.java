package frame;

import game.Game;
import java.awt.*;
import javax.swing.*;


public class GamePanel extends JPanel {

    private CanvasPanel canvasPanel = new CanvasPanel();
    private JLabel status = new JLabel("Awaiting selection...");
    private JButton mineBtn = new JButton("Mine");

    public GamePanel(Game game) {
        System.out.println("GamePanel created.");

        this.setLayout(new BorderLayout());
        this.add(status, BorderLayout.NORTH);

        this.setFocusable(true);
        
        this.add(canvasPanel, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        this.add(buttons, BorderLayout.SOUTH);
        buttons.add(mineBtn);
        
        mineBtn.addActionListener(e -> {
            // do we HAVE to go through the player to mine? NO. We aren't stuck to CLI anymore!
            status.setText("Mining...");
            
        });

    }

    
}
