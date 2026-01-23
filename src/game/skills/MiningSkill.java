package game.skills;

public class MiningSkill {
    
    private int miningLevel = 1;
    private int miningXp = 0;
    private int xpThreshold = 100;

    public MiningSkill() {
        
    }

    public void mine() {
        System.out.println("Mining in progress...");
        // player will mine, gain xp based on what is found, and keep what is mined. This needs manager, not here.
    }

    public void addXp(int xp) {
        this.miningXp += xp;
        checkLevelUp();
    }

    public void checkLevelUp() {
        while (miningXp >= xpThreshold) {
            miningLevel++;
            xpThreshold = xpThreshold + (miningLevel * 100);
            System.out.println("Congratulations! You've reached Mining Level " + miningLevel);
        }
    }

    // Getters and Setters
    public int getMiningLevel() {
        return miningLevel;
    }
    public int getMiningXp() {
        return miningXp;
    }
    public int getXpThreshold() {
        return xpThreshold;
    }

    public void setMiningLevel(int level) {
        this.miningLevel = level;
    }
    public void setMiningXp(int xp) {
        this.miningXp = xp;
    }
    public void setXpThreshold(int threshold) {
        this.xpThreshold = threshold;
    }
}