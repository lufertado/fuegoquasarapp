package com.fuegoquasar.domain;

import com.fuegoquasar.controller.dto.PositionDTO;

public class ShipInfo {
    private Coordinate position;
    private String message;

    public ShipInfo() {}

    public ShipInfo(Coordinate position, String message) {
        this.position = position;
        this.message = message;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
