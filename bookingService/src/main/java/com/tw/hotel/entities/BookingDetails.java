package com.tw.hotel.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@Document
public final class BookingDetails {
    @Id
    private final String bookingId;
    private final int hotelId;
    private final int rooms;

    public BookingDetails(String bookingId, int hotelId, int rooms) {
        this.bookingId = bookingId;
        this.hotelId = hotelId;
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BookingDetails) obj;
        return Objects.equals(this.bookingId, that.bookingId) &&
                this.hotelId == that.hotelId &&
                this.rooms == that.rooms;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, hotelId, rooms);
    }

}
