package com.tw.hotel.service;

import com.tw.hotel.repository.BookingRepository;
import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.requestDto.BookingStatus;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public BookingStatus bookHotel(BookingRequest request) {
        final BookingStatus bookingStatus = new BookingStatus(1, request.hotel_id(), request.rooms());
        bookingRepository.save(bookingStatus);
        return bookingStatus;
    }
}
