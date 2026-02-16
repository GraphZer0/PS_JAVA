package JavaCoreCollection.AdventurersInventory.service;

import JavaCoreCollection.AdventurersInventory.model.Item;

import java.util.LinkedHashMap;
import java.util.Map;

public class InventoryService {

    private final LinkedHashMap<Item, Integer> inventory = new LinkedHashMap<>();

    // Добавление предмета
    public String addItem(String name, int quantity) {
        if (name == null || name.trim().isEmpty() || quantity <= 0) {
            return "Ошибка: название предмета или количество некорректны.";
        }

        Item item = new Item(name);

        if (inventory.containsKey(item)) {
            int current = inventory.get(item);
            inventory.put(item, current + quantity);
            return "Предмет \"" + name + "\" уже существует. Количество увеличено до " + inventory.get(item) + ".";
        } else {
            inventory.put(item, quantity);
            return "Предмет \"" + name + "\" успешно добавлен.";
        }
    }

    // Изменение количества
    public String updateItem(String name, int quantity) {
        if (name == null || name.trim().isEmpty() || quantity < 0) {
            return "Ошибка: название предмета или количество некорректны.";
        }

        Item item = new Item(name);
        if (!inventory.containsKey(item)) {
            return "Предмет \"" + name + "\" не найден.";
        }

        if (quantity == 0) {
            inventory.remove(item);
            return "Количество равно 0. Предмет \"" + name + "\" удален.";
        } else {
            inventory.put(item, quantity);
            return "Количество для \"" + name + "\" обновлено.";
        }
    }

    // Удаление предмета
    public String removeItem(String name) {
        Item item = new Item(name);
        if (inventory.remove(item) != null) {
            return "Предмет \"" + name + "\" успешно удален.";
        } else {
            return "Предмет \"" + name + "\" не найден.";
        }
    }

    // Поиск предмета
    public String findItem(String name) {
        Item item = new Item(name);
        if (inventory.containsKey(item)) {
            return "Количество \"" + name + "\": " + inventory.get(item);
        } else {
            return "Предмет \"" + name + "\" не найден.";
        }
    }

    // Показать весь инвентарь
    public String showAllItems() {
        if (inventory.isEmpty()) {
            return "Инвентарь пуст.";
        }

        StringBuilder sb = new StringBuilder("Текущий инвентарь:\n");
        for (Map.Entry<Item, Integer> entry : inventory.entrySet()) {
            sb.append(entry.getKey()).append(" – ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}