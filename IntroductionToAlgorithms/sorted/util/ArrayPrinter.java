package IntroductionToAlgorithms.sorted.util;

import java.util.Arrays;

public class ArrayPrinter {

    // Вывод массива
    public static void printArray(String title, int[] array) {
        System.out.println(title + ":");
        System.out.println(Arrays.toString(array));
    }

    // Вывод времени
    public static void printTime(String title, long timeNano) {
        System.out.printf("%s: %.3f ms%n", title, timeNano / 1_000_000.0);
    }
}