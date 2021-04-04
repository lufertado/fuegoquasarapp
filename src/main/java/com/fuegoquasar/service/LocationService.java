package com.fuegoquasar.service;

import com.fuegoquasar.domain.Coordinate;
import com.fuegoquasar.domain.SatelliteEnum;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LocationService {

    private static final Map<String, Coordinate> satellites = new HashMap<>();
    private static final String KENOBI = SatelliteEnum.KENOBI.getName();
    private static final String SKYWALKER = SatelliteEnum.SKYWALKER.getName();
    private static final String SATO = SatelliteEnum.SATO.getName();

    public LocationService() {
        satellites.put(KENOBI, new Coordinate(-500, -200));
        satellites.put(SKYWALKER, new Coordinate(100, -100));
        satellites.put(SATO, new Coordinate(500, 100));
    }

    public Coordinate getLocation(Map<String, Double> distances) {
        double dist1Pow2 = Math.pow(distances.get(KENOBI), 2);
        double dist2Pow2 = Math.pow(distances.get(SKYWALKER), 2);
        double dist3Pow2 = Math.pow(distances.get(SATO), 2);
        double x1 = satellites.get(KENOBI).getX();
        double x2 = satellites.get(SKYWALKER).getX();
        double x3 = satellites.get(SATO).getX();
        double y1 = satellites.get(KENOBI).getY();
        double y2 = satellites.get(SKYWALKER).getY();
        double y3 = satellites.get(SATO).getY();
        double x1Pow2 = Math.pow(x1, 2);
        double x2Pow2 = Math.pow(x2, 2);
        double x3Pow2 = Math.pow(x3, 2);
        double y1Pow2 = Math.pow(y1, 2);
        double y2Pow2 = Math.pow(y2, 2);
        double y3Pow2 = Math.pow(y3, 2);
        double a = (2 * x1 - 2 * x2);
        double b = (2 * y1 - 2 * y2);
        double c = dist1Pow2 - dist2Pow2 - x1Pow2 + x2Pow2 - y1Pow2 + y2Pow2;
        double d = (2 * x2 - 2 * x3);
        double e = ( 2 * y2 - 2 * y3);
        double f = dist2Pow2 - dist3Pow2 - x2Pow2 + x3Pow2 - y2Pow2 + y3Pow2;

        double x = (c * e) - (f * b) / (e * a) - (b * d);
        double y = (c * d) - (a * f) / (b * d) - (a * e);
        return new Coordinate(x, y);
    }
}
