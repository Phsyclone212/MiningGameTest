package game.skills;

public class Skill {

    private int level = 1;
    private int xp = 0;
    private int xpThreshold = 100;
    private final String skillName;


    public Skill(String name) {
        skillName = name;
    }

    public void checkLevelUp() {
        while (xp >= xpThreshold) {
            level++;
            xpThreshold = xpThreshold + (level * 100);
            System.out.println("Congratulations! You've reached " + skillName + " Level " + level);
        }
    }

    public void gainExp(int exp) {
        this.xp += exp;
        checkLevelUp();
    }

    // Getters and Setters
    public int getSkillLevel() {
        return level;
    }
    public int getSkillXp() {
        return xp;
    }
    public int getXpThreshold() {
        return xpThreshold;
    }

    public void setSkillLevel(int level) {
        this.level = level;
    }
    public void setSkillXp(int xp) {
        this.xp = xp;
    }
    public void setXpThreshold(int threshold) {
        xpThreshold = threshold;
    }
    public String getSkillName() {
        return skillName;
    }
    
}
