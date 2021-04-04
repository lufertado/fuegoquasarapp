package com.fuegoquasar.controller.dto;

public class PositionDTO {
    private double x;
    private double y;

    public PositionDTO() { }

    public PositionDTO(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
