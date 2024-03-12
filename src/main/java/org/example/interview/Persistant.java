package org.example.interview;

import java.util.Arrays;
import java.util.List;

public class Persistant {
    public static void main(String[] a) {
        // Sort String list according to it's length
        List<String> arr = Arrays.asList("a", "aaaa", "aa", "aaa");
        arr.stream().sorted((x,y) -> Integer.compare(x.length(), y.length())).forEach(System.out::println);

    }
}
