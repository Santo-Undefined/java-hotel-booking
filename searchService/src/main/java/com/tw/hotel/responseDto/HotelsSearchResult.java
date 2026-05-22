package com.tw.hotel.responseDto;

import com.tw.hotel.entities.Hotel;

import java.util.List;

public record HotelsSearchResult(List<Hotel> hotels) {
}
