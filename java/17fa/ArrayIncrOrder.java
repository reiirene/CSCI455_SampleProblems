// Hsin Li
// 05/04/2024
// Problem 1 of Fall 2017 Exam
// Description: Fixing the isIncrOrder method


public class ArrayIncrOrder {
    // main method
    public static void main(String[] args) {
        // Test 1: array in increasing order
        int[] vals1 = {1, 2, 3, 4, 5};
        System.out.println(isIncrOrder(vals1));  // true
        System.out.println();  // empty line

        // Test 2: array not in increasing order
        int[] vals2 = {1, 2, 3, 5, 4};
        System.out.println(isIncrOrder(vals2));  // false
        System.out.println();  // empty line

        // Test 3: array in increasing order with duplicates
        int[] vals3 = {1, 2, 2, 3, 4, 5};
        System.out.println(isIncrOrder(vals3));  // true
        System.out.println();  // empty line

        // Test 4: empty array
        int[] vals4 = {};
        System.out.println(isIncrOrder(vals4));  // true
        System.out.println();  // empty line

        // Test 5: array with one element
        int[] vals5 = {1};
        System.out.println(isIncrOrder(vals5));  // true
        System.out.println();  // empty line
    }   

    // returns true iff the values in vals are in increasing order. 
    // Array may have duplicate values, e.g., [1, 3, 3, 5] is in increasing 
    // order.  [3] and [] are in also in increasing order
    /* Corrected Code */
    public static boolean isIncrOrder(int[] vals) {
        // Correction:
        if (vals.length == 0 || vals.length == 1) {
            return true;
        }
        for (int i = 0; i < vals.length - 1; i++) {
            if (vals[i] > vals[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /* Original Code */
    /*
    public static boolean isIncrOrder(int[] vals) {
        // Correction:
        if (vals.length == 0 || vals.length == 1) {
            return true;
        }
        for (int i = 0; i < vals.length - 1; i++) {
            if (vals[i] > vals[i + 1]) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
    */
}
