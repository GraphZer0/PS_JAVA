package JavaCoreCollection.AdventurersInventory.ui;

import JavaCoreCollection.AdventurersInventory.service.InventoryService;

import java.util.Scanner;

public class Menu {

    private final InventoryService inventoryService;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void start() {
        System.out.println("Добро пожаловать в Инвентарь приключенца!");

        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Выберите действие: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addItem();
                    break;
                case "2":
                    updateItem();
                    break;
                case "3":
                    removeItem();
                    break;
                case "4":
                    findItem();
                    break;
                case "5":
                    showAllItems();
                    break;
                case "6":
                    running = false;
                    System.out.println("Выход из программы. До свидания!");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n1 - Добавить новый предмет");
        System.out.println("2 - Изменить количество предметов");
        System.out.println("3 - Удалить предмет");
        System.out.println("4 - Найти предмет по названию");
        System.out.println("5 - Показать весь инвентарь");
        System.out.println("6 - Выход");
    }

    private void addItem() {
        System.out.print("Введите название предмета: ");
        String name = scanner.nextLine();
        System.out.print("Введите количество: ");
        int quantity = readInt();
        System.out.println(inventoryService.addItem(name, quantity));
    }

    private void updateItem() {
        System.out.print("Введите название предмета: ");
        String name = scanner.nextLine();
        System.out.print("Введите новое количество: ");
        int quantity = readInt();
        System.out.println(inventoryService.updateItem(name, quantity));
    }

    private void removeItem() {
        System.out.print("Введите название предмета для удаления: ");
        String name = scanner.nextLine();
        System.out.println(inventoryService.removeItem(name));
    }

    private void findItem() {
        System.out.print("Введите название предмета: ");
        String name = scanner.nextLine();
        System.out.println(inventoryService.findItem(name));
    }

    private void showAllItems() {
        System.out.println(inventoryService.showAllItems());
    }

    private int readInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                int value = Integer.parseInt(input);
                if (value < 0) {
                    System.out.print("Количество не может быть отрицательным. Попробуйте снова: ");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Некорректное число. Попробуйте снова: ");
            }
        }
    }
}