package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

class FlightSearch {
    private Map<String, Boolean> airportMap;

    public FlightSearch() {
        airportMap = new HashMap<>();
        airportMap.put("AAA", true);
        airportMap.put("BBB", true);
        airportMap.put("CCC", true);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {
        String departureAirport = flight.getDepartureAirport();
        String arrivalAirport = flight.getArrivalAirport();

        if (!airportMap.containsKey(departureAirport) || !airportMap.containsKey(arrivalAirport)) {
            throw new RouteNotFoundException("Route not found");
        }

        boolean isFlightPossible = airportMap.get(departureAirport) && airportMap.get(arrivalAirport);

        if (!isFlightPossible) {
            throw new RouteNotFoundException("Flight not possible for the given airports");
        }

        System.out.println("Flight found from " + departureAirport + " to " + arrivalAirport);
    }
}
