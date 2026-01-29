package HomeWorkBasic;

import java.util.Scanner;

public class Main {

    public static double rectangleArea(int length, int width){
        return length * width;
    }

    public static double celciusToFarengheit(double celcius){
        return ((celcius * 9 / 5) + 32);
    }

    public static String convertMinutesToHours(int totalMinutes) {
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        return hours + " часов " + minutes + " минут";
    }

    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in)){
            System.out.println("=====Калькулятор=====");
            System.out.println("1. Площадь прямоугольника");
            System.out.println("2. Конвертер температуры (°C → °F)");
            System.out.println("3. Конвертер минут в часы / минуты");
            System.out.print("Выберите (1 или 3): ");

            int choice = input.nextInt();

            switch (choice){
                case 1 -> {
                    System.out.print("Введите длину: ");
                    int length = input.nextInt();
                    System.out.print("Введите ширину: ");
                    int width = input.nextInt();
                    System.out.println("Площадь прямоугольника: " + rectangleArea(length, width));
                }
                case 2 -> {
                    System.out.print("Введите температуру в градусах Цельсия: ");
                    double celcius = input.nextInt();
                    double fahrenheit = celciusToFarengheit(celcius);
                    System.out.printf("%.1f°C = %.1f°F%n", celcius, fahrenheit);
                    System.out.println("Отображение Как в задании: " + fahrenheit);
                }
                case 3 -> {
                    System.out.print("Введите количество минут: ");
                    int minutes = input.nextInt();
                    System.out.println("Это равно: " + convertMinutesToHours(minutes));
                }
                default -> System.out.println("Ошибка: выберите 1, 2 или 3!");
            }
        }

    }
}
