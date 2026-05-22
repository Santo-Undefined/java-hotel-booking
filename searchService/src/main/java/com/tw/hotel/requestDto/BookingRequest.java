package com.tw.hotel.requestDto;


import jakarta.validation.constraints.NotNull;

public record BookingRequest(@NotNull int hotel_id, @NotNull int rooms) {
}
