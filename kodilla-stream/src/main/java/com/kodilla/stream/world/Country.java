package com.kodilla.stream.world;

import java.math.BigDecimal;

public
class Country {
    private String name;
    private BigDecimal population;

    public Country(String name, BigDecimal population) {
        this.name = name;
        this.population = population;
    }

    public BigDecimal getPeopleQuantity() {
        return population;
    }
}
