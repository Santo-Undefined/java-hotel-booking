package com.tw.hotel.service;

import com.tw.hotel.entities.BookingDetails;
import com.tw.hotel.requestDto.BookingRequest;

import java.util.List;

public interface BookingService {
    BookingDetails bookHotel(BookingRequest request);

    List<BookingDetails> listBookings();

    BookingDetails listBookingById(String bookingId);
}
