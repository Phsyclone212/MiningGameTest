package engine;

import game.Game;

public class Engine {
    
    private boolean isRunning = false;
    private Game game;

    private double tickRate = 0.6;
    private int tickCount = 0;
    private long lastUpdateTime = System.nanoTime();
    private long currentTime = System.nanoTime();
    private double delta = 0.0;
    private double accumulatedTime = 0.0;


    public Engine(Game game) {
        this.game = game;
        this.lastUpdateTime = System.nanoTime();
        this.currentTime = System.nanoTime();

        while(isRunning) {
            currentTime = System.nanoTime();
            delta = (currentTime - lastUpdateTime) / 1_000_000_000.0; // convert to seconds
            lastUpdateTime = currentTime;
            accumulatedTime += delta;

            while (accumulatedTime >= tickRate) {
                game.update();
                tickCount++;
                accumulatedTime -= tickRate;
            }
        }
        
    }

    public void update(Game game) {
        // Update game logic here.. maybe??
        System.out.println("Engine Update Tick: " + tickCount);
    }

    public void start() {
        this.isRunning = true;
        System.out.println("Engine started...");
    }
    public void stop() {
        this.isRunning = false;
        System.out.println("Engine stopped.");
    }

    public int getTickCount() {
        return tickCount;
    }
}
