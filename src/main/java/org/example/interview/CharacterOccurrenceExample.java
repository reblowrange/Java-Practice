package org.example.interview;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterOccurrenceExample {
    public static void main(String[] args) {
        String inputString = "ILoveJavaLanguage";

        Map<Character, Long> charOccurrenceMap = inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Character occurrence in the string:");
        charOccurrenceMap.forEach((character, occurrence) ->
                System.out.println("'" + character + "': " + occurrence));
    }
}
