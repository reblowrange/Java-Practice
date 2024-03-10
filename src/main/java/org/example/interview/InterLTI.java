package org.example.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterLTI {
    public static void main(String[] a) {
        List<String> names = Arrays.asList("swapnil", "poonam");

        Map<String, Long> collect = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.keySet().stream().forEach(x->System.out.println(collect.get(x)));
//        System.out.println(collect);

//        tryWith
        List<Integer> nums = Arrays.asList(4,1,7,9,3);
        nums.stream().max((x,y)->Integer.compare(x,y)).ifPresent(System.out::println);


    }


}
