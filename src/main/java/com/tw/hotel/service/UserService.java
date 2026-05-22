package com.tw.hotel.service;

import com.tw.hotel.controller.UserResponseDto;
import com.tw.hotel.entities.User;
import com.tw.hotel.exceptions.InvalidCredentials;
import com.tw.hotel.exceptions.UserNotFound;
import com.tw.hotel.repository.UserRepository;
import com.tw.hotel.requestDto.UserRequestDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public  UserResponseDto login(UserRequestDto userRequestDto) throws UserNotFound, InvalidCredentials {
        Optional<User> existingUser = userRepository.findUserByUserName(userRequestDto.username());
        if (existingUser.isPresent()) throw new UserNotFound("User not found");
        User user = new User(existingUser.get().getUserName(), existingUser.get().getPassword());
        if( user.getPassword() != userRequestDto.password()) throw  new InvalidCredentials("Password does not match");

        return user.toResponse(UserResponseDto::new);
    };

}
