package com.fuegoquasar.controller.mapper;

import com.fuegoquasar.controller.dto.PositionDTO;
import com.fuegoquasar.controller.dto.SatelliteDTO;
import com.fuegoquasar.controller.dto.SatellitesDTO;
import com.fuegoquasar.controller.dto.ShipInfoDTO;
import com.fuegoquasar.domain.Satellite;
import com.fuegoquasar.domain.SatelliteEnum;
import com.fuegoquasar.domain.ShipInfo;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RequestMapper {
    private static final String KENOBI = SatelliteEnum.KENOBI.getName();
    private static final String SKYWALKER = SatelliteEnum.SKYWALKER.getName();
    private static final String SATO = SatelliteEnum.SATO.getName();

    public Map<String, Satellite> mapSatellites(SatellitesDTO satellitesDTO) {
        List<SatelliteDTO> satelliteDTOs = satellitesDTO.getSatellites();
        Map<String, Satellite> satellites = new HashMap<>();

        Optional<SatelliteDTO> kenobi = satelliteDTOs.stream().filter(s -> s.getName().equalsIgnoreCase(KENOBI)).findFirst();
        kenobi.ifPresent(satelliteDTO -> satellites.put(KENOBI, mapSatellite(KENOBI, satelliteDTO)));

        Optional<SatelliteDTO> skywalker = satelliteDTOs.stream().filter(s -> s.getName().equalsIgnoreCase(SKYWALKER)).findFirst();
        skywalker.ifPresent(satelliteDTO -> satellites.put(SKYWALKER, mapSatellite(SKYWALKER, satelliteDTO)));

        Optional<SatelliteDTO> sato = satelliteDTOs.stream().filter(s -> s.getName().equalsIgnoreCase(SATO)).findFirst();
        sato.ifPresent(satelliteDTO -> satellites.put(SATO, mapSatellite(SATO, satelliteDTO)));

        return satellites;
    }

    public Satellite mapSatellite(String satelliteName, SatelliteDTO satelliteDTO) {
        return new Satellite(satelliteName, satelliteDTO.getDistance(), satelliteDTO.getMessage());
    }

    public ShipInfoDTO mapShipInfo(ShipInfo shipInfo) {
        return new ShipInfoDTO(new PositionDTO(shipInfo.getPosition().getX(), shipInfo.getPosition().getY()), shipInfo.getMessage());
    }
}
