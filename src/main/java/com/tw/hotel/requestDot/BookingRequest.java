package com.tw.hotel.requestDot;

public record BookingRequest(int hotelId, int roomCount) {

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookingRequest request)) return false;
        return hotelId == request.hotelId && roomCount == request.roomCount;
    }

}
