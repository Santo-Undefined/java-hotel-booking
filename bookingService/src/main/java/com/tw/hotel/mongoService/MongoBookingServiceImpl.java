package com.tw.hotel.mongoService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tw.hotel.repository.BookingRepository;
import com.tw.hotel.entities.BookingDetails;
import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.responseDto.BookingResponseDto;
import com.tw.hotel.service.BookingService;
import com.tw.hotel.service.IdGenerator;
import com.tw.hotel.service.RedisService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MongoBookingServiceImpl implements BookingService {
    private final RedisService redisService;
    private final BookingRepository bookingRepository;
    private final IdGenerator idGenerator;

    public MongoBookingServiceImpl(RedisService redisService, BookingRepository bookingRepository, IdGenerator idGenerator) {
        this.redisService = redisService;
        this.bookingRepository = bookingRepository;
        this.idGenerator = idGenerator;
    }

    @Override
    public BookingResponseDto bookHotel(BookingRequest request) throws JsonProcessingException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String bookingId = this.idGenerator.generate();
        final BookingDetails bookingDetails = new BookingDetails(bookingId,auth.getName(), request.hotel_id(), request.rooms(), "Receipt is generating");
        bookingRepository.save(bookingDetails);

        BookingResponseDto response = bookingDetails.toResponse(BookingResponseDto::new);
        redisService.pushTask(response).subscribe();
        return response;
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

    @Override
    public BookingResponseDto updateStatus(String bookingId) {
        bookingRepository.findAndUpdateStatus(bookingId, "Receipt Generated");
        BookingDetails bookingDetails = bookingRepository.findByBookingId(bookingId);
        return bookingDetails.toResponse(BookingResponseDto::new);
    }
}
