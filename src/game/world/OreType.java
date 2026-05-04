package game.world;

public enum OreType {
    ROCK("Rocks", 1, 5),
    COPPER_ORE("Copper Ore", 5, 10),
    TIN_ORE("Tin Ore", 5, 10),
    IRON_ORE("Iron Ore", 15, 25),
    SILVER_ORE("Silver Ore", 20, 35),
    COAL("Coal", 30, 50),
    GRANITE("Granite", 40, 65),
    GOLD_ORE("Gold Ore", 40, 65),
    GEM_GEODE("Geode", 50, 100), // gem geodes will need to be opened to receive a gem.
    OBSIDIAN("Obsidian", 70, 175),
    DRAGONGLASS("Dragonglass", 85, 250);

    private final String oreName;
    private final int reqLevel;
    private final int exp;

    OreType(String oreName, int reqLevel, int exp) {
        this.oreName = oreName;
        this.reqLevel = reqLevel;
        this.exp = exp;
    }

    public String getOreName() {
        return oreName;
    }
    public int getReqLevel() {
        return reqLevel;
    }
    public int getExp() {
        return exp;
    }
}
