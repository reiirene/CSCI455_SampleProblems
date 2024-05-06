// Hsin Li
// 05/04/2024
// Problem 5 of Fall 2023 Exam
// Description: Exceptions and throwing errors

// input data is in excprob

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcProb {
    public static void main(String[] args) {
        try {
            // Initialize ArrayLists
            // 1.
            // ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
            // 2.
            // ArrayList<Integer> list2 = new ArrayList<>();
            // list2.add(1);
            //list2.add(2);
            // list2.add(3);
            ArrayList<Integer> nums = readFile();
            int total = 0;
            int sum = 0;
            for (int i = 0; i < nums.size(); i++) {
                sum += nums.get(i);
                total++;
            }
            if (total == 0) {
                sum = 28;
                total = 2;
            }
            System.out.println("Average is " + sum / ((double) total));
        } catch (MyException exc) {
            System.out.println("Error " + exc.getMessage());
        } catch (IOException exc) {
            System.out.println("Error D");
        }
    }

    private static ArrayList<Integer> readFile() throws IOException {
        ArrayList<Integer> nums = new ArrayList<>();
        try (Scanner inFile = new Scanner(new File("data"))) {
            if (!inFile.hasNext()) {
                throw new MyException("A");
            }
            while (inFile.hasNext()) {
                if (!inFile.hasNextInt()) {

                    throw new MyException("B");
                }
                nums.add(inFile.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error C");
        }
        return nums;
    }
}

class MyException extends IOException {
    public MyException(){};
    public MyException(String message) {
        super(message);
    }
}
// note: given message can be retrieved with inherited method getMessage()
// public MyException(String message) { super(message); }