package MainPackage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MiningManager miningmanager = new MiningManager(0, 0, 0, 0, 0, 0, 1, 1.25, false);
        CraftingManager craftingManager = new CraftingManager(miningmanager);

        boolean isRunning = true;

        while(isRunning) {
            System.out.println("Main Menu:\n1. Mining\n2. Crafting\n3. Quit");
            int sel = sc.nextInt();

            switch (sel) {
                case 1:
                    miningmanager.startMining();
                    break;
                case 2:
                    craftingManager.startCrafting();
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
    }
}