package com.tw.hotel.service;

import com.tw.hotel.responseDto.HotelsSearchResult;

public interface HotelService {
     HotelsSearchResult searchHotels(String city);
}
