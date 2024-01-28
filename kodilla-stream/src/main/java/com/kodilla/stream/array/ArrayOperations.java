package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {


        double average = IntStream.range(0, numbers.length)
                .mapToDouble(i -> numbers[i])
                .average()
                .orElse(0.0);
        return average;
    }
}