package org.example.javaeight;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FindSecondMax {
    public static void main(String a[]) {
        HashMap<String, Integer> map1 = new HashMap<>();

        map1.put("anil", 1000);
        map1.put("sunil", 1200);
        map1.put("mahesh", 15000);
        map1.put("nitin", 600);
        map1.put("varun", 700);
        map1.put("ramesh", 1200);

        map1.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(1)
                .findFirst().ifPresent(System.out::println);
//
//        map1.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                .skip(1)
//                .findFirst()
//                .filter(entry -> entry.getValue().equals(
//                            map1.entrySet().stream()
//                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                            .skip(1)
//                            .findFirst()
//                            .map(Map.Entry::getValue)
//                            .orElseThrow(() -> new RuntimeException("HAHA"))))

    }
}
