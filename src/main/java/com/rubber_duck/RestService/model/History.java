package com.rubber_duck.RestService.model;

@Getter
@Setter
@Document(collection="device-history")
public class History {
    private String date;
    private String customerId;
    private String amount;
    private String price;
}
