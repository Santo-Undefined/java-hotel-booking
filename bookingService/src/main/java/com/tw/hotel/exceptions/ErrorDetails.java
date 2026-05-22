package com.tw.hotel.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDetails  {
    private Integer statusCode;
    private String msg;
}
