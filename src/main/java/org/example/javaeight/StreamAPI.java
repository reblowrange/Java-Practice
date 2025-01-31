package org.example.javaeight;

import org.example.javaeight.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] a) {

        List<Employee> employees = EmployeeStreamOperations.getEmployees();
        employees.stream().map(x->x.getName()).forEach(System.out::println);
    }

    public static void doPartitioning(){

        Stream<String> names = Stream.of("Alan", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, Set<String>> map =
                names.collect(
                        Collectors.partitioningBy(
                                s -> s.length() > 4,// predicate
                                Collectors.toSet()    )
                );
        System.out.println(map);// {false=[Mike, Alan], true=[Teresa, Peter]}
    }

    public static void doGroupingBy3(){

        Stream<String> names = Stream.of("Martin", "Peter", "Joe", "Tom", "Tom", "Ann", "Alan");
        Map<Integer, List<String>> map =
                names.collect(
                        Collectors.groupingBy(
                                String::length,
                                TreeMap::new,       // map type Supplier
                                Collectors.toList())// downstream collector
                );
        System.out.println(map);// {3=[Joe, Tom, Tom, Ann], 4=[Alan], 5=[Peter], 6=[Martin]}
        System.out.println(map.getClass());// class java.util.TreeMap

    }
    public static void doGroupingBy2(){

        Stream<String> names = Stream.of("Martin", "Peter", "Joe", "Tom", "Tom", "Ann", "Alan");
        Map<Integer, Set<String>> map =
                names.collect(
                        Collectors.groupingBy(
                                String::length,     // key Function
                                Collectors.toSet()) // what to do with the values
                );
        System.out.println(map);// {3=[Ann, Joe, Tom], 4=[Alan], 5=[Peter], 6=[Martin]}
    }

    public static void doSorting1() {
        Stream.of("Martin", "Peter", "Joe", "Tom", "Tom", "Ann", "Alan")
                .peek(s->System.out.println("1. " + s))
                .filter(x-> x.length()==3)
                .peek(s->System.out.println("2. " + s))
                .sorted((x,y) -> Integer.compare(x.length(),y.length()))
                .forEach(System.out::println);
    }
}
