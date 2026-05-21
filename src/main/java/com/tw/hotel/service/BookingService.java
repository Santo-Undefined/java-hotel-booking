package com.tw.hotel.service;

import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.requestDto.BookingStatus;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    public BookingStatus bookHotel(BookingRequest request) {
        return new BookingStatus(1, request.hotel_id(), request.rooms(), "Booking successful");
    }
}
