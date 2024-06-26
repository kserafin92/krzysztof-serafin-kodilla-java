package com.kodilla.kodilla.good.patterns.Food2Door;

public class Food2DoorApp {
    public static void main(String[] args) {

        Producer extraFoodShop = new ExtraFoodShop ();
        OrderService extraFoodOrder = new OrderService(extraFoodShop);
        boolean extraFoodResult = extraFoodOrder.processOrder("Apples", 10);
        System.out.println("ExtraFoodShop order result: " + extraFoodResult);


        Producer healthyShop = new HealthyShop();
        OrderService healthyShopOrder = new OrderService(healthyShop);
        boolean healthyShopResult = healthyShopOrder.processOrder("Bananas", 5);
        System.out.println("HealthyShop order result: " + healthyShopResult);


        Producer glutenFreeShop = new GlutenFreeShop();
        OrderService glutenFreeOrder = new OrderService(glutenFreeShop);
        boolean glutenFreeResult = glutenFreeOrder.processOrder("Bread", 2);
        System.out.println("GlutenFreeShop order result: " + glutenFreeResult);
    }
}