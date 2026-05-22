package com.tw.hotel.service;

import com.tw.hotel.entities.BookingDetails;
import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.responseDto.BookingResponseDto;

import java.util.List;

public interface BookingService {
    BookingResponseDto bookHotel(BookingRequest request);
    List<BookingResponseDto> listBookings();
    BookingResponseDto listBookingById(String bookingId);
}
