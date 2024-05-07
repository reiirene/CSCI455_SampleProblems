// Hsin Li
// 05/04/2024
// Problem 5 + 6 of Spring 2023 Exam
// Description: Constructor implementation for Iterator class

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ALIterator {
    private ArrayList<Integer> list;
    private int cursor;

    // Constructor
    // creates an iterator over list, cursor positioned before the first element
    public ALIterator (ArrayList<Integer> list) {
        this.list = list;
        cursor = 0;
    }

    // returns true iff the iteration has more elements
    public boolean hasNext () {
        if (cursor < list.size()) {
            return true;
        }
        return false;
    }

    // returns the next element in the list and advances the cursor position
    // throws NoSuchElementException if the iteration has no more elements
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        // the post-increment operator (cursor++). This operator increments the
        // value of cursor by 1, but the value returned by the expression cursor++ 
        // is the original value of cursor before it was incremented.
        return list.get(cursor++);
    }

    public static void printList (ArrayList<Integer> list) {
        ALIterator iter1 = new ALIterator(list);     // create an iter to iterate over list
        while (iter1.hasNext()) {
            System.out.println(iter1.next());
        }
        
    }

    public static void main (String[] args) {
        // Test 1
        // Expected: 1 2 3 4 5
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        printList(list1);

        // Test 2
        // RunTimeException
        ArrayList<Integer> emptyList = new ArrayList<>();
        ALIterator iter2 = new ALIterator(emptyList);
        System.out.println(iter2.next());   // crashes with NoSuchElementException
    }
}
