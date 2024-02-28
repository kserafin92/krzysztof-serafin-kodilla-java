package com.kodilla.good.patterns.challegnes;

import java.util.Scanner;

class ProductOrderService implements OrderService, OrderRepository {
    private final InformationService informationService;
    private final OrderRepository orderRepository;

    public ProductOrderService(InformationService informationService, OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean order(String user, String product) {
        boolean isOrdered = getUserDecision();
        if (isOrdered) {
            informationService.inform(user);
            orderRepository.createOrder(user, product);
        }
        return isOrdered;
    }


    }

    private boolean getUserDecision() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Czy chcesz złożyć zamówienie? (tak/nie): ");
        String decision = scanner.nextLine();
        return decision.equalsIgnoreCase("tak");
    }
}
