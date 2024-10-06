package com.microservicios.cuenta.business.Externo;

import com.microservicios.cuenta.entity.model.Deposito;
import com.microservicios.cuenta.entity.model.Retiro;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TransaccionServiceClient {

    private final WebClient webClient;

    public TransaccionServiceClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:6060").build(); // Cambia la URL según tu configuración
    }


    public String obtenerTransaccion() {
        try {
            return webClient.get()
                    .uri("/api/transacciones/obtener/numtransaccion") // Cambia esto según el endpoint
                    .retrieve()
                    .bodyToMono(String.class)
                    .block(); // Esto bloqueará el hilo hasta que obtenga la respuesta.
        } catch (Exception e) {
            System.err.println("Error al obtener la transacción: " + e.getMessage());
            return null; // Devuelve null si hay un error
        }
    }

    public void crearTransaccionEnMicroservicio(Deposito transaccion) {
        webClient.post()
                .uri("/api/transacciones/crear") // Cambia esto según tu endpoint
                .bodyValue(transaccion)
                .retrieve()
                .bodyToMono(Deposito.class)
                .subscribe(response -> {
                    // Maneja la respuesta si es necesario
                }, error -> {
                    // Maneja el error si la llamada falla
                    System.err.println("Error al crear la transacción: " + error.getMessage());
                });
    }

    public void crearTransaccionRetiroEnMicroservicio(Retiro transaccion) {
        webClient.post()
                .uri("/api/transacciones/crear") // Cambia esto según tu endpoint
                .bodyValue(transaccion)
                .retrieve()
                .bodyToMono(Deposito.class)
                .subscribe(response -> {
                    // Maneja la respuesta si es necesario
                }, error -> {
                    // Maneja el error si la llamada falla
                    System.err.println("Error al crear la transacción: " + error.getMessage());
                });
    }




}
