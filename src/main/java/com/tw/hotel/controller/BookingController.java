package com.tw.hotel.controller;

import com.tw.hotel.entities.BookingDetails;
import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/bookings")
    public BookingDetails bookHotel(@Valid @RequestBody BookingRequest bookingRequest) {
        return bookingService.bookHotel(bookingRequest);
    }

    @GetMapping("/bookings")
    public List<BookingDetails> listBookings(){
        System.out.println("in booking controller");
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
