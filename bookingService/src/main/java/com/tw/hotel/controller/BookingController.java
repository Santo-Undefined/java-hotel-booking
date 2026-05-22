package com.tw.hotel.controller;

import com.tw.hotel.entities.BookingDetails;
import com.tw.hotel.requestDto.BookingRequest;
import com.tw.hotel.responseDto.BookingResponseDto;
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
    public BookingResponseDto bookHotel(@Valid @RequestBody BookingRequest bookingRequest) {
        return bookingService.bookHotel(bookingRequest);
    }

    @GetMapping("/bookings")
    public List<BookingResponseDto> listBookings(){
        return bookingService.listBookings();
    }

    @GetMapping("/bookings/{bookingId}/receipt.pdf")
    public ResponseEntity<String> bookingReceipt(@PathVariable String bookingId) {
        BookingResponseDto bookingDetails = bookingService.listBookingById(bookingId);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf");
        return new ResponseEntity<>(bookingDetails.toString(), httpHeaders, HttpStatus.OK);
    }
}
