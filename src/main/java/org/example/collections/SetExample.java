package org.example.collections;

import java.util.*;


public class SetExample {
    public static void main(String[] ar) {
        Set<String> hashSet = new HashSet<>();
        Set<String> treeSet = new TreeSet<>();


        for (int i = 0; i < 15; i++) {
            String randomString = getRandomString();
            hashSet.add(randomString);
            treeSet.add(randomString);
        }

        System.out.print("HashSet\n" + hashSet);
        System.out.print("\nTreeSet\n" + treeSet);



    }

    private static String getRandomString() {
        Random random = new Random();
        int leftLimit = 65; // letter 'A'
        int rightLimit = 70; // letter 'F'
        long nameStringLength = 2;
        return random.ints(leftLimit, rightLimit + 1)
                .limit(nameStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
