package game;

import engine.Engine;

public class Game {
    
    private Player player;
    private boolean isRunning = false;

    private Engine engine = new Engine(this);

    public Game() {

        isRunning = true;
        engine.start();
        System.out.println("Game started! (from Game constructor)");
        player = new Player();

        while(isRunning) {
            engine.update(this);
        }
    }

    public void start() {
        this.isRunning = true;
        System.out.println("Game started! (from Game class)");
    }

    public void update() {
        // Update game logic here
        System.out.println("Game Update Tick: " + engine.getTickCount());
        // check player status - if any pending actions or conditions are met
        player.update();
        // check resource regeneration - ores, trees, etc.
        
        // process player input - from UI or command line
    }
}
