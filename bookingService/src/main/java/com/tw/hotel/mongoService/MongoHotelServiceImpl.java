package com.tw.hotel.mongoService;

import com.tw.hotel.repository.HotelRepository;
import com.tw.hotel.responseDto.HotelsSearchResult;
import com.tw.hotel.service.HotelService;
import org.springframework.stereotype.Service;

@Service
public class MongoHotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    public MongoHotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public HotelsSearchResult searchHotels(String city) {

        return new HotelsSearchResult(hotelRepository.findHotelsByCity(city));
    }
}
