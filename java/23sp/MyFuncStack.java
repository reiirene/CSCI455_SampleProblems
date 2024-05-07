// Hsin Li
// 05/04/2024
// Problem 8 of Spring 2023 Exam
// Description: Stack structure and methods

import java.util.Stack;

public class MyFuncStack {

    public static void main (String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(4);
        s.push(5);
        s.push(0);
        s.push(7);
        s.push(6);
        s.push(1);
        // s = {1 6 7 0 5 4 2}

        myFunc(s);

    }

    public static Stack<Integer> myFunc (Stack<Integer> s) {
        Stack<Integer> tmpStack = new Stack<>();
        Stack<Integer> result = new Stack<>();

        boolean found = false;
        while (!s.empty() && !found) {
            int curr = s.pop();
            if (curr == 0) {
                found = true;
            } else {
                tmpStack.push(curr);
            }
        }
        // found = true;
        // curr = 0;
        // tmpStack = {7 6 1}
        // s = {5 4 2}
        // result = {}

        // A
        System.out.print("s: ");
        printStack(s);
        System.out.print("tmpStack: ");
        printStack(tmpStack);
        while (!tmpStack.empty()) {
            result.push(tmpStack.pop());
        }
        // tmpStack = {}
        // s = {5 4 2}
        // result = {1 6 7}
        
        //B
        System.out.print("tmpStack: ");
        printStack(tmpStack);
        System.out.print("result: ");
        printStack(result);
        while (!s.empty()) {
            result.push(s.pop());
        }
        // tmpStack = {}
        // s = {}
        // result = {2 4 5 1 6 7}

        //C
        System.out.print("s: ");
        printStack(s);
        System.out.print("result: ");
        printStack(result);
        return result;
    }

     // Method to copy a stack
     public static <T> Stack<T> copyStack(Stack<T> originalStack) {
        // Create a new stack to hold the copied elements
        Stack<T> copiedStack = new Stack<>();

        // Iterate over the original stack and push elements onto the copied stack
        for (T element : originalStack) {
            copiedStack.push(element);
        }

        // Return the copied stack
        return copiedStack;
    }

    public static void printStack (Stack<Integer> s) {
        Stack<Integer> tmpS = copyStack(s);
        System.out.print("{ ");
        while (!tmpS.empty()) {
            System.out.print(tmpS.pop() + " ");
        }
        System.out.println("}");
    }
}
