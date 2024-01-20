package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }
    @DisplayName("Test for empty list")
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        // Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> emptyList = Collections.emptyList();

        // When
        List<Integer> result = exterminator.exterminate(emptyList);

        // Then
        Assertions.assertTrue(result.isEmpty());
    }
    @DisplayName("Test for normal list with both even and odd numbers")
    @Test
    public void testOddNumbersExterminatorNormalList() {
        // Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> normalList = Arrays.asList(1, 2, 3, 4, 5, 6);

        // When
        List<Integer> result = exterminator.exterminate(normalList);

        // Then
        List<Integer> expectedList = Arrays.asList(2, 4, 6);
        Assertions.assertEquals(expectedList, result);
    }
}
