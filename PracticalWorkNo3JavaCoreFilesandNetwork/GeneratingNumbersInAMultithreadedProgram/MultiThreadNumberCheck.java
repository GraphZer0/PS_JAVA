package PracticalWorkNo3JavaCoreFilesandNetwork.GeneratingNumbersInAMultithreadedProgram;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadNumberCheck {

    // Генератор случайных чисел
    public static int generateNumber(int min, int max, Random random) {
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) throws InterruptedException {

        final int SIZE = 100_000;
        int[] numbers = new int[SIZE];

        Random random = new Random();

        // Генерация массива чисел
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = generateNumber(10, 9999, random);
        }

        // Atomic счетчики
        AtomicInteger twoDigitCount = new AtomicInteger(0);
        AtomicInteger threeDigitCount = new AtomicInteger(0);
        AtomicInteger fourDigitCount = new AtomicInteger(0);

        // Поток 1: двузначные
        Thread t1 = new Thread(() -> {
            for (int num : numbers) {
                if (num >= 10 && num <= 99) {
                    twoDigitCount.incrementAndGet();
                }
            }
        });

        // Поток 2: трехзначные
        Thread t2 = new Thread(() -> {
            for (int num : numbers) {
                if (num >= 100 && num <= 999) {
                    threeDigitCount.incrementAndGet();
                }
            }
        });

        // Поток 3: четырехзначные
        Thread t3 = new Thread(() -> {
            for (int num : numbers) {
                if (num >= 1000 && num <= 9999) {
                    fourDigitCount.incrementAndGet();
                }
            }
        });

        // Запуск потоков
        t1.start();
        t2.start();
        t3.start();

        // Ожидание завершения всех потоков
        t1.join();
        t2.join();
        t3.join();

        // Результаты
        System.out.println("Двузначных чисел: " + twoDigitCount.get() + " шт.");
        System.out.println("Трехзначных чисел: " + threeDigitCount.get() + " шт.");
        System.out.println("Четырехзначных чисел: " + fourDigitCount.get() + " шт.");
    }
}