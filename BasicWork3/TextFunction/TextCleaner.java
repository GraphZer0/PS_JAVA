package BasicWork3.TextFunction;

import java.util.Scanner;

public class TextCleaner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        String cleaned = text.replaceAll("[^0-9+\\-().,]", "");

        System.out.println("Скоректированный текст: " + cleaned);
    }
}
