package com.microservicios.cuenta.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomErrorResponse {
    private String message;
    private String field;
    private String rejectedValue;
    private String timestamp;
    private String details;

    public CustomErrorResponse(String message, String field, String rejectedValue, String details) {
        this.message = message;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.timestamp = java.time.LocalDateTime.now().toString();
        this.details = details;
    }
}
