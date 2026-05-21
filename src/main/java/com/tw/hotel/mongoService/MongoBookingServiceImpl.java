package com.tw.hotel.mongoService;

import com.tw.hotel.repository.BookingRepository;
import com.tw.hotel.entities.BookingDetails;
import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.service.BookingService;
import com.tw.hotel.service.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoBookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final IdGenerator idGenerator;

    public MongoBookingServiceImpl(BookingRepository bookingRepository, IdGenerator idGenerator) {
        this.bookingRepository = bookingRepository;
        this.idGenerator = idGenerator;
    }

    @Override
    public BookingDetails bookHotel(BookingRequest request) {
        final String bookingId = this.idGenerator.generate();
        final BookingDetails bookingDetails = new BookingDetails(bookingId, request.hotelId(), request.rooms());
        bookingRepository.save(bookingDetails);
        return bookingDetails;
    }

    @Override
    public List<BookingDetails> listBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingDetails listBookingById(String bookingId) {
        return bookingRepository.findByBookingId(bookingId);
    }
}
