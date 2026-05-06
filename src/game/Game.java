package game;

import engine.Engine;
import frame.GamePanel;
import frame.GameWindow;
import game.managers.MiningManager;

public class Game {
    
    private Player player;

    private Engine engine = new Engine(this);
    private GameWindow gameWindow;
    private GamePanel gamePanel;

    public Game() {

        engine.start();
        System.out.println("Game started! (from Game constructor)");
        player = new Player();

        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);

    }

    public void update() {
        // Update game logic here
        player.tick();
        gamePanel.tick();
        gamePanel.repaint();

    }

    public Player getPlayer() {
        return player;
    }

    public MiningManager getMiningManager() {
        return player.getMiningManager();
    }
}
