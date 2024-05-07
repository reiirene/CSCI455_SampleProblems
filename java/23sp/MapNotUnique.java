// Hsin Li
// 05/04/2024
// Problem 7 of Spring 2023 Exam
// Description: Map structure and methods

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class MapNotUnique {

    // main method
    public static void main (String[] args) {
        String[] words = new String[]{"a", "a",  "the", "dog", "a", "cat", "a", "the"};
        System.out.println(notUnique(words));
    }
    // takes an array of words and returns a Map<String, Boolean>, such that 
    // all the keys in the map are the words from the array
    // the value for a word is true if the word appeared more than once in the original array, and false otherwise.
    public static Map<String, Boolean> notUnique(String[] words) {
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Boolean status = map.get(words[i]);
            // if a key does not exist, map.get(key) == null
            if (status == null) {
                map.put(words[i], false);
            } else if (status == false) {
                map.put(words[i], true);
            }
        }
        return map;
    }
}