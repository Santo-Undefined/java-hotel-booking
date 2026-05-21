package com.tw.hotel.repository;

import com.tw.hotel.requestDto.BookingStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<BookingStatus, String> {
}
