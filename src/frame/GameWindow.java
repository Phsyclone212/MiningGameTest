package frame;

import javax.swing.JFrame;

public class GameWindow {
    private JFrame frame;

    public GameWindow (GamePanel gamePanel) {
        
        System.out.println("GameWindow created");

        this.frame = new JFrame();
        frame.add(gamePanel);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}
