package frame;

import javax.swing.JPanel;
import game.Game;

public class GamePanel extends JPanel {

    public GamePanel(Game game) {
        System.out.println("GamePanel created.");

        this.setPreferredSize(new java.awt.Dimension(800, 600));
        this.setBackground(java.awt.Color.BLACK);

        this.setFocusable(true);


    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // Custom rendering code can go here
    }
}
