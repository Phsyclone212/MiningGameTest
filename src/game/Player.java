package game;

import game.managers.MiningManager;
import game.skills.CraftingSkill;
import game.skills.MiningSkill;
import java.util.Scanner;

public class Player {
    
    private int PlayerLevel = 1;
    // private int PlayerExp = 0;
    // private int xpThreshold = 100;

    private int actionDelay = 0;

    private boolean isBusy = false;

    // private Inventory inventory;

    private CraftingSkill craftingSkill; // This is the crafting SKILL which holds it's own level, xp, etc.
    private MiningSkill miningSkill; // This is the mining SKILL which holds it's own level,

    private MiningManager miningManager; // This is the mining MANAGER which handles mining actions, resources, etc.

    public Player() {
        this.PlayerLevel = 1;
        // this.inventory = new Inventory();
        this.craftingSkill = new CraftingSkill();
        this.miningSkill = new MiningSkill();
        this.miningManager = new MiningManager(this.miningSkill);

    }


    // Update player state each tick -- This is the stuff that will ALWAYS run every tick of the engine.
    public void update() {
        // is the player available?
        System.out.println("Player Update Tick");
        if(!isBusy) {
            // means player is free to choose an action
            displayPlayerActions();
            actionInput();

        } else {
            // player is busy doing something
            System.out.println("Player is currently busy...");
            // check if action is complete - decrement delay
            if(actionDelay > 0) { // only decrement if greater than 0, otherwise negative delays cause instant actions.
                actionDelay--;
            }
            if(actionDelay <= 0) {
                isBusy = false;
                System.out.println("Player has completed their action and is now free.");
            }
        }
        
    }

    public void displayPlayerActions() {
        System.out.println("Available Player Actions:");
        System.out.println("1. Mine");
        System.out.println("2. Craft");
        System.out.println("3. Check Stats");
        System.out.println("4. Rest");
    }

    public void actionInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print(">> ");
        int choice = sc.nextInt();

        switch(choice) {
            case 1:
                System.out.println("You chose to Mine.");
                // initiate mining action
                miningManager.mine();
                actionDelay = miningManager.getActionDelay();
                isBusy = true;
                break;
            case 2:
                System.out.println("You chose to Craft.");
                // initiate crafting action
                break;
            case 3:
                System.out.println("You chose to Check Stats.");
                // displayStats();
                break;
            case 4:
                System.out.println("You chose to Rest.");
                // initiate rest action
                break;
            default:
                System.out.println("Invalid choice. Please select a valid action.");
        }
    }
}
