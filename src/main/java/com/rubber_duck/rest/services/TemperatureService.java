package com.rubber_duck.rest.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubber_duck.rest.repository.TemperatureRepository;
import com.rubber_duck.rest.models.Temperature;

@Service
public class TemperatureService {

    @Autowired
    private TemperatureRepository temperatureRepository;

    public List<Temperature> listTemperature(Integer days) {
        Instant now = Instant.now();
        Instant value = now.minus(days, ChronoUnit.DAYS);
        return temperatureRepository.findByDays(value);
    }
    
}
