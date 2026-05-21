package com.tw.hotel.repository;

import com.tw.hotel.entities.BookingDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<BookingDetails, String> {
    BookingDetails findByBookingId(String bookingId);
}
