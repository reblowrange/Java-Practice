package org.example;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Java8FunctionalInterface {
    public static void main(String[] a) {
        predicates();
        functions();
    }

    private static void functions() {
        Function<String, Boolean> isValidString = (s) -> s.length() == 7;
        System.out.println(String.format("""
                [Function] String length is %s""", isValidString.apply("Swapnil") ? "Valid" : "Invalid"));

        BiFunction<String, Integer, Boolean> isLenValid = (str, len) -> str.length() == len;
        System.out.println(String.format("""
                [BiFunction] String length is %s""", isLenValid.apply("Swapnil", 9) ? "Valid" : "Invalid"));
    }

    private static void predicates() {
        Predicate<String> testString = (s) -> s.startsWith("AM");
       /* Predicate<String> testString = (s) -> {
            return s.startsWith("AM");
        };*/
        String in = "SWAPP";
        String testStringOutput = String.format("""
                [Predicate] Is '%s' starts with 'AM'?
                - %b
                """, in, testString.test(in));
        System.out.println(testStringOutput);

        BiPredicate<String, Integer> testIsStringLength = (s, l) -> s.length() == l;
        System.out.println(String.format("""
                [BiPredicate] Is String valid length
                - %b
                """, testIsStringLength.test("SWAPNIL", 7)));
    }
}
