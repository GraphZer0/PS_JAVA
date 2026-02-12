package BasicСoncepts.CofeeHouse;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {

    private List<MenuItem> menu = new ArrayList<>();

    public void add(MenuItem item){
        menu.add(item);
        System.out.println("CoffeeShop has been added");
    }

    // показать меню
    public void showMenu(){
        for (int i = 0; i < menu.size(); i++){
            MenuItem item = menu.get(i);
            System.out.println(i + ". " + item.getName() + ": " + item.getPrice());
        }
    }

    // Заказ одного или нескольких товаров одним вызовом
    public void orderItems(int... indices){
        Order order = new Order();

        for (int index : indices){
            if (index < 0 || index >= menu.size()){
                System.out.println("Неверный номер товара: " + index);
                continue;
            }
            MenuItem item = menu.get(index);
            order.addItem(item);
        }
        order.processOrder();
    }

    // Вложенный класс для представления заказа клиента
    public static class Order {
        private final List<MenuItem> orderedItems = new ArrayList<>();
        private double totalPrice = 0.0;

        public void addItem(MenuItem item) {
            orderedItems.add(item);
            totalPrice += item.getPrice();
        }

        public void processOrder() {
            if (orderedItems.isEmpty()) {
                System.out.println("Заказ пустой — ничего не выбрано.");
                return;
            }

            System.out.println("Обработка заказа:");
            for (MenuItem item : orderedItems) {
                System.out.println("Вы заказали " + item.getName());

                if (item instanceof Preparable preparable) {
                    preparable.prepare();
                }

                System.out.println("Стоимость: " + item.getPrice());
                System.out.println(); // пустая строка для читаемости
            }

            System.out.println("Общая стоимость заказа: " + totalPrice);

            // <<< ВАЖНО: добавляем запись в статистику здесь >>>
            CoffeeShopStats.recordOrder(orderedItems, totalPrice);
        }
    }

    public static class CoffeeShopStats {
        private static int totalOrders = 0;
        private static double totalRevenue = 0.0;
        private static int coffeesSold = 0;
        private static int teasSold = 0;
        private static int pastriesSold = 0;

        // Записываем данные о выполненном заказе
        public static void recordOrder(List<MenuItem> items, double orderTotal) {
            totalOrders++;
            totalRevenue += orderTotal;

            for (MenuItem item : items) {
                if (item instanceof Coffee) {
                    coffeesSold++;
                } else if (item instanceof Tea) {
                    teasSold++;
                } else if (item instanceof Pastry) {
                    pastriesSold++;
                }
            }
        }

        // Вывод статистики
        public static void printStatistics() {
            System.out.println("\n=== Статистика продаж CoffeeShop ===");
            System.out.println("Всего выполнено заказов: " + totalOrders);
            System.out.println("Общая выручка: " + totalRevenue);
            System.out.println("Проданно кофе: " + coffeesSold);
            System.out.println("Проданно чая: " + teasSold);
            System.out.println("Проданно выпечки: " + pastriesSold);
            System.out.println("=====================================\n");
        }
    }
}