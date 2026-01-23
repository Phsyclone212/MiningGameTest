package game.managers;

import game.skills.MiningSkill;

public class MiningManager {
    
    private MiningSkill miningSkill;

    private int actionDelay = 0;

    public MiningManager(MiningSkill miningSkill) {
        this.miningSkill = miningSkill;
    }

    public void mine() {
        System.out.println("MiningManager: Handling mining action for player.");
        // Implement mining logic here
        if(miningSkill.getMiningLevel() >= 1) {
            System.out.println("MiningManager: Player is mining...");
            // Simulate mining action
            this.actionDelay = 3; // e.g., takes 3 ticks to mine
            miningSkill.addXp(50); // Example: add 50 XP for mining
            System.out.println("MiningManager: Mining complete. Gained 50 XP.");
        } else {
            System.out.println("MiningManager: Player's mining level is too low to mine.");
        }
    }

    public int getActionDelay() {
        return actionDelay;
    }

}
