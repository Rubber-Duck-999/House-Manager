package com.rubber_duck.rest.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubber_duck.rest.models.Motion;
import com.rubber_duck.rest.repository.MotionRepository;

@Service
public class MotionService {

    @Autowired
    private MotionRepository motionRepository;

    public boolean createMotion() {
        Motion motion = new Motion();
        motion.setDetectedTime(Instant.now());
        motion.setId(UUID.randomUUID().toString());
        Motion createdMotion = motionRepository.save(motion);
        if (createdMotion.getId().equals(motion.getId())) {
            return true;
        }
        return false;
    }

    public List<Motion> listMotion(Integer days) {
        Instant now = Instant.now();
        Instant value = now.minus(days, ChronoUnit.DAYS);
        return motionRepository.findByDays(value);
    }
}
