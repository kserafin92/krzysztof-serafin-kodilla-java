package com.kodilla.kodilla.good.patterns.Food2Door;

public class GlutenFreeShop implements Producer {
    @Override
    public boolean process(String product, int quantity) {
        System.out.println("Processing order in GlutenFreeShop for " + quantity + " of " + product);
        return true;
    }
}