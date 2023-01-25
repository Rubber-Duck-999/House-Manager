package com.rubber_duck.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rubber_duck.rest.models.Alarm;

@Repository
public interface AlarmRepository extends MongoRepository<Alarm, String> {}
