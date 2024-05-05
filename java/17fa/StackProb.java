// Hsin Li
// 05/04/2024
// Problem 3 of Fall 2017 Exam
// Description: Stack functions: push, pop, peek

import java.util.Stack;

public class StackProb {
    // main method
    public static void main(String[] args) {
        stackProb();
    }

    public static void stackProb() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        for (int i = 2; i <= 4; i++) {
            int val = s.peek();
            s.push(i * 2);
            s.push(val + 1);
            System.out.println(s.pop() + " ");
        }
        System.out.println();   // empty line is printed
        // *
    }
}
