// Hsin Li
// 05/04/2024
// Problem 3 of Fall 2023 Exam
// Description: Dynamic Programming

import java.util.Arrays;

public class BinSearch {
    // main method
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Grape", "Lemon", "Pear", "Strawberry"};
        System.out.println(binSearch(words, "Banana"));
    }

    // returns the location of target in words array, or -1 if not found. 
    // PRE: words is in alphabetical order and has no duplicates 
    public static int binSearch(String[] words, String target) {
        return binSearchR(words, target, 0, words.length-1); 
    }      
    
    // returns the location of target in the part of words with indices [low,high] 
    // or -1 if not found 
    // PRE: words is in alphabetical order and has no duplicates 
    public static int binSearchR(String[] words, String target, int low, int high) { 
        if (low > high) {
            return -1;  // answer 1
        } 
        int mid = (low + high) / 2;
        if (target.equals(words[mid])) {
            return mid; // answer 2
        }
        else if (target.compareTo(words[mid]) < 0) {    // target < words[mid]
            return binSearchR(words, target, low, mid - 1);    // answer 3
        } else {                                        // target > words[mid]
            return binSearchR(words, target, mid + 1, high);   // answer 4
        }
    }
}
