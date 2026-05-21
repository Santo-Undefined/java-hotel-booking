package com.tw.hotel.service;

import com.tw.hotel.repository.HotelRepository;
import com.tw.hotel.requestDto.HotelsSearchResult;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public HotelsSearchResult searchHotels(String city) {
        return new HotelsSearchResult(hotelRepository.findHotelsByCity(city));
    }
}
