// Hsin Li
// 05/04/2024
// Problem 5 + 6 of Fall 2017 Exam
// Description: Maps and methods, iterating through maps

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
// import java.util.Iterator;

public class StudentDataMap {
    // main method
    public static void main (String[] arg) {
        /* Problem 5 */
        Map<String, Integer> grades = new HashMap<>();
        grades.put("Sam", 82);
        grades.put("Joe", 88);

        // Part A: update Sam's grade to 99
        grades.put("Sam", 99);
        // alternative
        // grades.replace("Sam", 99);

        // Part B: update Joe's name to Zhou
        grades.put("Zhou", grades.remove("Joe"));
        // alternative
        // grades.put("Zhou", grades.get("Joe"));
        // grades.remove("Joe");

        System.out.println(grades);

        // Demonstration of other methods
        // System.out.println(grades.keySet());
        // System.out.println(grades.values());

        /* Problem 6 */
        Map<String, Integer> map = new HashMap<>();
        map.put("Yan", 25);
        map.put("Song", 34);
        map.put("Andy", 25);
        map.put("Lin", 92);
        map.put("Arati", 86);

        // getKeysWithValue(25, map) would return [Yan, Andy]
        System.out.println(getKeysWithValue(25, map));

        // getKeysWithValue(92, map) would return [Lin] 
        System.out.println(getKeysWithValue(92, map));

        // getKeysWithValue(100, map) would return []
        System.out.println(getKeysWithValue(100, map));
        
    }

    public static ArrayList<String> getKeysWithValue (int val, Map<String, Integer> map) {
        ArrayList<String> keys = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value == val) {
                keys.add(key);
            }
        }

        // alternative using iterator
        /*
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value == val) {
                keys.add(key);
            }
        }
        */

        return keys;
    }
}
