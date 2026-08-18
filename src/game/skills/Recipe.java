package game.skills;

import java.util.Map;
import game.Item;
import game.world.OreType;

public enum Recipe {
    CRUDESTONE("Crude Sharpening Stone", 1, 5, Map.of(OreType.ROCK, 5));

    private final String recipeName;
    private final int reqLevel;
    private final int exp;
    private final Map<Item, Integer> recipeCost;

    Recipe(String recipeName, int reqLevel, int exp, Map<Item, Integer> cost){
        this.recipeName = recipeName;
        this.reqLevel = reqLevel;
        this.exp = exp;
        this.recipeCost = cost;
    }
    

    public String getName() {
        return recipeName;
    }
    public int getReqLevel() {
        return reqLevel;
    }
    public int getExp() {
        return exp;
    }
    public Map<Item, Integer> getRecipeCost() {
        return recipeCost;
    }

}

