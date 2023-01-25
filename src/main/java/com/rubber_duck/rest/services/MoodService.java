package com.rubber_duck.rest.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubber_duck.rest.models.Mood;
import com.rubber_duck.rest.repository.MoodRepository;

@Service
public class MoodService {

    @Autowired
    private MoodRepository moodRepository;

    private final String moodId = "98765";

    public Mood createMood() {
        Mood mood = new Mood();
        mood.setId(this.moodId);
        mood.setState("ON");
        mood.setUpdatedTime(Instant.now());
        return mood;
    }

    public Mood getMood() {
        Mood mood = moodRepository.findById(this.moodId).orElse(null);
        if (mood == null) {
            mood = this.createMood();
        }
        return mood;
    }
    
    public Mood updateMood(String state) {
        Mood mood = new Mood();
        mood.setId(this.moodId);
        mood.setState(state);
        mood.setUpdatedTime(Instant.now());
        return moodRepository.save(mood);
    }
}
