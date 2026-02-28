package frame;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

    public GameWindow (GamePanel gamePanel) {
        
        System.out.println("GameWindow created");

        setSize(1280, 720);
        setTitle("A Mining Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(gamePanel);
        setVisible(true);
    }


}
