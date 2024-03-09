package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.BuyPredictor;

public non-sealed class ConservativePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Conservative predictor] Buy debentures of XYZ";
    }
}