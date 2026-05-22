package com.tw.hotel.controller;

import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.entities.BookingDetails;
import com.tw.hotel.service.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureRestTestClient
class BookingControllerTest {
    @Autowired
    private RestTestClient client;

    @MockitoBean
    private BookingService bookingService;

    @Test
    void shouldReturnABookingStatus() {
        BookingDetails expectedStatus = new BookingDetails("1", "test",1, 3);
        BookingRequest request = new BookingRequest(1, 3);
        when(bookingService.bookHotel(request)).thenReturn(expectedStatus);

        BookingDetails responseBody = client.post()
                .uri("/api/bookings")
                .body(request).
                exchange()
                .expectStatus().isOk()
                .expectBody(BookingDetails.class)
                .returnResult()
                .getResponseBody();

        assertEquals("1", responseBody.getBookingId());
        assertEquals(1, responseBody.getHotelId());
        assertEquals(3, responseBody.getRooms());
    }
}