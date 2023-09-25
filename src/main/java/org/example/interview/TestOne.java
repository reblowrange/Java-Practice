package org.example.interview;

import java.util.*;

public class TestOne {
    public static void main(String[] a) {
        int arr[] = {4, 1, 9, 34, 0, 12, 8, 3, 7, 5, 34};

//        List<Integer> list = Arrays.asList(4, 1, 9, 34, 0, 12, 8, 3, 7, 1);
//        System.out.println(list.stream().distinct().count());

        // Find Duplicate element ele.
        // Calculate time complexity
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate Number: " + arr[i]);
                    break;
                }
            }
        }

        // Do it with set
        Set<Integer> store = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!store.add(arr[i])) {
                System.out.println("Duplicate Item::" + arr[i]);
                break;
            }
        }


    }
}
