package com.fuegoquasar.domain;

public enum SatelliteEnum {
    KENOBI("kenobi"),
    SKYWALKER("skywalker"),
    SATO("sato");

    private final String name;

    SatelliteEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
