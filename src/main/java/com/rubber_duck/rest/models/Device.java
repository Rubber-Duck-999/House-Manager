package com.rubber_duck.rest.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="device")
public class Device {

    @MongoId
    private String id;
    private String name;
}
