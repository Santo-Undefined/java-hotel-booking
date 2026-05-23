package com.tw.hotel.responseDto;
import java.io.Serializable;

import com.tw.hotel.entities.Hotel;

import java.util.List;

public record HotelsSearchResult(List<Hotel> hotels) implements Serializable {
}
