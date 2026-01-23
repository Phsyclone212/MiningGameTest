package MainPackage;

import java.util.Random;
import java.util.Scanner;

public class MiningManager {
    private static Random random = new Random();
    private CraftingManager craftingManager;

    private static int rocks = 0;
    private static int ironOre = 0;
    private static int gems = 0;
    private static int coal = 0;
    private static int xp = 0;
    private static int totalXp = 0;
    private static int miningLevel = 1;
    private static double levelMod = 1.25;
    private static boolean isMining;

    private static int rocksReq = 1;
    private static int ironReq = 10;
    private static int coalReq = 20;

    public MiningManager(int rocks, int ironOre, int gems, int coal, int xp, int totalXp, int miningLevel, double levelMod, boolean isMining) {
        this.rocks = rocks;
        this.ironOre = ironOre;
        this.gems = gems;
        this.coal = coal;
        this.xp = xp;
        this.totalXp = totalXp;
        this.miningLevel = miningLevel;
        this.levelMod = levelMod;
        this.isMining = false;

        craftingManager = new CraftingManager(this);
    }

    static void startMining() {
        isMining = true;
        Scanner sc = new Scanner(System.in);

        while (isMining) {
            System.out.println("Choose a rock to mine: ");
            System.out.println("1. Rocks\n2. Iron\n3. Coal\n4. Check Inventory\n5. Main Menu");
            int sel = sc.nextInt();
            menuSelection(sel);
        }

    }

    private static void stopMining() {
        isMining = false;
    }

    public static void menuSelection(int sel) {

        switch(sel) {
            case 1:
                mineRocks();
                break;
            case 2:
                mineIron();
                break;
            case 3:
                mineCoal();
                break;
            case 4:
                checkInventory();
                break;
            case 5:
                stopMining();
                break;
            default:
                System.out.println("Invalid Selection");
                break;
    }
}


    private static void checkInventory() {
        System.out.println("Mining Level: "+miningLevel+"\nXP: "+xp+"\nTotalXP: "+totalXp);
        System.out.println("Rocks: "+rocks+"\nIron ore: "+ironOre+"\nCoal: "+coal+"\nGemstones: "+gems);
    }

    private static void checkXpThreshold() {
        int xpThreshold = (int) (miningLevel * levelMod * 100);
        if (xp >= xpThreshold) {
            miningLevel++;
            System.out.println("You've leveled up!\nYour mining level is now "+miningLevel);

            totalXp += xp;
            xp = 0;

            xpThreshold = (int) (miningLevel * levelMod * 100);
        }
    }

    private static void mineRocks() {

        if(miningLevel>=rocksReq) {
            System.out.println("You swing at the rocks...");
            if (random.nextInt(100) == 0) {
                System.out.println("You found a gemstone! +50xp");
                gems++;
                xp+=50;
            } else if (random.nextInt(60) == 0) {
                System.out.println("You found a piece of Coal! +40xp");
                coal++;
                xp+=40;
            } else if (random.nextInt(20) == 0) {
                System.out.println("You found a piece of Iron ore! +25xp");
                ironOre++;
                xp+=25;
            }

            //potential bonus rocks after level 5
            if(miningLevel>=5) {
                if (random.nextInt(3) == 0) {
                    System.out.println("You found some extra rocks! +10xp");
                    xp+=10;
                    rocks++;
                }
            }

            System.out.println("and collect some rocks.\n+10xp");
            rocks++;
            xp += 10;
            checkXpThreshold();
        }
    }

    private static void mineIron() {
        if(miningLevel<ironReq){
            System.out.println("You do not have the required level for this rock.(10)");
        } else {
            System.out.println("You swing at the rocks... ");
            if (random.nextInt(80) == 0) {
                System.out.println("You found a gemstone! +50xp");
                gems++;
                xp+=50;
            } else if (random.nextInt(20) == 0) {
                System.out.println("You found a piece of Coal! +40xp");
                coal++;
                xp+=40;
            }
            System.out.println("and mine some Iron ore.\n+25xp");
            ironOre++;
            xp += 25;
            checkXpThreshold();
        }
    }

    private static void mineCoal() {
        if(miningLevel<coalReq){
            System.out.println("You do not have the required level for this rock.(20)");
        } else {
            System.out.println("You swing at the rocks... ");
            if (random.nextInt(600) == 0) {
                System.out.println("You found a gemstone! +50xp");
                gems++;
                xp+=50;
            } else if (random.nextInt(20) == 0) {
                System.out.println("You found an extra piece of Coal! +40xp");
                coal++;
                xp+=40;
            }
            System.out.println("and mine some Coal.\n+40xp");
            coal++;
            xp += 40;
            checkXpThreshold();
        }
    }

    public static int getRocks() {
        return rocks;
    }

    public static int getIronOre() {
        return ironOre;
    }

    public static int getGems() {
        return gems;
    }

    public static int getCoal() {
        return coal;
    }

    public static int decreaseRocks(int amount) {
        rocks -= amount;
        return rocks;
    }
}
