// Hsin Li
// 05/04/2024
// Problem 2 of Fall 2017 Exam
// Description: Runtime difference between printing ArrayList and LinkedList

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PrintList {
    // main method
    public static void main(String[] args) {
        /* ArrayList */
        ArrayList<Integer> anArrayList = new ArrayList<>();
        /* LinkedList */
        LinkedList<Integer> aLinkedList = new LinkedList<>();

        // populate ArrayList and LinkedList
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a list of integers separated with spaces: ");
        populateList(anArrayList, in);

        System.out.println("Enter a list of integers separates with spaces: ");
        populateList(aLinkedList, in);

        // function call
        printList1(anArrayList); // A:
        printList2(anArrayList); // B:
        printList1(aLinkedList); // C:
        printList2(aLinkedList); // D:

        in.close();
    }

    /* methods */
    public static void printList1(List<Integer> list) {
        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
    }

    public static void printList2(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
        System.out.println();
    }

    // populate list
    public static void populateList(List<Integer> list, Scanner scanner) {
        String line = scanner.nextLine();
        Scanner lineScanner = new Scanner(line);
        while (lineScanner.hasNextInt()) {
            list.add(lineScanner.nextInt());
        }
        lineScanner.close();
    }
}

/* Java Scanner methods*/
// nextBoolean()
// nextByte()
// nextDouble()
// nextFloat()
// nextInt()
// nextLine()
// nextLong()
// nextShort()