package CollectionsArrayListAndLinkedList;

import java.util.ArrayList;
import java.util.List;

import static CollectionsArrayListAndLinkedList.GetRolling.getRollingAverage;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(5);

        int k = 2;

        List<Double> result = getRollingAverage(arr, k);

        System.out.println(result);
    }
}
