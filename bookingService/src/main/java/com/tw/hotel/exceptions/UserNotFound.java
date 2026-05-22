package com.tw.hotel.exceptions;

public class UserNotFound extends Throwable {
    public UserNotFound(String msg) {
        super(msg);
    }
}
