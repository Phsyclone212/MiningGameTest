package engine;

import game.Game;
import javax.swing.Timer;

public class Engine {

    private Game game;

    private int tickRate = 600;
    private int tickCount = 0;

    private Timer timer;


    public Engine(Game game) {

        this.game = game;

    }

    public void start() {

        timer = new Timer(tickRate, e -> {
            tickCount++;
            game.update();
        });
        timer.start();
        System.out.println("Engine started...");

    }

    public void stop() {

        timer.stop();
        System.out.println("Engine stopped.");

    }

    public int getTickCount() {

        return tickCount;
        
    }
}
