package com.tw.hotel.service;

import com.tw.hotel.responseDto.HotelsSearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class HotelServiceTest {
    @MockitoBean
    HotelService hotelService;

    @Test
    void searchHotelWithCity() {
        HotelsSearchResult newYork = hotelService.searchHotels("New York");
    }
}