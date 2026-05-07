package game.world;

import game.Item;
import java.awt.Color;

public enum OreType implements Item {
    ROCK("Rocks", 1, 5, 10, Color.GRAY),
    COPPER_ORE("Copper Ore", 5, 10, 20, Color.ORANGE),
    TIN_ORE("Tin Ore", 5, 10, 20, Color.LIGHT_GRAY),
    IRON_ORE("Iron Ore", 15, 25, 30, Color.DARK_GRAY),
    SILVER_ORE("Silver Ore", 20, 35, 40, Color.WHITE),
    COAL("Coal", 30, 50, 50, Color.BLACK),
    GRANITE("Granite", 40, 65, 65, Color.LIGHT_GRAY),
    GOLD_ORE("Gold Ore", 40, 65, 65, Color.YELLOW),
    GEM_GEODE("Geode", 50, 100, 100, Color.MAGENTA), // gem geodes will need to be opened to receive a gem.
    OBSIDIAN("Obsidian", 70, 175, 175, Color.DARK_GRAY),
    DRAGONGLASS("Dragonglass", 85, 250, 300, Color.CYAN);

    private final String oreName;
    private final int reqLevel;
    private final int exp;
    private final int respawnTime; // Time in ticks for the ore node to respawn after being depleted
    private Color color;

    OreType(String oreName, int reqLevel, int exp, int respawnTime, Color color) {
        this.oreName = oreName;
        this.reqLevel = reqLevel;
        this.exp = exp;
        this.respawnTime = respawnTime;
        this.color = color;
    }

    @Override
    public String getName() {
        return oreName;
    }
    public int getReqLevel() {
        return reqLevel;
    }
    public int getExp() {
        return exp;
    }
    public int getRespawnTime() {
        return respawnTime;
    }
    public Color getColor() {
        return color;
    }
    
}
