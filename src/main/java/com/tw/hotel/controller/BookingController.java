package com.tw.hotel.controller;

import com.tw.hotel.requestDot.BookingRequest;
import com.tw.hotel.requestDot.BookingStatus;
import com.tw.hotel.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookingController {
    @PostMapping("/bookings")
    public BookingStatus bookHotel(BookingRequest bookingRequest) {
        BookingService bookingService = new BookingService();
        return bookingService.bookHotel(bookingRequest);
    }
}
