package game.managers;

import game.Inventory;
import game.skills.MiningSkill;
import game.world.OreNode;
import game.world.OreType;

public class MiningManager {
    
    private MiningSkill miningSkill;
    private OreNode[] oreNodes;
    private Inventory inventory;

    public MiningManager(MiningSkill miningSkill, Inventory inventory) {
        this.miningSkill = miningSkill;
        this.inventory = inventory;
        populateOreNodes();
    }

    public String attemptMine(OreNode node) {

        if(!node.isDepleted()){
            if(node.canBeMined(miningSkill.getSkillLevel())) {
                
                if(Math.random() < .70){ //70% base success rate (will make more dynamic later using player level and ore level)
                    node.mine();
                    inventory.addItem(node.getOreType(), 1);
                    miningSkill.gainExp(node.getOreType().getExp());
                    return "You successfully mined the " + node.getOreType().getName() + " ore!";
                } else {
                    return "You failed to mine the ore.";
                }
                
            } else {
                // Inform the player that their mining level is too low
                    return "Your mining level is too low to mine this ore. Required level: " + node.getOreType().getReqLevel();
                }
        } else {
            return node.depletedMessage();
        }
    }

    private void populateOreNodes() {
        // This method will create ore nodes and add them to the oreNodes array
        // For simplicity, we'll just create a few ore nodes with hardcoded values
        oreNodes = new OreNode[] {
            new OreNode(OreType.ROCK, 50, 100, 50, 50),
            new OreNode(OreType.ROCK, 50, 150, 50, 50),
            new OreNode(OreType.ROCK, 50, 50, 50, 50),
            new OreNode(OreType.ROCK, 100, 50, 50, 50),
            new OreNode(OreType.COPPER_ORE, 150, 100, 50, 50),
            new OreNode(OreType.IRON_ORE, 250, 100, 50, 50),
            new OreNode(OreType.GOLD_ORE, 350, 100, 50, 50)
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
