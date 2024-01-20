package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


 public class ShapeCollectorTestSuite {
    private ShapeCollector shapeCollector;
    private Shape square;
    private Shape circle;
    private Shape triangle;

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
        shapeCollector = new ShapeCollector();
        square = new Square(2.0);
        circle = new Circle(3.0);
        triangle = new Triangle(4.0, 5.0);
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @Nested
    @DisplayName("Tests for adding and removing shapes")
    class AddAndRemoveTests {

        @Test
        @DisplayName("Add a shape to the collection")
        void testAddFigure() {
            // Given
            int initialSize = shapeCollector.showFigures().split("\n").length;
            // When
            shapeCollector.addFigure(square);
            // Then
            assertEquals(initialSize , shapeCollector.showFigures().split("\n").length);
        }

        @Test
        @DisplayName("Remove a shape from the collection")
        void testRemoveFigure() {
            // Given
            shapeCollector.addFigure(circle);

            // When
            boolean result = shapeCollector.removeFigure(circle);

            // Then
            assertTrue(result);
            assertEquals(1, shapeCollector.showFigures().split("\n").length);
        }
    }
    @Test
    @DisplayName("Get a shape by index")
    void testGetFigure() {
        // Given
        shapeCollector.addFigure(triangle);

        // When
        Shape retrievedShape = shapeCollector.getFigure(0);

        // Then
        assertEquals(triangle, retrievedShape);
    }



    @Nested
    @DisplayName("Tests for showing shapes")
    class ShowFiguresTests {

        @Test
        @DisplayName("Show all figures in the collection")
        void testShowFigures() {
            // Given
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);
            String expected = square.getShapeName() + ": " + square.getField() + "\n" +
                    circle.getShapeName() + ": " + circle.getField() + "\n" +
                    triangle.getShapeName() + ": " + triangle.getField() + "\n";

            // When
            String actual = shapeCollector.showFigures();

            // Then
            assertEquals(expected, actual);
        }
    }
}
