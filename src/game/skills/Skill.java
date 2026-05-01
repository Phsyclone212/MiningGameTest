package game.skills;

public class Skill {

    private int level = 1;
    private int xp = 0;
    private int xpThreshold = 100;
    private final String skillName;


    public Skill(String name) {
        this.skillName = name;
    }

    public void checkLevelUp() {
        while (xp >= xpThreshold) {
            level++;
            xpThreshold = xpThreshold + (level * 100);
            System.out.println("Congratulations! You've reached " + this.skillName + " Level " + this.level);
        }
    }

    public void addXp(int xp) {
        this.xp += xp;
        checkLevelUp();
    }

    // Getters and Setters
    public int getSkillLevel() {
        return this.level;
    }
    public int getSkillXp() {
        return this.xp;
    }
    public int getXpThreshold() {
        return this.xpThreshold;
    }

    public void setSkillLevel(int level) {
        this.level = level;
    }
    public void setSkillXp(int xp) {
        this.xp = xp;
    }
    public void setXpThreshold(int threshold) {
        this.xpThreshold = threshold;
    }
    public String getSkillName() {
        return this.skillName;
    }
    
}
