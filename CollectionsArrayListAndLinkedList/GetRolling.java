package CollectionsArrayListAndLinkedList;

import java.util.ArrayList;
import java.util.List;

public class GetRolling {
    public static List<Double> getRollingAverage(ArrayList<Integer> arr, int k) {
        List<Double> result = new ArrayList<>();

        double windowSum = 0;

        // сумма первого окна
        for (int i = 0; i < k; i++) {
            windowSum += arr.get(i);
        }

        result.add(windowSum / k);

        // sliding window
        for (int i = k; i < arr.size(); i++) {
            windowSum = windowSum - arr.get(i - k) + arr.get(i);
            result.add(windowSum / k);
        }

        return result;
    }
}
