package helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AssertHelper {

    public static List<String> getDifference(Map<String, String> actual, Map<String, String> expected) {
        List<String> difference = new ArrayList<>();
        for (String key : actual.keySet()) {
            if (!expected.containsKey(key)) {
                difference.add(key + " is unexpected in actual values");
            }
            else if (!expected.get(key).equals(actual.get(key))) {
                difference.add(key + " is different. Expected is [" + expected.get(key) + "], but was [" + actual.get(key) + "]");
            }
        }
        return difference;
    }
}
