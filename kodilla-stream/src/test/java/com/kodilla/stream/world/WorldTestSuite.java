package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    void testGetPeopleQuantity() {
        // Given
        Country country1 = new Country("Country1", new BigDecimal("1000000"));
        Country country2 = new Country("Country2", new BigDecimal("1500000"));

        Continent continent1 = new Continent("Continent1");
        continent1.addCountry(country1);

        Continent continent2 = new Continent("Continent2");
        continent2.addCountry(country2);

        World world = new World(Arrays.asList(continent1, continent2));

        // When
        BigDecimal result = world.getPeopleQuantity();

        // Then
        BigDecimal expected = new BigDecimal("2500000");
        assertEquals(expected, result);
    }
}
