package com.tw.hotel.mongoService;

import com.tw.hotel.repository.BookingRepository;
import com.tw.hotel.entities.BookingDetails;
import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.responseDto.BookingResponseDto;
import com.tw.hotel.service.BookingService;
import com.tw.hotel.service.IdGenerator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MongoBookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final IdGenerator idGenerator;

    public MongoBookingServiceImpl(BookingRepository bookingRepository, IdGenerator idGenerator) {
        this.bookingRepository = bookingRepository;
        this.idGenerator = idGenerator;
    }

    @Override
    public BookingResponseDto bookHotel(BookingRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String bookingId = this.idGenerator.generate();
        final BookingDetails bookingDetails = new BookingDetails(bookingId,auth.getName(), request.hotel_id(), request.rooms());
        bookingRepository.save(bookingDetails);

        return  bookingDetails.toResponse(BookingResponseDto::new);
    }

    @Override
    public List<BookingResponseDto> listBookings() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<BookingDetails> bookings = bookingRepository.findBookingDetailsByUserName(auth.getName());
        return bookings.stream().map(booking -> booking.toResponse(BookingResponseDto::new)).toList();
    }

    @Override
    public BookingResponseDto listBookingById(String bookingId) {
        BookingDetails booking = bookingRepository.findByBookingId(bookingId);
        return booking.toResponse(BookingResponseDto::new);
    }
}
