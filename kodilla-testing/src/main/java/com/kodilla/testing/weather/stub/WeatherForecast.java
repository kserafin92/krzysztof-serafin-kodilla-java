package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {


            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }
    public double calculateAverageTemperature() {
        Map<String, Double> temperaturesMap = temperatures.getTemperatures();

        if (temperaturesMap.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (Double temperature : temperaturesMap.values()) {
            sum += temperature;
        }
        return sum / temperaturesMap.size();
    }
    public double calculateMedianTemperature() {
        Map<String, Double> temperaturesMap = temperatures.getTemperatures();

        if (temperaturesMap.isEmpty()) {
            return 0.0;
        }

        List<Double> temperatureValues = new ArrayList<>(temperaturesMap.values());
        Collections.sort(temperatureValues);

        int middle = temperatureValues.size() / 2;
        if (temperatureValues.size() % 2 == 0) {
            return (temperatureValues.get(middle - 1) + temperatureValues.get(middle)) / 2.0;
        } else {
            return temperatureValues.get(middle);
        }
    }
}