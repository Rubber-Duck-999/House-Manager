package com.rubber_duck.RestService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rubber_duck.RestService.model.Image;

@Repository
public interface ImageRepository extends MongoRepository<Image, String>{
    
}
