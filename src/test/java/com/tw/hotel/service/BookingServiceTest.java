package com.tw.hotel.service;

import com.tw.hotel.repository.BookingRepository;
import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.requestDto.BookingStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
@AutoConfigureDataMongo
class BookingServiceTest {
    @Autowired
    private BookingRepository bookingRepository;

    @Test
    void shouldBookAHotel() {
        final IdGenerator mockGenerator = mock(IdGenerator.class);
        BookingService bookingService = new BookingService(bookingRepository, mockGenerator);
        BookingRequest request = new BookingRequest(5, 3);
        BookingStatus bookingStatus = bookingService.bookHotel(request);
        assertEquals(bookingStatus.getHotel_id(), 5);
        assertEquals(bookingStatus.getRooms(), 3);
    }
}