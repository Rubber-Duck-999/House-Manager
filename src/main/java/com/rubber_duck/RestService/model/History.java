package com.rubber_duck.RestService.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="device-history")
public class History {
    private String date;
    private String customerId;
    private String amount;
    private String price;
}
