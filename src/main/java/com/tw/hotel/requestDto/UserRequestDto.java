package com.tw.hotel.requestDto;

import jakarta.validation.constraints.NotNull;

public record UserRequestDto (
        @NotNull
        String username,
        @NotNull
        String password){
}
