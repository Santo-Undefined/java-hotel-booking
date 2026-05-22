package com.tw.hotel.repository;

import com.tw.hotel.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findUserByUserName(String userName);
}
