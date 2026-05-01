package game;

import engine.Engine;
import frame.GamePanel;
import frame.GameWindow;

public class Game {
    
    private Player player;
    private boolean isRunning = false;

    private Engine engine = new Engine(this);
    private GameWindow gameWindow;
    private GamePanel gamePanel;

    public Game() {

        isRunning = true;
        engine.start();
        System.out.println("Game started! (from Game constructor)");
        player = new Player();

        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);

    }

    public void start() {
        this.isRunning = true;
        System.out.println("Game started! (from Game class)");
    }

    public void update() {
        // Update game logic here
        gamePanel.repaint();

    }

    public Player getPlayer() {
        return player;
    }
}
