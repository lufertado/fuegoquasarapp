package com.fuegoquasar.service;

import com.fuegoquasar.domain.Satellite;
import com.fuegoquasar.domain.SatelliteEnum;
import com.fuegoquasar.domain.ShipInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShipInfoService {

    private final LocationService locationService;
    private final MessageService messageService;
    private Map<String, Satellite> satellites = new HashMap<>();

    public ShipInfoService(LocationService locationService, MessageService messageService) {
        this.locationService = locationService;
        this.messageService = messageService;
    }

    public ShipInfo getShipInfo(Map<String, Satellite> satellites) {
        Map<String, Double> distances = new HashMap<>();
        for (String name : satellites.keySet()) {
            distances.put(name, satellites.get(name).getDistance());
        }
        List<List<String>> messages = satellites.values().stream().map(Satellite::getMessage).collect(Collectors.toList());
        return new ShipInfo(locationService.getLocation(distances), messageService.getMessage(messages));
    }

    public void putSatellite(Satellite satellite) {
        satellites.put(satellite.getName(), satellite);
    }

    public ShipInfo getShipInfo() {
        if (satellites.containsKey(SatelliteEnum.KENOBI.getName())
                && satellites.containsKey(SatelliteEnum.SKYWALKER.getName())
                && satellites.containsKey(SatelliteEnum.SATO.getName())) {
            return getShipInfo(this.satellites);
        }
        else {
            throw new IllegalArgumentException("There's no enough information (satellites) to calculate ship information");
        }
    }
}
