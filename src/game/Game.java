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
            engine.update(this); // main game loop begins here (it seems)
        }
    }

    public void start() {
        this.isRunning = true;
        System.out.println("Game started! (from Game class)");
    }

    public void update() {
        // Update game class logic here
        System.out.println("Game Update Tick: " + engine.getTickCount());

    }

    public Player getPlayer() {
        return player;
    }
}
