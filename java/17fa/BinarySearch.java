// Hsin Li
// 05/04/2024
// Problem 4 of Fall 2017 Exam
// Description: Bianry Search of an sorted array

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        
        // String Binary Search
        List<String> list = new ArrayList<>();
        list.add("Flynn");
        list.add("Gus");
        list.add("Hank");
        list.add("Jesse");
        list.add("Marie");
        list.add("Mike");
        list.add("Saul");
        list.add("Skyler");
        list.add("Walter");
        bs.strBinarySearch(list, "Mike");
        bs.strBinarySearch(list, "Lydia");
        bs.strBinarySearch(list, "Walter");

        // Integer Binary Search
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        bs.intBinarySearch(arr, 5);
    }

    // String Binary Search
    public void strBinarySearch(List<String> list, String x) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("mid: " + mid);  // debug: print mid
            if (x.equals(list.get(mid))) {
                System.out.println(x + " found at index " + mid);
                break;
            } else if (x.compareTo(list.get(mid)) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left > right) {
            System.out.println(x + " not found");
        }
    }

    // Integer Binary Search
    public void intBinarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (x == arr[mid]) {
                System.out.println("Number " + x + " found at index " + mid);
                break;
            } else if (x < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left > right) {
            System.out.println("Number " + x + " not found");
        }
    }
}
