package com.tw.hotel.requestDto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@Document
public final class BookingStatus {
    @Id
    private final int booking_id;
    private final int hotel_id;
    private final int rooms;

    public BookingStatus(int booking_id, int hotel_id, int rooms) {
        this.booking_id = booking_id;
        this.hotel_id = hotel_id;
        this.rooms = rooms;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BookingStatus) obj;
        return this.booking_id == that.booking_id &&
                this.hotel_id == that.hotel_id &&
                this.rooms == that.rooms;
    }

    @Override
    public int hashCode() {
        return Objects.hash(booking_id, hotel_id, rooms);
    }

}
