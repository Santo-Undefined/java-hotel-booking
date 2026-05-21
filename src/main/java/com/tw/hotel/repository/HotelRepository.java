package com.tw.hotel.repository;

import com.tw.hotel.entities.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, Integer> {
    @Query("{'city': ?0}")
    List<Hotel> findHotelsByCity(String city);
}
