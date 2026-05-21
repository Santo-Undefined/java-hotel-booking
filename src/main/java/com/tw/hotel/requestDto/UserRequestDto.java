package com.tw.hotel.requestDto;

import jakarta.validation.constraints.NotNull;

public record UserRequestDto (
        @NotNull(message = "Username can't be missing")
        String username,
        @NotNull(message = "Password can't be missing")
        String password){
}
