package MainArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ImplementationViaHashSet {
    public static void removeDuplicates(ArrayList<String> list) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            String value = list.get(i);
            if (!seen.add(value)) {
                list.remove(i);
                i--; // сдвиг индекса после удаления
            }
        }
    }
}
