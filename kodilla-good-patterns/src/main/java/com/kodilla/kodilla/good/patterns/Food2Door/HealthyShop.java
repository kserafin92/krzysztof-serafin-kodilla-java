package com.kodilla.kodilla.good.patterns.Food2Door;

public class HealthyShop implements Producer {
    @Override
        public boolean process(String product, int quantity) {
            System.out.println("Processing order in HealthyShop for " + quantity + " of " + product);
            return Math.random() > 0.5;
        }
    }

