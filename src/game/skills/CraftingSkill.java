package game.skills;

public class CraftingSkill {
    
    private int craftingLevel = 1;
    private int craftingXp = 0;
    private int xpThreshold = 100;

    public CraftingSkill() {
        
    }

    public void addXp(int xp) {
        this.craftingXp += xp;
        checkLevelUp();
    }

    public void checkLevelUp() {
        while (craftingXp >= xpThreshold) {
            craftingLevel++;
            xpThreshold = xpThreshold + (craftingLevel * 100);
            System.out.println("Congratulations! You've reached Crafting Level " + craftingLevel);
        }
    }

    // Getters and Setters

    public int getCraftingLevel() {
        return craftingLevel;
    }
    public int getCraftingXp() {
        return craftingXp;
    }
    public int getXpThreshold() {
        return xpThreshold;
    }

    public void setCraftingLevel(int level) {
        this.craftingLevel = level;
    }
    public void setCraftingXp(int xp) {
        this.craftingXp = xp;
    }
    public void setXpThreshold(int threshold) {
        this.xpThreshold = threshold;
    }

}
