// Hsin Li
// 05/04/2024
// Problem 4 of Spring 2023 Exam
// Description: Recursion

import java.util.Arrays;

public class LastNegative {
    public static void main (String[] args) {
        int[] nums;
        int lastNeg = 0;
        
        // Test 1
        // Expected: 1
        nums = new int[]{5, -6, 7};
        lastNeg = posLastNegative(nums);
        System.out.println(lastNeg);
        
        // Test 2
        // Expected: 2
        nums = new int[]{-5, -6, -7};
        lastNeg = posLastNegative(nums);
        System.out.println(lastNeg);

        // Test 3
        // Expected: -1
        nums = new int[]{5, 6, 7};
        lastNeg = posLastNegative(nums);
        System.out.println(lastNeg);

        // Test 4
        // Expected: 0
        nums = new int[]{-5, 6, 7};
        lastNeg = posLastNegative(nums);
        System.out.println(lastNeg);

        // Test 5
        // Expected: -1
        nums = new int[]{};
        lastNeg = posLastNegative(nums);
        System.out.println(lastNeg);
        
    }
    // returns the index of the last negative value in nums.
    // if there are no negative values returns -1
    public static int posLastNegative(int[] nums) {
        return posLastR(nums, 0);    
    }
    // returns the index of the last negative value in the part of nums from
    // position start to the end of the array.
    // if there are no negative values in that part of the array returns -1
    private static int posLastR(int[] nums, int start) {
        // base case
        if (start == nums.length) {     // answer 1
            return -1;  // answer 2
        }
        int lastOfRest = posLastR(nums, start + 1);     // answer 3
        if (lastOfRest != -1) {
            return lastOfRest;
        }
        if (nums[start] < 0) {
            return start;
        }
        return -1;
    }
}
