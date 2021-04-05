package com.fuegoquasar.service;

import com.fuegoquasar.domain.Coordinate;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationServiceTest {

    private final LocationService service = new LocationService();

    @Test
    public void testGetLocation() {
        Map<String, Double> distances = new HashMap<>();
        distances.put("kenobi", 100.0);
        distances.put("skywalker", 115.5);
        distances.put("sato", 142.7);

        Coordinate coordinate = service.getLocation(distances);
        Assert.assertEquals(1.0917619707373333E8, coordinate.getX(), 0);
        Assert.assertEquals(2.181939473272E8, coordinate.getY(), 0);
    }
}
