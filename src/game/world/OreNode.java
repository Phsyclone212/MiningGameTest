package game.world;

public class OreNode {
    
    private final OreType oreType;
    private int posX;
    private int posY;
    private int width;
    private int height;
    private boolean isDepleted;
    private final int respawnTime; // Time in ticks for the ore node to respawn after being depleted
    private int timeLeftToRespawn; // Time left in ticks for the ore node to respawn

    public OreNode(OreType oreType, int posX, int posY, int width, int height) {
        this.oreType = oreType;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.respawnTime = oreType.getRespawnTime();
        this.isDepleted = false;
        this.timeLeftToRespawn = 0;
    }


    public void mine(){
        // Logic to mine the ore node
        if(!isDepleted) {
            // If mining is successful, set isDepleted to true and start respawn timer
            isDepleted = true;
            timeLeftToRespawn = respawnTime;
        } else {
            // Inform the player that the ore node is depleted
            depletedMessage();
        }
    }

    public boolean canBeMined(int playerMiningLevel) {
        return playerMiningLevel >= oreType.getReqLevel();
    }

    public void tick() {
        if(isDepleted){
            timeLeftToRespawn--;
            if(timeLeftToRespawn <= 0) {
                isDepleted = false;
                timeLeftToRespawn = 0;
            }
        }
    }

    public String depletedMessage() {
        return "This " + oreType.getOreName() + " node is depleted. It will respawn in " + timeLeftToRespawn + " ticks.";
    }

    public OreType getOreType() {
        return oreType;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isDepleted() {
        return isDepleted;
    }

    public int getRespawnTime() {
        return respawnTime;
    }

    public int getTimeLeftToRespawn() {
        return timeLeftToRespawn;
    }

}