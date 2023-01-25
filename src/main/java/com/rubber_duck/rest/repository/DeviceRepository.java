package com.rubber_duck.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rubber_duck.rest.models.Device;

@Repository
public interface DeviceRepository extends MongoRepository<Device, String>{

    @Query("{'name': ?0}")
    Device findAllByName(String name);

}
