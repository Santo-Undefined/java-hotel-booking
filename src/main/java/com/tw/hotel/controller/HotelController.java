package com.tw.hotel.controller;

import com.tw.hotel.requestDto.HotelsSearchResult;
import com.tw.hotel.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/search")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels")
    public HotelsSearchResult searchHotel(@RequestParam String city) {
        return hotelService.searchHotels(city);
    }
}
