package game.managers;

import game.skills.MiningSkill;

public class MiningManager {
    
    private MiningSkill miningSkill;

    public MiningManager(MiningSkill miningSkill) {
        this.miningSkill = miningSkill;
    }

    public void mine() {
        System.out.println("MiningManager: Handling mining action for player.");
        // Implement mining logic here
        if(miningSkill.getMiningLevel() >= 1) {
            System.out.println("MiningManager: Player is mining...");
            // Simulate mining action
            miningSkill.addXp(50); // Example: add 50 XP for mining
            System.out.println("MiningManager: Mining complete. Gained 50 XP.");
        } else {
            System.out.println("MiningManager: Player's mining level is too low to mine.");
        }
    }

}
