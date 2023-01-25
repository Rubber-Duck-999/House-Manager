package com.rubber_duck.rest.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rubber_duck.rest.models.Network;

import com.rubber_duck.rest.repository.NetworkRepository;

@Service
public class NetworkService {

    @Autowired
    private NetworkRepository networkRepository;

    public List<Network> listNetwork(Integer days) {
        Instant now = Instant.now();
        Instant value = now.minus(days, ChronoUnit.DAYS);
        return networkRepository.findByDays(value);
    }
}
