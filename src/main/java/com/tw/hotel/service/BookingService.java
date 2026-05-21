package com.tw.hotel.service;

import com.tw.hotel.requestDot.BookingRequest;
import com.tw.hotel.requestDot.BookingStatus;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    public BookingStatus bookHotel(BookingRequest request) {
        return new BookingStatus(request.hotel_id(), request.rooms(), "Booking successful");
    }
}
