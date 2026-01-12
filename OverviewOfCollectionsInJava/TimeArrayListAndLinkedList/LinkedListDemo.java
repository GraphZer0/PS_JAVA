package TimeArrayListAndLinkedList;

import java.util.LinkedList;
import java.util.Random;

public class LinkedListDemo {

    public static LinkedList<Integer> createLinkedLIst() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        final int SIZE = 1_000_000;

        for (int i = 0; i < SIZE; i++) {
            linkedList.add(random.nextInt());
        }

        return linkedList;
    }

    public static long testRandomIndex(LinkedList<Integer> linkedList) {
        Random random = new Random();
        final int ITERATIONS = 1000;

        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            int RandomIndex = random.nextInt(linkedList.size());
            int element = linkedList.get(RandomIndex);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}