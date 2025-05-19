package com.ark.poc.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponseDto {

    private String message;

    private Integer statusCode;

    private LocalDateTime timestamp;

}
