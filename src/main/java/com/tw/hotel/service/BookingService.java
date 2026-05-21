package com.tw.hotel.service;

import com.tw.hotel.repository.BookingRepository;
import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.requestDto.BookingDetails;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final IdGenerator idGenerator;

    public BookingService(BookingRepository bookingRepository, IdGenerator idGenerator) {
        this.bookingRepository = bookingRepository;
        this.idGenerator = idGenerator;
    }

    public BookingDetails bookHotel(BookingRequest request) {
        final String booking_id = this.idGenerator.generate();
        final BookingDetails bookingDetails = new BookingDetails(booking_id, request.hotel_id(), request.rooms());
        bookingRepository.save(bookingDetails);
        return bookingDetails;
    }
}
