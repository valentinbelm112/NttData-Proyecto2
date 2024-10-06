package com.microservicios.cliente.business.Externo;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TransaccionServiceClient {

    private final WebClient webClient;

    public TransaccionServiceClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:6060").build(); // Cambia la URL según tu configuración
    }


    public boolean validarCuentaActiva(Long idCliente) {
        try {
            return webClient.get()
                    .uri("/api/cuentas/cliente/{idCliente}/activas",idCliente) // Cambia esto según el endpoint
                    .retrieve()
                    .bodyToMono(boolean.class)
                    .block(); // Esto bloqueará el hilo hasta que obtenga la respuesta.
        } catch (Exception e) {
            System.err.println("Error al obtener la transacción: " + e.getMessage());
            return true; // Devuelve null si hay un error
        }
    }


}
