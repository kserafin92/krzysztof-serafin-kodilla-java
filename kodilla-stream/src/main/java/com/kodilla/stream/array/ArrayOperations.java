package com.kodilla.stream.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        System.out.println("Kolejne elementy tablicy:");
        IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                .peek(element -> System.out.print(element))
                .count();

        System.out.println("Kolejne elementy tablicy:");
        Arrays.stream(numbers)
                .forEach(element -> System.out.print(element + " "));

        double average = IntStream.range(0, numbers.length)
                .mapToDouble(i -> numbers[i])
                .average()
                .orElse(0.0);
        return average;
    }
}