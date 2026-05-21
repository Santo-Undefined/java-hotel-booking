package com.tw.hotel.service;

import com.tw.hotel.requestDot.BookingRequest;
import com.tw.hotel.requestDot.BookingStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookingServiceTest {

    @Test
    void shouldReturnTrue() {
        BookingService bookingService = new BookingService();
        BookingRequest request = new BookingRequest(1, 3);
        BookingStatus bookingStatus = bookingService.bookHotel(request);
        assertTrue(bookingStatus.equals(new BookingStatus(request.hotelId(), request.roomCount(), "Booking successful")));
    }
}