package com.lokdq.springboot_loda.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessages {
    private int statusCode;
    private String message;
}
