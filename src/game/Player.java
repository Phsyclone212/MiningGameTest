package game;

import game.managers.MiningManager;
import game.skills.CraftingSkill;
import game.skills.MiningSkill;

public class Player {
    
    private int playerLevel;
    // private int PlayerExp = 0;
    // private int xpThreshold = 100;

    // private Inventory inventory;

    private CraftingSkill craftingSkill; // This is the crafting SKILL which holds it's own level, xp, etc.
    private MiningSkill miningSkill; // This is the mining SKILL which holds it's own level,

    private MiningManager miningManager; // This is the mining MANAGER which handles mining actions, resources, etc.

    public Player() {
        this.playerLevel = 1;
        // this.inventory = new Inventory();
        this.craftingSkill = new CraftingSkill();
        this.miningSkill = new MiningSkill();
        this.miningManager = new MiningManager(this.miningSkill);

    }


    // Update player state each tick -- This is the stuff that will ALWAYS run every tick of the engine.
    public void tick() {
        miningManager.tick();
    }

    public MiningManager getMiningManager() {
        return miningManager;
    }
}
