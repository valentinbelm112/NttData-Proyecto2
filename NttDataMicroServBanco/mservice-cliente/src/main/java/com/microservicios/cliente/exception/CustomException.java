package com.microservicios.cliente.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
