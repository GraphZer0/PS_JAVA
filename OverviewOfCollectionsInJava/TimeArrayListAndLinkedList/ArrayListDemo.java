package TimeArrayListAndLinkedList;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListDemo {
    public static ArrayList<Integer> createArrayList() {
        ArrayList<Integer> arrayListlist = new ArrayList<>();
        Random random = new Random();

        final int SIZE = 1_000_000;

        for (int i = 0; i < SIZE; i++) {
            arrayListlist.add(random.nextInt());
        }
        return arrayListlist;

    }

    public static long testRandomIndex(ArrayList<Integer> list) {
        Random random = new Random();
        final int ITERATIONS = 1000;

        long startTime = System.nanoTime();

        for (int i = 0; i < ITERATIONS; i++) {
            int randomIndex = random.nextInt(list.size());
            int element = list.get(randomIndex);  // Получаем элемент
        }

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

}
