package com.tw.hotel.service;

import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.requestDto.BookingStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.data.mongodb.test.autoconfigure.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureDataMongo
class BookingServiceTest {

    @MockitoBean
    private BookingService bookingService;

    @Test
    void shouldBookAHotel() {
        final IdGenerator mockGenerator = mock(IdGenerator.class);
        BookingRequest request = new BookingRequest(5, 3);

        when(bookingService.bookHotel(request)).thenReturn(new BookingStatus("12312312", 5,3));

        BookingStatus bookingStatus = bookingService.bookHotel(request);

        assertEquals(bookingStatus.getHotel_id(), 5);
        assertEquals(bookingStatus.getRooms(), 3);
    }
}