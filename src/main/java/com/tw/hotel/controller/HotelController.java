package com.tw.hotel.controller;

import com.tw.hotel.requestDto.HotelsSearchResult;
import com.tw.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels")
    public ResponseEntity<HotelsSearchResult> searchHotel(@RequestParam String city) {
        HotelsSearchResult results = hotelService.searchHotels(city);
        return ResponseEntity.ok().body(results);
    }
}
