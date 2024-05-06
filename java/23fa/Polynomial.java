// Hsin Li
// 05/04/2024
// Problem 4 of Fall 2023 Exam
// Description: Treemap methods and implementation

import java.util.Collections;
import java.util.TreeMap;
import java.util.Map;
import java.util.Iterator;

public class Polynomial { 
    private TreeMap<Integer, Integer> polyMap; 
    
    // representation invariant:  

    // maps exponents to their coefficients. 
    // maintains the terms in decreasing order by their exponent. 
    // only stores terms with non-zero coefficients. 
    // all exponents are non-negative. 
    // thus, the '0' polynomial is represented as an empty polyMap

    // creates the 0 polynomial
    public Polynomial() { 
        // creates an empty TreeMap. 
        // the parameter below tells it we want decreasing order for keys 
        polyMap = new TreeMap<Integer, Integer>(Collections.reverseOrder()); 
    }
    
    // adds polynomial b to this polynomial 
    public void addIn(Polynomial b) {
        // e.g. 3x^5 -> {key: 5, value: 3}
        for (Map.Entry<Integer, Integer> entry : b.polyMap.entrySet()) {
            polyMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        // remove entry with value of 0
        Iterator<Map.Entry<Integer, Integer>> iter = polyMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> entry = iter.next();
            if (entry.getValue() == 0) {
                iter.remove();
            }
        }

        // cannot remove while trying to iterate with for loop
        // The code below throws
        // Exception in thread "main" java.util.ConcurrentModificationException
        /*
        for (Map.Entry<Integer, Integer> entry : polyMap.entrySet()) {
            if(entry.getValue() == 0) {
                polyMap.remove(entry.getKey());
            }
        }
        */
    }

    @Override
    public String toString() {
        return polyMap.toString();
    }

    // main method
    public static void main (String[] args) {
        Polynomial polyA = new Polynomial();
        Polynomial polyB = new Polynomial();

        // Test 1
        // x^3 + -2x + 7
        polyA.polyMap.put(3, 1);
        polyA.polyMap.put(1, -2);
        polyA.polyMap.put(0, 7);
        // 3x^5 + 4x^2
        polyB.polyMap.put(5, 3);
        polyB.polyMap.put(2, 4);

        polyA.addIn(polyB);
        System.out.println(polyA);
        polyA.polyMap.clear();
        polyB.polyMap.clear();

        // Test 2
        // x^3 + -2x + 7
        polyA.polyMap.put(3, 1);
        polyA.polyMap.put(1, -2);
        polyA.polyMap.put(0, 7);
        // 5x^3 + 5x + 5
        polyB.polyMap.put(3, 5);
        polyB.polyMap.put(1, 5);
        polyB.polyMap.put(0, 5);

        polyA.addIn(polyB);
        System.out.println(polyA);
        polyA.polyMap.clear();
        polyB.polyMap.clear();

        // Test 3
        // x^3 + -2x + 7
        polyA.polyMap.put(3, 1);
        polyA.polyMap.put(1, -2);
        polyA.polyMap.put(0, 7);
        // 3x^5 + 2x
        polyB.polyMap.put(5, 3);
        polyB.polyMap.put(1, 2);

        polyA.addIn(polyB);
        System.out.println(polyA);
        polyA.polyMap.clear();
        polyB.polyMap.clear();

        // Test 4
        // -2x
        polyA.polyMap.put(1, -2);
        // 2x
        polyB.polyMap.put(1, 2);

        polyA.addIn(polyB);
        System.out.println(polyA);
        polyA.polyMap.clear();
        polyB.polyMap.clear();
    }
}
