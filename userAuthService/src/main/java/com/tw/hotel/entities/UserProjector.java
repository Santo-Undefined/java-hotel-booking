package com.tw.hotel.entities;

@FunctionalInterface
public interface UserProjector<T> {
    T project( String username);
}
