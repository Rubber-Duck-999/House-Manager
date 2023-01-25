package com.rubber_duck.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rubber_duck.rest.models.Mood;

@Repository
public interface MoodRepository extends MongoRepository<Mood, String> {

}
