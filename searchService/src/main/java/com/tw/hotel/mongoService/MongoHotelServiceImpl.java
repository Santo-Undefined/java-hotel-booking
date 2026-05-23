package com.tw.hotel.mongoService;

import com.tw.hotel.repository.HotelRepository;
import com.tw.hotel.responseDto.HotelsSearchResult;
import com.tw.hotel.service.HotelService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MongoHotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    public MongoHotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    @Cacheable(value = "hotelSearch", key = "#city")
    public HotelsSearchResult searchHotels(String city) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new HotelsSearchResult(hotelRepository.findHotelsByCity(city));
    }
}
