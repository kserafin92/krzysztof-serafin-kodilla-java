package com.kodilla.exception.test;

class RouteNotFoundException extends Exception {
    public RouteNotFoundException(final String message) {
        super(message);
    }
}