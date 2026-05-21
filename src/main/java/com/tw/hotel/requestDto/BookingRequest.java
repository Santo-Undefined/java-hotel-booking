package com.tw.hotel.requestDto;

<<<<<<< HEAD
public record BookingRequest(int hotel_id, int rooms) {
=======
import jakarta.validation.constraints.NotNull;

public record BookingRequest(@NotNull int hotelId, @NotNull int rooms) {
>>>>>>> ecb57d1 (code refactoring)
}
