package com.tw.hotel.requestDto;

public record BookingStatus(int booking_id, int hotel_id, int rooms, String message){
}
