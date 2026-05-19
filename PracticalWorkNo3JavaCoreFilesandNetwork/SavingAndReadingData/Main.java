package PracticalWorkNo3JavaCoreFilesandNetwork.SavingAndReadingData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserManager userManager = new UserManager();

        userManager.loadFromFile(); // загрузка при старте

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== User Manager ===");

        while (true) {

            System.out.println("\n1 - Добавить пользователя");

            System.out.println("2 - Отобразить список пользователей");

            System.out.println("0 - Выход");

            System.out.print("Выберите один из пунктов выше : ");

            int choice = scanner.nextInt();

            scanner.nextLine(); // очистка буфера

            if (choice == 1) {

                System.out.print("Введите имя: ");

                String name = scanner.nextLine();

                System.out.print("Введите город : ");

                String city = scanner.nextLine();

                userManager.addUser(new User(name, city));

                System.out.println("Пользователь добавлен ");

            }

            else if (choice == 2) {

                System.out.println("\n--- Users list ---");

                for (User u : userManager.getUsers()) {

                    System.out.println(u);

                }

            }

            else if (choice == 0) {

                System.out.println("Bye!");

                break;

            }

        }

        scanner.close();

    }
}

