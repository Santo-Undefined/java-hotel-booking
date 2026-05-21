package com.tw.hotel.service;

import com.tw.hotel.entities.User;
import com.tw.hotel.exceptions.ExistingUser;
import com.tw.hotel.exceptions.InvalidCredentials;
import com.tw.hotel.exceptions.NotFoundException;
import com.tw.hotel.exceptions.UserNotFound;
import com.tw.hotel.requestDto.UserRequestDto;
import com.tw.hotel.responseDto.UserResponseDto;

public interface UserService {
    UserResponseDto login(UserRequestDto userRequestDto) throws UserNotFound, InvalidCredentials;

    User findUser(String username) throws NotFoundException;

    UserResponseDto signUp(UserRequestDto userRequestDto) throws ExistingUser;
}
