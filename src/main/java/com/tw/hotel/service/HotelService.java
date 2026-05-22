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
        hotelRepository.save(new Hotel("grand hotel", 1, 10, "New York"));
        hotelRepository.save(new Hotel("Leela Palace", 2, 100, "Bengaluru"));
        hotelRepository.save(new Hotel("Golden Palms", 3, 1000, "New York"));
        return new HotelsSearchResult(hotelRepository.findHotelsByCity(city));
    }
}
