package practiceworkNumberTwo;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        Scanner input = new Scanner(System.in);
        int attempts = 0;
        int guess;

        System.out.println("Я загадал число от 1 до 100. Попробуй угадать!");

        do {
            System.out.print("Введите ваше число: ");
            guess = input.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Больше!");
            } else if (guess > secretNumber) {
                System.out.println("Меньше!");
            }

        } while (guess != secretNumber);

        // Финальное сообщение
        System.out.println("Поздравляю! Вы угадали число " + secretNumber + " за " + attempts + " попыток.");

        input.close();
    }
}
