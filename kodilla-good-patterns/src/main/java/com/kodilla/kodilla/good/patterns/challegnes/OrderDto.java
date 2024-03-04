package com.kodilla.kodilla.good.patterns.challegnes;

public class OrderDto {
    private final String user;
    private final boolean ordered;

    public OrderDto(String user, boolean ordered) {
        this.user = user;
        this.ordered = ordered;
    }

    public String getUser() {
        return user;
    }

    public boolean isOrdered() {
        return ordered;
    }
}
