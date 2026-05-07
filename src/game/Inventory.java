package game;

import java.util.HashMap;

public class Inventory {

    private HashMap<Item, Integer> inventory;

    public Inventory() {
        inventory = new HashMap<>();
    }
    
    public void addItem(Item item, int quantity) {
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    public boolean removeItem(Item item, int quantity) {
        if(inventory.containsKey(item)) {
            int currentQuantity = inventory.get(item);
            if(currentQuantity > quantity) {
                inventory.put(item, currentQuantity - quantity);
                return true;
            } else if (currentQuantity == quantity) {
                inventory.remove(item);
                return true;
            } else if (currentQuantity < quantity) {
                // Not enough items to remove
                return false;
            }
        }
        return false; // Item not found in inventory
    }

    public int getItemQuantity(Item item) {
        return inventory.getOrDefault(item, 0);
    }

    public HashMap<Item, Integer> getInventory() {
        return inventory;
    }
}
