package com.tw.hotel.controller;

import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.requestDto.BookingDetails;
import com.tw.hotel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/bookings")
    public BookingDetails bookHotel(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookHotel(bookingRequest);
    }

    @GetMapping("/bookings")
    public List<BookingDetails> listBookings(){
        return bookingService.listBookings();
    }

    @GetMapping("/bookings/{booking_id}/receipt.pdf")
    public ResponseEntity<String> bookingReceipt(@PathVariable String booking_id) {
        BookingDetails bookingDetails = bookingService.listBookingById(booking_id);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf");
        return new ResponseEntity<>(bookingDetails.toString(), httpHeaders, HttpStatus.OK);
    }
}
