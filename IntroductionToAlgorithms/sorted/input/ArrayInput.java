package IntroductionToAlgorithms.sorted.input;

import java.util.Scanner;

public class ArrayInput {

    private final Scanner scanner = new Scanner(System.in);

    public int inputSize() {
        System.out.print("Введите размер массива: ");
        return scanner.nextInt();
    }
}