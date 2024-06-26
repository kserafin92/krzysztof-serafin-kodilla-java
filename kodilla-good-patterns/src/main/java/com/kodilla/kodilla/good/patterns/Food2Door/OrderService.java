package com.kodilla.kodilla.good.patterns.Food2Door;

public class OrderService {
    private Producer producer;

    public OrderService(Producer producer) {
        this.producer = producer;
    }

    public boolean processOrder(String product, int quantity) {
        return producer.process(product, quantity);
    }
}