package BasicСoncepts.CofeeHouse;

import BasicСoncepts.CofeeHouse.CoffeeShop;

public class Main {
    public static void main(String[] args) {

        CoffeeShop shop = new CoffeeShop();

        Coffee coffee = new Coffee("Espresso", 350, 5);
        Tea tea = new Tea("Green Tea", 250, "Green");
        Pastry pastry = new Pastry("Круасан", 810, "без использования сахара/глюкозы");

        shop.add(coffee);
        shop.add(tea);
        shop.add(pastry);

        System.out.println();
        shop.showMenu();
        shop.orderItems(0,2,1);
        CoffeeShop.CoffeeShopStats.printStatistics();
    }
}