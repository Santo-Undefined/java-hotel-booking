package com.tw.hotel.service;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Hotels")
@Data
public final class Hotel {
    private final String name;
    private final int id;
    private final int rooms;
    private final String city;

    public Hotel(String name, int id, int rooms, String city) {
        this.name = name;
        this.id = id;
        this.rooms = rooms;
        this.city = city;
    }
}
