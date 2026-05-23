package com.tw.hotel.entities;
import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Hotels")
@Data
public final class Hotel implements Serializable {
    @Id
    private final int id;
    private final String name;
    private final int rooms;
    private final String city;

    public Hotel(String name, int id, int rooms, String city) {
        this.name = name;
        this.id = id;
        this.rooms = rooms;
        this.city = city;
    }
}
