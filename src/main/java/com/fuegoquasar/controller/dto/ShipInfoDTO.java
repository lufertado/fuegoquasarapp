package com.fuegoquasar.controller.dto;

public class ShipInfoDTO {
    private PositionDTO position;
    private String message;

    public ShipInfoDTO() {}

    public ShipInfoDTO(PositionDTO position, String message) {
        this.position = position;
        this.message = message;
    }

    public PositionDTO getPosition() {
        return position;
    }

    public void setPosition(PositionDTO position) {
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
