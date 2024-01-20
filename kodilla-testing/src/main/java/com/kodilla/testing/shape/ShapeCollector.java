package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;


public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }
    public boolean removeFigure(Shape shape) {
        return shapes.remove(shape);
    }
    public Shape getFigure(int n) {
        if (n >= 0 && n < shapes.size()) {
            return shapes.get(n);
        }
        return null;
    }
    public String showFigures() {
        StringBuilder sb = new StringBuilder();
        for (Shape shape : shapes) {
            sb.append(shape.getShapeName()).append(": ").append(shape.getField()).append("\n");
        }
        return sb.toString();
    }
}
