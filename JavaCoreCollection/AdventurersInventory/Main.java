package JavaCoreCollection.AdventurersInventory;

import JavaCoreCollection.AdventurersInventory.service.InventoryService;
import JavaCoreCollection.AdventurersInventory.ui.Menu;

public class Main {

    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryService();
        Menu menu = new Menu(inventoryService);
        menu.start();
    }
}