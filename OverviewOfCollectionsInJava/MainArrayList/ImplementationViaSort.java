package MainArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class ImplementationViaSort {
    public static void removeDuplicates(ArrayList<String> list) {
        Collections.sort(list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
                i--;
            }
        }
    }
}
