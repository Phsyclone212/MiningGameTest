package MainPackage;

import java.util.Scanner;

public class CraftingManager {
    private static MiningManager miningManager;

    private static int rocks = 0;
    private static int ironOre = 0;
    private static int gems = 0;
    private static int coal = 0;
    private static int tools = 0;

    private static int xp = 0;
    private static int totalXp = 0;
    private static int craftingLevel = 1;
    private static double levelMod = 1.25;
    private static boolean isCrafting;

    private static int craftRockReq = 1;
    private static int craftIronReq = 5;
    private static int craftSteelReq = 20;

    public CraftingManager(MiningManager miningManager){
        this.miningManager = miningManager;
    }

    static void startCrafting() {
        isCrafting = true;
        Scanner sc = new Scanner(System.in);

        while (isCrafting) {
            System.out.println("Choose an item to craft: ");
            System.out.println("1. Refine Rocks\n2. Smelt Iron\n3. Smelt Steel\n4. Check Inventory\n5. Main Menu");
            int sel = sc.nextInt();
            menuSelection(sel);
        }

    }

    private static void stopCrafting() {
        isCrafting = false;
    }

    public static void menuSelection(int sel) {

        switch(sel) {
            case 1:
                refineRocks();
                break;
            case 2:
                //refineIron();
                break;
            case 3:
                //refineSteel();
                break;
            case 4:
                checkInventory();
                break;
            case 5:
                stopCrafting();
                break;
            default:
                System.out.println("Invalid Selection");
                break;
        }
    }

    private static void refineRocks() {

        if(miningManager.getRocks() >= 5){
            System.out.println("You refine some rocks into tools\n+50xp");
            miningManager.decreaseRocks(5);
            tools += 1;
            xp+=50;
            checkXpThreshold();
        } else {
            System.out.println("Not enough resources.");
        }
    }

    private static void checkInventory() {
        System.out.println("Crafting Level: "+craftingLevel+"\nXP: "+xp+"\nTotalXP: "+totalXp);
        System.out.println("Tools: "+tools);
    }

    private static void checkXpThreshold() {
        int xpThreshold = (int) (craftingLevel * levelMod * 100);
        if (xp >= xpThreshold) {
            craftingLevel++;
            System.out.println("You've leveled up!\nYour crafting level is now "+craftingLevel);

            totalXp += xp;
            xp = 0;

            xpThreshold = (int) (craftingLevel * levelMod * 100);
        }
    }
}
