// Hsin Li
// 05/04/2024
// Problem 7 of Fall 2023 Exam
// Description: Interfaces and calling methods

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.ListIterator;

public class UpdateList {
    private static ArrayList<Integer> myList;

    // UnaryOperator only has one method, apply, which takes an argument and returns a result
    // ElmtType apply (ElmtType t)

    public static void main (String[] args) {
        // Part A
        myList = new ArrayList<>(Arrays.asList(4, 3, 2, 1));
        updateAll(myList, x -> x * x);
        System.out.println(myList);

        // Part B
        myList = new ArrayList<>(Arrays.asList(2, 4, 5, 6, 7));
        // if x is even, set it to 0; if x is odd, don't change it
        updateAll(myList, x -> x % 2 == 0 ? 0 : x);
        System.out.println(myList);
    }

    public static void updateAll (List<Integer> list, UnaryOperator<Integer> updateFunction) {
        list.replaceAll(updateFunction);
    }

    // Replaces each element of this list with the result of applying the operator to that 
    // element. Given ArrayList list you may assume the implementation of this method is: 
    void replaceAll (UnaryOperator<Integer> operator)  {
        ListIterator<Integer> li = myList.listIterator(); 
        while (li.hasNext()) {
                li.set(operator.apply(li.next())); 
        }
    }
} // Added missing closing brace

