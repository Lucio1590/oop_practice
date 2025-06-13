package org.lucian.module5.exercise10;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Traditional for-loop approach
        List<Integer> resultFor = new ArrayList<>();
        for (Integer n : numbers) {
            if (n % 2 == 0) {
                resultFor.add(n * 3);
            }
        }
        System.out.println("Result with for-loop: " + resultFor);

        // Stream approach
        List<Integer> resultStream = numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * 3)
            .collect(Collectors.toList());
        System.out.println("Result with Stream:   " + resultStream);
    }
}
