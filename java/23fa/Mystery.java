// Hsin Li
// 05/04/2024
// Problem 2 of Fall 2023 Exam
// Description: Commenting methods, understanding implementation

import java.util.Stack;

public class Mystery {
    public static void main(String[] args) {
        String str = "abbaaabb";
        System.out.println(str + " " + mystery(str));

        str = "aaabbb";
        System.out.println(str + " " + mystery(str));

        str = "aaab";
        System.out.println(str + " " + mystery(str));
    }

    // Method that checks if all 'a' comes before all 'b',
    // and if the number of 'a' equals to number of 'b'
    public static boolean mystery(String str) {
        Stack<Character> s = new Stack<>();
        int i = 0;
        while (i < str.length() && str.charAt(i) == 'a') {
            s.push(str.charAt(i));
            //System.out.println(s);
            i++;
        }
        while ((i < str.length() && str.charAt(i) == 'b') && (!s.empty())) {
            s.pop();
            //System.out.println(s);
            i++;
        }

        return (i == str.length() && s.empty());
    }
}
