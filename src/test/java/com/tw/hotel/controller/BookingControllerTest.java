package com.tw.hotel.controller;

import com.tw.hotel.requestDot.BookingRequest;
import com.tw.hotel.requestDot.BookingStatus;
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
        BookingStatus expectedStatus = new BookingStatus(1, 3, "Booking Successful");
        BookingRequest request = new BookingRequest(1, 3);
        when(bookingService.bookHotel(request)).thenReturn(expectedStatus);

        BookingStatus responseBody = client.post()
                .uri("/api/bookings")
                .body(new BookingRequest(1, 3)).
                exchange()
                .expectStatus().isOk()
                .expectBody(BookingStatus.class)
                .returnResult()
                .getResponseBody();

        assertEquals(expectedStatus, responseBody);
    }
}