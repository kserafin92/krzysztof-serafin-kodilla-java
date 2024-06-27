package com.kodilla.kodilla.good.patterns.flight;

import com.kodilla.kodilla.good.patterns.flight.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private final List<Flight> flights;

    public FlightService() {
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getFlightsFrom(String city) {
        return flights.stream()
                .filter(flight -> flight.getDeparture().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Flight> getFlightsTo(String city) {
        return flights.stream()
                .filter(flight -> flight.getArrival().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Flight> getFlightsThrough(String departure, String through, String arrival) {
        List<Flight> departureToThrough = getFlightsFrom(departure).stream()
                .filter(flight -> flight.getArrival().equalsIgnoreCase(through))
                .collect(Collectors.toList());

        List<Flight> throughToArrival = getFlightsFrom(through).stream()
                .filter(flight -> flight.getArrival().equalsIgnoreCase(arrival))
                .collect(Collectors.toList());

        List<Flight> result = new ArrayList<>();
        for (Flight firstLeg : departureToThrough) {
            for (Flight secondLeg : throughToArrival) {
                result.add(new Flight(firstLeg.getDeparture() + " -> " + firstLeg.getArrival(),
                        secondLeg.getDeparture() + " -> " + secondLeg.getArrival()));
            }
        }
        return result;
    }
}
