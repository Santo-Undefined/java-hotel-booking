package com.tw.hotel.service;

import com.tw.hotel.requestDto.HotelsSearchResult;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelService {

    private final ArrayList<HotelRecord> hotelRecords;

    public HotelService(ArrayList<HotelRecord> hotelRecords) {
        this.hotelRecords = hotelRecords;
    }

    public HotelsSearchResult searchHotels(String city) {
        ArrayList<HotelRecord> hotelsSearchResults = hotelRecords
                .stream()
                .filter(hotels -> hotels.city().equals(city))
                .collect(Collectors.toCollection(ArrayList::new));
        return new HotelsSearchResult(hotelsSearchResults);
    }
}
