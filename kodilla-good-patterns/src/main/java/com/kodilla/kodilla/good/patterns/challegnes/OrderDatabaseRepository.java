package com.kodilla.kodilla.good.patterns.challegnes;

public class OrderDatabaseRepository implements OrderRepository{

    public void createOrder(String user, String product){
        System.out.println(user + " order for " + product + "has been recorded");
    }
}
