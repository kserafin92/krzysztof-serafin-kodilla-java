package com.kodilla.good.patterns.challegnes;

public class App {
    public static void main(String[] args) {
        InformationService informationService = new EmailInformationService();
        OrderDatabaseRepository orderRepository = new OrderDatabaseRepository();


        OrderService orderService = new ProductOrderService(informationService, new OrderDatabaseRepository());



        String user = "XYZ";
        String product = "ABC";
        boolean isOrdered = orderService.order(user, product);

        OrderDto orderDto = new OrderDto(user, isOrdered);
        System.out.println("Wynik zamówienia: " + orderDto.getUser() + ", Zamówienie zrealizowane: " + orderDto.isOrdered());
    }
}
