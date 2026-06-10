package HashMapKeys;

import java.util.HashMap;
import java.util.Map;

public class HashMapKeys {

    public static void main(String[] args) {

        HashMap<Integer, String> oldMap = new HashMap<>();
        oldMap.put(1, "one");
        oldMap.put(2, "two");
        oldMap.put(3, "three");
        oldMap.put(4, "four");
        oldMap.put(5, "five");

        HashMap<String, Integer> newMap = swapValuesAndKeys(oldMap);

        System.out.println("Оригинальный HashMap: " + oldMap);
        System.out.println("HashMap с заменой: " + newMap);
    }

    public static HashMap<String, Integer> swapValuesAndKeys(
            HashMap<Integer, String> map) {

       HashMap<String, Integer> swapMap = new HashMap<>();

       for(Map.Entry<Integer, String> entry : map.entrySet()) {
           swapMap.put(entry.getValue(), entry.getKey());
       }
       return swapMap;
    }
}