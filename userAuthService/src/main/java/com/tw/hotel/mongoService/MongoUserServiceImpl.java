package com.tw.hotel.mongoService;

import com.tw.hotel.entities.User;
import com.tw.hotel.exceptions.ExistingUser;
import com.tw.hotel.exceptions.InvalidCredentials;
import com.tw.hotel.exceptions.NotFoundException;
import com.tw.hotel.exceptions.UserNotFound;
import com.tw.hotel.repository.UserRepository;
import com.tw.hotel.requestDto.UserRequestDto;
import com.tw.hotel.responseDto.UserResponseDto;
import com.tw.hotel.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MongoUserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public MongoUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto login(UserRequestDto userRequestDto) throws UserNotFound, InvalidCredentials {
        Optional<User> existingUser = userRepository.findUserByUserName(userRequestDto.username());
        if (existingUser.isEmpty()) throw new UserNotFound("User not found");

        User user = existingUser.get();
        if( !user.getPassword().equals( userRequestDto.password())) throw  new InvalidCredentials("Password does not match");

        return user.toResponse(UserResponseDto::new);
    };

    @Override
    public User findUser(String username) throws NotFoundException {
        return userRepository.findUserByUserName(username).orElseThrow(() -> new NotFoundException(String.format("User %s not found", username)));
    }

    @Override
    public UserResponseDto signUp(UserRequestDto userRequestDto) throws  ExistingUser {
        Optional<User> existingUser = userRepository.findUserByUserName(userRequestDto.username());
        if (existingUser.isPresent()) {
            throw new ExistingUser(String.format("user %s already exists", userRequestDto.username()));
        }
        User newUser = userRepository.save(new User(userRequestDto.username(), userRequestDto.password()));

        return newUser.toResponse(UserResponseDto::new);
    }
}
