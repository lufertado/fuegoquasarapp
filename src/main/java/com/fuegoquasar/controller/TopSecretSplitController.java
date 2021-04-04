package com.fuegoquasar.controller;

import com.fuegoquasar.controller.dto.SatelliteDTO;
import com.fuegoquasar.controller.dto.ShipInfoDTO;
import com.fuegoquasar.controller.mapper.RequestMapper;
import com.fuegoquasar.service.ShipInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topsecret_split")
public class TopSecretSplitController {

    private final ShipInfoService shipInfoService;
    private final RequestMapper requestMapper;

    public TopSecretSplitController(ShipInfoService shipInfoService, RequestMapper requestMapper) {
        this.shipInfoService = shipInfoService;
        this.requestMapper = requestMapper;
    }

    @RequestMapping(path = "/{satellite_name}", method = RequestMethod.POST)
    public void getShipInformation(@PathVariable("satellite_name") String satelliteName,
                                          @RequestBody SatelliteDTO satelliteDTO) {
        shipInfoService.putSatellite(requestMapper.mapSatellite(satelliteName, satelliteDTO));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ShipInfoDTO getShipInformation() {
        return requestMapper.mapShipInfo(shipInfoService.getShipInfo());
    }
}
