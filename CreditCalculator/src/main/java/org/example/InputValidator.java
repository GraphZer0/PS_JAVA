package org.example;

import java.util.Scanner;

public class InputValidator {
    public static double validatePositiveDouble(Scanner scanner, String message) {
        double value = 0;
        while (true) {
            System.out.println(message);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value > 0) {
                    break;
                } else  {
                    System.out.println("Значение должно быть больше нуля. Попробуйте снова:");
                }
            }else  {
                System.out.println("Некорректный ввод. Введите числовое значение:");
                scanner.next();
            }
        }
        return value;
    }

    public static int validatePositiveInt(Scanner scanner, String message) {
        int value = 0;
        while (true) {
            System.out.println(message);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0) {
                    break;
                }  else  {
                    System.out.println("Значение должно быть больше нуля. Попробуйте снова: ");
                }
            } else  {
                System.out.println("Некорректный ввод. Введите числовое значение:");
                scanner.next();
            }
        }
        return value;
    }

    public static double validateNonNegativeDouble(Scanner scanner, String promptMessage) {
        double value = 0;
        while (true) {
            System.out.print(promptMessage);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value >= 0) {
                    break;
                } else {
                    System.out.println("Значение не может быть отрицательным. Попробуйте снова:");
                }
            } else {
                System.out.println("Некорректный ввод. Введите числовое значение:");
                scanner.next();
            }
        }
        return value;
    }
}
