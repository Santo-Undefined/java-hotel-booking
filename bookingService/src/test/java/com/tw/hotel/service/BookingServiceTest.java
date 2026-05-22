package com.tw.hotel.service;

import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.entities.BookingDetails;
import org.junit.jupiter.api.Test;
import org.springframework.boot.data.mongodb.test.autoconfigure.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

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
        BookingRequest request = new BookingRequest(5, 3);

        when(bookingService.bookHotel(request)).thenReturn(new BookingDetails("12312312", "test",5,3));

        BookingDetails bookingDetails = bookingService.bookHotel(request);

        assertEquals(bookingDetails.getHotelId(), 5);
        assertEquals(bookingDetails.getRooms(), 3);
    }

    @Test
    void shouldReturnListOfBookings() {
        when(bookingService.listBookings()).thenReturn(List.of(new BookingDetails("12312312", "test",5,3)));

        List<BookingDetails> bookingDetails = bookingService.listBookings();

        assertEquals(bookingDetails.get(0), new BookingDetails("12312312", "test",5,3));
    }
}