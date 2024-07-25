package com.kodilla.kodilla.good.patterns.Food2Door;

public class ExtraFoodShop implements Producer {

    @Override
        public boolean process(String product, int quantity) {
            System.out.println("Processing order in ExtraFoodShop for " + quantity + " of " + product);
            return true;
        }
    }
