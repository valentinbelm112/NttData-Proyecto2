package com.microservicios.cuenta.util;

import com.microservicios.cuenta.repository.CuentaRepository;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
@Component
public class CuentaUtil {

    public static  String generarNumeroCuentaUnico(CuentaRepository cuentaRepository) {
        return Stream.generate(() -> generarNumeroAleatorio(13)) // Genera un número de 13 dígitos
                .filter(numeroCuenta -> !cuentaRepository.existsByNumeroCuenta(numeroCuenta)) // Filtra números que no existan en la base de datos
                .findFirst() // Toma el primer número que cumpla la condición
                .orElseThrow(() -> new IllegalStateException("No se pudo generar un número de cuenta único")); // Manejo de errores
    }

    public static String generarNumeroAleatorio(int longitud) {
        Random random = new Random();
        return IntStream.range(0, longitud) // Genera un rango de números desde 0 hasta longitud
                .map(i -> random.nextInt(10)) // Mapea cada índice a un dígito aleatorio
                .mapToObj(String::valueOf) // Convierte cada dígito a String
                .collect(Collectors.joining()); // Une todos los String en uno solo
    }

    public  static Supplier<IllegalArgumentException> clienteNoEncontrado(Long id) {
        return () -> new IllegalArgumentException("Cuenta no encontrado con ID: " + id);
    }
}
