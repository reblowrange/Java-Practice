package org.example.interview;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.objects.NativeArray.forEach;

public class Coforge {
    public static void main(String[] a) {

        // Merge and sort two arrays
        int[] l1 = {1, 2, 5, 8};
        int[] l2 = {3, 4, 6, 7};

        int[] out = new int[l1.length + l2.length];

        TreeSet<Integer> collect = Arrays.stream(l1).mapToObj(x -> (int) x).collect(Collectors.toCollection(TreeSet::new));
        collect.addAll(Arrays.stream(l2).mapToObj(x -> (int) x).collect(Collectors.toList()));

        collect.forEach(System.out::println);
        //.stream().sorted((x,y) -> Integer.compare(x,y)).forEach(System.out::println);
    }
}
