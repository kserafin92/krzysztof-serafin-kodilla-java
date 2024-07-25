package com.kodilla.kodilla.good.patterns.flight;

public class FlightServiceApp {
    public static void main(String[] args) {
        FlightService flightService = new FlightService();

        flightService.addFlight(new Flight("Gdańsk", "Wrocław"));
        flightService.addFlight(new Flight("Gdańsk", "Kraków"));
        flightService.addFlight(new Flight("Kraków", "Wrocław"));
        flightService.addFlight(new Flight("Gdańsk", "Warszawa"));
        flightService.addFlight(new Flight("Warszawa", "Wrocław"));

        System.out.println("Flights from Gdańsk:");
        flightService.getFlightsFrom("Gdańsk").forEach(System.out::println);

        System.out.println("\nFlights to Wrocław:");
        flightService.getFlightsTo("Wrocław").forEach(System.out::println);

        System.out.println("\nFlights from Gdańsk through Kraków to Wrocław:");
        flightService.getFlightsThrough("Gdańsk", "Kraków", "Wrocław").forEach(System.out::println);
    }
}