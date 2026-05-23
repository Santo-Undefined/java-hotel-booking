package com.tw.hotel.entities;

@FunctionalInterface
public interface BookingProjector<T> {
    T project(String bookingId, int hotelId, int rooms, String status);
}