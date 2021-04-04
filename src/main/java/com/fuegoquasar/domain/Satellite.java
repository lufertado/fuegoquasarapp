package com.fuegoquasar.domain;

import java.util.List;

public class Satellite {
    private final String name;
    private final double distance;
    private final List<String> message;

    public Satellite(String name, double distance, List<String> message) {
        this.name = name;
        this.distance = distance;
        this.message = message;
    }

    public double getDistance() {
        return distance;
    }

    public List<String> getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }
}
