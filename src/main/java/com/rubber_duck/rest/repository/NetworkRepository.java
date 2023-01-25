package com.rubber_duck.rest.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rubber_duck.rest.models.Network;

@Repository
public interface NetworkRepository extends MongoRepository<Network, String> {
    
    @Query("{'created': {$gte: ?0}}")
    List<Network> findByDays(Instant date);
}
