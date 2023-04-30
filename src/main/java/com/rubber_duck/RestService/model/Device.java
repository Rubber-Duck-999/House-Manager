package com.rubber_duck.RestService.model;

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
    private String ipAddress;
    private String macAddress;
    private String createdBy;
    private String type;
    private String online;
}
