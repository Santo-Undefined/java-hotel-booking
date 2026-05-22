package com.tw.hotel.exceptions;

public class ExistingUser extends Throwable {
    public ExistingUser(String msg) {
        super(msg);
    }
}
