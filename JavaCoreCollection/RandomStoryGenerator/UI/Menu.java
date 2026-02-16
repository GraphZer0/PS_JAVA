package JavaCoreCollection.RandomStoryGenerator.UI;

import JavaCoreCollection.RandomStoryGenerator.model.Story;
import JavaCoreCollection.RandomStoryGenerator.service.StoryService;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final StoryService storyService;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(StoryService storyService) {
        this.storyService = storyService;
    }

    public void start() {
        System.out.println("Добро пожаловать в Генератор случайных историй!");
        printCounts();

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Выберите пункт: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Введите нового персонажа: ");
                    storyService.addCharacter(scanner.nextLine());
                    System.out.println("Персонаж добавлен.\n");
                    printCounts();
                    break;

                case "2":
                    System.out.print("Введите новое действие: ");
                    storyService.addAction(scanner.nextLine());
                    System.out.println("Действие добавлено.\n");
                    printCounts();
                    break;

                case "3":
                    System.out.print("Введите новое место: ");
                    storyService.addPlace(scanner.nextLine());
                    System.out.println("Место добавлено.\n");
                    printCounts();
                    break;

                case "4":
                    Story story = storyService.generateStory();
                    System.out.println("\nСгенерированная история: " + story);
                    System.out.println("Эта история добавлена в список сгенерированных историй.\n");
                    break;

                case "5":
                    List<Story> stories = storyService.getAllStories();
                    if (stories.isEmpty()) {
                        System.out.println("\nИсторий пока нет.\n");
                    } else {
                        System.out.println("\nИстории:");
                        int i = 1;
                        for (Story s : stories) {
                            System.out.println(i + ") " + s);
                            i++;
                        }
                        System.out.println();
                    }
                    break;

                case "6":
                    running = false;
                    System.out.println("\nЗавершение программы. До свидания!");
                    break;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.\n");
            }
        }
    }

    private void printMenu() {
        System.out.println("Выберите пункт:");
        System.out.println("1 - Добавить персонажа");
        System.out.println("2 - Добавить действие");
        System.out.println("3 - Добавить место");
        System.out.println("4 - Сгенерировать историю");
        System.out.println("5 - Посмотреть все истории");
        System.out.println("6 - Выход");
    }

    private void printCounts() {
        System.out.println("У нас есть персонажи (" + storyService.getCharactersCount() + " шт.), " +
                "действия (" + storyService.getActionsCount() + " шт.), " +
                "места (" + storyService.getPlacesCount() + " шт.).\n");
    }
}