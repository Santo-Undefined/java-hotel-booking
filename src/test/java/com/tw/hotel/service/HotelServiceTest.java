package com.tw.hotel.service;

import com.tw.hotel.requestDto.HotelsSearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelServiceTest {
    @MockitoBean
    HotelService hotelService;

    @Test
    void searchHotelWithCity() {
        HotelsSearchResult newYork = hotelService.searchHotels("New York");
    }
}