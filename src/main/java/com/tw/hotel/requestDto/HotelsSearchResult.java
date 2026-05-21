package com.tw.hotel.requestDto;

import com.tw.hotel.service.HotelRecord;

import java.util.ArrayList;

public record HotelsSearchResult(ArrayList<HotelRecord> hotels) {
}
