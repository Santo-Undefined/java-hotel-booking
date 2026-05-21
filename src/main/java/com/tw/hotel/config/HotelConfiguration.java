package com.tw.hotel.config;

import com.tw.hotel.service.HotelRecord;
import com.tw.hotel.service.HotelService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class HotelConfiguration {
    @Bean
    public HotelService createHotelService() {
        ArrayList<HotelRecord> hotelRecords = new ArrayList<>();
        hotelRecords.add(new HotelRecord("santoHotel", 1, 5, "New York"));
        return new HotelService(hotelRecords);
    }
}
