package com.tw.hotel.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tw.hotel.entities.BookingDetails;
import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.responseDto.BookingResponseDto;

import java.util.List;

public interface BookingService {
    BookingResponseDto bookHotel(BookingRequest request) throws JsonProcessingException;
    List<BookingResponseDto> listBookings();
    BookingResponseDto listBookingById(String bookingId);

    BookingResponseDto updateStatus(String bookingId);
}
