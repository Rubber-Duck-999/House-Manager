package com.rubber_duck.rest.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubber_duck.rest.models.Alarm;
import com.rubber_duck.rest.repository.AlarmRepository;

@Service
public class AlarmService {

    @Autowired
    private AlarmRepository alarmRepository;

    private final String alarmId = "98765";

    public Alarm createAlarm() {
        Alarm alarm = new Alarm();
        alarm.setId(this.alarmId);
        alarm.setState("ON");
        alarm.setUpdatedTime(Instant.now());
        return alarm;
    }

    public Alarm getAlarm() {
        Alarm alarm = alarmRepository.findById(this.alarmId).orElse(null);
        if (alarm == null) {
            alarm = this.createAlarm();
        }
        return alarm;
    }

    public Alarm updateAlarm(String state) {
        Alarm alarm = new Alarm();
        alarm.setId(this.alarmId);
        alarm.setState(state);
        alarm.setUpdatedTime(Instant.now());
        return alarmRepository.save(alarm);
    }

}
