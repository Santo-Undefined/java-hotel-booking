package com.tw.hotel.service;

import com.tw.hotel.repository.BookingRepository;
import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.requestDto.BookingStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
class BookingServiceTest {

    @Test
    void shouldBookAHotel() {
        final IdGenerator mockGenerator = mock(IdGenerator.class);
        final BookingRepository mockRepo = mock(BookingRepository.class);
        BookingService bookingService = new BookingService(mockRepo, mockGenerator);
        BookingRequest request = new BookingRequest(5, 3);
        BookingStatus bookingStatus = bookingService.bookHotel(request);
        assertEquals(bookingStatus.getHotel_id(), 5);
        assertEquals(bookingStatus.getRooms(), 3);
    }
}