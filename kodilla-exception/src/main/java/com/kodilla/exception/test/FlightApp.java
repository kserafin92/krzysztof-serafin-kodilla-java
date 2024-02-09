package com.kodilla.exception.test;

public class FlightApp {
    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();

        try {
            // Przykładowe loty
            Flight flight1 = new Flight("AAA", "BBB");
            Flight flight2 = new Flight("BBB", "CCC");
            Flight flight3 = new Flight("ABC", "XYZ");


            flightSearch.findFlight(flight1);
            flightSearch.findFlight(flight2);
            flightSearch.findFlight(flight3); // To rzuci wyjątek RouteNotFoundException
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
