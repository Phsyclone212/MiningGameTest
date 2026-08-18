package game;

import game.managers.CraftingManager;
import game.managers.MiningManager;
import game.skills.CraftingSkill;
import game.skills.MiningSkill;

public class Player {
    
    private int playerLevel;

    private Inventory inventory;

    private CraftingSkill craftingSkill; // This is the crafting SKILL which holds it's own level, xp, etc.
    private MiningSkill miningSkill; // This is the mining SKILL which holds it's own level,

    private MiningManager miningManager; // This is the mining MANAGER which handles mining actions, resources, etc.
    private CraftingManager craftingManager; // This is the crafting manager which handles crafting actions, subSkill tracking, recipes, etc.

    public Player() {
        this.playerLevel = 1;
        this.inventory = new Inventory();
        this.craftingSkill = new CraftingSkill();
        this.craftingManager = new CraftingManager(this.craftingSkill);
        this.miningSkill = new MiningSkill();
        this.miningManager = new MiningManager(this.miningSkill, this.inventory);

    }


    // Update player state each tick -- This is the stuff that will ALWAYS run every tick of the engine.
    public void tick() {
        miningManager.tick();
    }


    // Getters below
    
    public CraftingManager getCraftingManager() {
        return craftingManager;
    }

    public MiningManager getMiningManager() {
        return miningManager;
    }

    public int getPlayerLevel(){
        return playerLevel;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
