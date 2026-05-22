package com.tw.hotel.repository;

import com.tw.hotel.entities.BookingDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<BookingDetails, String> {
    List<BookingDetails> findBookingDetailsByUserName(String userName);
    BookingDetails findByBookingId(String bookingId);
}
