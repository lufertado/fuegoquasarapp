package com.fuegoquasar.controller.dto;

import java.util.List;

public class SatellitesDTO {
    private List<SatelliteDTO> satellites;

    public SatellitesDTO(){}

    public SatellitesDTO(List<SatelliteDTO> satellites) {
        this.satellites = satellites;
    }

    public List<SatelliteDTO> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<SatelliteDTO> satellites) {
        this.satellites = satellites;
    }
}
