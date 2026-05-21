package com.tw.hotel.controller;

import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.requestDto.BookingStatus;
import com.tw.hotel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/bookings")
    public BookingStatus bookHotel(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookHotel(bookingRequest);
    }
}
