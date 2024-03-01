package org.example.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cognizant {
        public static void main(String[] a) {
            //        Remove Duplicates from two list
            List<Integer> list1 = Arrays.asList(1,2,3,4,5,5,4);
            List<Integer> list2 = Arrays.asList(5,2,8,3,7);

            Set<Integer> l1 = list1.stream().collect(Collectors.toSet());
            //        l1.addAll(list2.stream().collect(Collectors.toSet()));

            l1.addAll(list2);
            l1.forEach(System.out::print);
        }
}
