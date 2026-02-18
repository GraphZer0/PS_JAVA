package JavaCoreCollectionSecond.BookingManagementSystem;

import JavaCoreCollectionSecond.BookingManagementSystem.exceptions.*;
import JavaCoreCollectionSecond.BookingManagementSystem.model.User;
import JavaCoreCollectionSecond.BookingManagementSystem.model.Workspace;
import JavaCoreCollectionSecond.BookingManagementSystem.service.CoworkingSystem;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        CoworkingSystem system = new CoworkingSystem();

        // 1️⃣ Создаем рабочие места
        Workspace w1 = new Workspace(101, "Стандарт", true);
        Workspace w2 = new Workspace(102, "VIP", true);
        Workspace w3 = new Workspace(103, "Переговорная", true);

        system.addWorkspace(w1);
        system.addWorkspace(w2);
        system.addWorkspace(w3);

        // 2️⃣ Создаем пользователей
        User user1 = new User("Иван", "Петров", UUID.randomUUID(), null);
        User user2 = new User("Анна", "Сидорова", UUID.randomUUID(), null);

        // 3️⃣ Регистрируем пользователей
        system.registerUser(user1);
        system.registerUser(user2);

        try {

            // 4️⃣ Бронируем места
            system.bookWorkspace(user1, w1);
            system.bookWorkspace(user2, w2);

            // 5️⃣ Пробуем забронировать уже занятое место
            system.bookWorkspace(user2, w1);

        } catch (WorkspaceNotAvailableException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (UserNotRegisteredException e) {
            System.out.println("Ошибка регистрации: " + e.getMessage());
        }

        // 6️⃣ Вывод бронирований
        System.out.println("\nТекущие бронирования:");
        system.printAllBookings();

        try {
            // 7️⃣ Отмена брони
            system.cancelWorkspace(user1, w1);
        } catch (UserNotRegisteredException e) {
            System.out.println(e.getMessage());
        }

        // 8️⃣ Проверяем доступность места
        System.out.println("\nПосле отмены брони:");
        System.out.println(w1);

        system.printAllBookings();
    }
}