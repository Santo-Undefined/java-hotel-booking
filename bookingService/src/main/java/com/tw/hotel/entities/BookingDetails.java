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
    private final String userName;
    private final int hotelId;
    private final int rooms;
    private String status;

    public BookingDetails(String bookingId, String userName, int hotelId, int rooms, String status) {
        this.bookingId = bookingId;
        this.userName = userName;
        this.hotelId = hotelId;
        this.rooms = rooms;
        this.status = status;
    }

    public <T> T toResponse(BookingProjector<T> projector) {
        return projector.project(bookingId, hotelId, rooms, status);
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
