package JavaCoreCollection.DetectiveGame.UI;

import JavaCoreCollection.DetectiveGame.model.Evidence;
import JavaCoreCollection.DetectiveGame.service.DetectiveService;

import java.util.Scanner;
import java.util.Set;

public class Menu {

    private final DetectiveService service;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(DetectiveService service) {
        this.service = service;
    }

    public void start() {
        System.out.println("Добро пожаловать в Детективную игру!");

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Выберите действие: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addEvidence();
                    break;
                case "2":
                    checkEvidence();
                    break;
                case "3":
                    removeEvidence();
                    break;
                case "4":
                    compareWithDatabase();
                    break;
                case "5":
                    showAllEvidences();
                    break;
                case "6":
                    running = false;
                    System.out.println("Выход из игры. До свидания!");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.\n");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n1 - Добавить улику");
        System.out.println("2 - Проверить наличие улики");
        System.out.println("3 - Удалить улику");
        System.out.println("4 - Сравнить с базой данных");
        System.out.println("5 - Показать все найденные улики");
        System.out.println("6 - Выход");
    }

    private void addEvidence() {
        System.out.print("Введите название новой улики: ");
        String name = scanner.nextLine();
        if (service.addEvidence(name)) {
            System.out.println("Улика \"" + name + "\" добавлена.");
        } else {
            System.out.println("Улика \"" + name + "\" уже существует.");
        }
    }

    private void checkEvidence() {
        System.out.print("Введите название улики для проверки: ");
        String name = scanner.nextLine();
        if (service.hasEvidence(name)) {
            System.out.println("Улика найдена.");
        } else {
            System.out.println("Улика не найдена.");
        }
    }

    private void removeEvidence() {
        System.out.print("Введите название улики для удаления: ");
        String name = scanner.nextLine();
        if (service.removeEvidence(name)) {
            System.out.println("Улика \"" + name + "\" удалена.");
        } else {
            System.out.println("Улика \"" + name + "\" не найдена.");
        }
    }

    private void compareWithDatabase() {
        Set<Evidence> matches = service.getMatchesWithDatabase();
        if (matches.isEmpty()) {
            System.out.println("Совпадений с базой данных нет.");
        } else {
            System.out.println("Совпадения с базой данных:");
            for (Evidence e : matches) {
                System.out.println("- " + e);
            }
        }
    }

    private void showAllEvidences() {
        Set<Evidence> evidences = service.getAllFoundEvidences();
        if (evidences.isEmpty()) {
            System.out.println("Найденные улики отсутствуют.");
        } else {
            System.out.println("Найденные улики:");
            for (Evidence e : evidences) {
                System.out.println("- " + e);
            }
        }
    }
}