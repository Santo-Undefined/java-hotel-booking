package com.tw.hotel.requestDto;

import com.tw.hotel.service.Hotel;

import java.util.List;

public record HotelsSearchResult(List<Hotel> hotels) {
}
