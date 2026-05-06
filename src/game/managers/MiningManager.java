package game.managers;

import game.skills.MiningSkill;
import game.world.OreNode;
import game.world.OreType;

public class MiningManager {
    
    private MiningSkill miningSkill;
    private OreNode[] oreNodes;

    public MiningManager(MiningSkill miningSkill) {
        this.miningSkill = miningSkill;
        populateOreNodes();
    }

    public void attemptMine(OreNode node) {

        if(!node.isDepleted()){
            if(node.canBeMined(miningSkill.getSkillLevel())) {
                
                if(Math.random() > .70){
                    node.mine();
                    miningSkill.gainExp(node.getOreType().getExp());
                } else {
                    System.out.println("You failed to mine the ore.");
                }
                
            } else {
                // Inform the player that their mining level is too low
                System.out.println("Your mining level is too low to mine this ore. Required level: " + node.getOreType().getReqLevel());
            }
        } else {
            System.out.println(node.depletedMessage());
        }
    }

    private void populateOreNodes() {
        // This method will create ore nodes and add them to the oreNodes array
        // For simplicity, we'll just create a few ore nodes with hardcoded values
        oreNodes = new OreNode[] {
            new OreNode(OreType.COPPER_ORE, 100, 100, 50, 50),
            new OreNode(OreType.IRON_ORE, 200, 100, 50, 50),
            new OreNode(OreType.GOLD_ORE, 300, 100, 50, 50)
        };
    }

    public void tick() {
        // This method will be called every game tick to update the state of ore nodes
        for(OreNode oreNode : oreNodes) {
            oreNode.tick();
        }
    }

    public OreNode[] getOreNodes() {
        return oreNodes;
    }
}
