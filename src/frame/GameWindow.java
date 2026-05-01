package frame;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

    private final static int HEIGHT = 720;
    private final static int WIDTH = 1280;

    public GameWindow (GamePanel gamePanel) {
        
        System.out.println("GameWindow created");

        setSize(WIDTH, HEIGHT);
        setTitle("A Mining Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(gamePanel);
        setVisible(true);
    }


    public int getHeight() {
        return HEIGHT;
    }

    public int getWidth() {
        return WIDTH;
    }

}
