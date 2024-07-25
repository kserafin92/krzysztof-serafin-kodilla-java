package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    void testBasicPizzaOrder() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        String description = theOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(15), calculatedCost);
        assertEquals("Pizza with tomato sauce and cheese", description);
    }

    @Test
    void testPizzaWithExtraCheeseAndHam() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        String description = theOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(23), calculatedCost);
        assertEquals("Pizza with tomato sauce and cheese + extra cheese + ham", description);
    }

    @Test
    void testPizzaWithAllDecorators() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        theOrder = new MushroomsDecorator(theOrder);
        theOrder = new OnionDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        String description = theOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(29), calculatedCost);
        assertEquals("Pizza with tomato sauce and cheese + extra cheese + ham + mushrooms + onion", description);
    }
}
