package com.microservicios.cliente.util;

import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class clientUtil {

    public static Supplier<IllegalArgumentException> clienteNoEncontrado(Long id) {
        return () -> new IllegalArgumentException("Cliente no encontrado con ID: " + id);
    }
}
