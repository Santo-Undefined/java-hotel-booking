package com.tw.hotel.service;

import com.tw.hotel.repository.BookingRepository;
import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.requestDto.BookingDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final IdGenerator idGenerator;

    public BookingService(BookingRepository bookingRepository, IdGenerator idGenerator) {
        this.bookingRepository = bookingRepository;
        this.idGenerator = idGenerator;
    }

    public BookingDetails bookHotel(BookingRequest request) {
        final String bookingId = this.idGenerator.generate();
        final BookingDetails bookingDetails = new BookingDetails(bookingId, request.hotelId(), request.rooms());
        bookingRepository.save(bookingDetails);
        return bookingDetails;
    }

    public List<BookingDetails> listBookings() {
        return bookingRepository.findAll();
    }

    public BookingDetails listBookingById(String bookingId) {
        return bookingRepository.findByBookingId(bookingId);
    }
}
