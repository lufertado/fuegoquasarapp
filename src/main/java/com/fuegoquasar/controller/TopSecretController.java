package com.fuegoquasar.controller;

import com.fuegoquasar.controller.dto.SatellitesDTO;
import com.fuegoquasar.controller.dto.ShipInfoDTO;
import com.fuegoquasar.controller.mapper.RequestMapper;
import com.fuegoquasar.domain.Satellite;
import com.fuegoquasar.service.ShipInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/topsecret")
public class TopSecretController {

    private final ShipInfoService shipInfoService;
    private final RequestMapper requestMapper;

    public TopSecretController(ShipInfoService shipInfoService, RequestMapper requestMapper) {
        this.shipInfoService = shipInfoService;
        this.requestMapper = requestMapper;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ShipInfoDTO getShipInformation(@RequestBody SatellitesDTO satellitesDTO) {
        Map<String, Satellite> satellites = requestMapper.mapSatellites(satellitesDTO);
        return requestMapper.mapShipInfo(shipInfoService.getShipInfo(satellites));
    }
}
