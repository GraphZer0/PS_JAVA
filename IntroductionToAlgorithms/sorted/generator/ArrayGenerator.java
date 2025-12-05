package IntroductionToAlgorithms.sorted.generator;

import java.util.Random;

public class ArrayGenerator {

    private final Random random = new Random();

    public int[] generateRandomArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }

        return array;
    }
}