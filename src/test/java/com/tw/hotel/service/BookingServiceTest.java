package com.tw.hotel.service;

import com.tw.hotel.repository.BookingRepository;
import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.requestDto.BookingStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookingServiceTest {

    @MockitoBean
    private BookingRepository bookingRepository;

    @Test
    void shouldBookAHotel() throws InstantiationException, IllegalAccessException {
        BookingService bookingService = new BookingService(bookingRepository.getClass().newInstance());
        BookingRequest request = new BookingRequest(5, 3);
        BookingStatus bookingStatus = bookingService.bookHotel(request);
        assertTrue(bookingStatus.equals(new BookingStatus(1, request.hotel_id(), request.rooms())));
    }
}