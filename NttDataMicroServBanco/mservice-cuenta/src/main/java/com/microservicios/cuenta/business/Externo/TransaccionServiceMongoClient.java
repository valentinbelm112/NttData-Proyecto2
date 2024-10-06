package com.microservicios.cuenta.business.Externo;

import com.microservicios.cuenta.entity.model.Deposito;
import com.microservicios.cuenta.entity.model.DepositoMongo;
import com.microservicios.cuenta.entity.model.Retiro;
import com.microservicios.cuenta.entity.model.RetiroMongo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TransaccionServiceMongoClient {
    private final WebClient webClient;

    public TransaccionServiceMongoClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:6060").build(); // Cambia la URL según tu configuración
    }

    public void crearTransaccionRetiroEnMicroservicio(RetiroMongo retiro) {
        webClient.post()
                .uri("/api/mongo/transacciones/retiro")
                .bodyValue(retiro)
                .retrieve()
                .bodyToMono(Deposito.class)
                .subscribe(response -> {

                }, error -> {

                    System.err.println("Error al crear la transacción: " + error.getMessage());
                });
    }

    public void crearTransaccionDepositoEnMicroservicio(DepositoMongo deposito) {
        webClient.post()
                .uri("/api/mongo/transacciones/deposito")
                .bodyValue(deposito)
                .retrieve()
                .bodyToMono(Deposito.class)
                .subscribe(response -> {

                }, error -> {

                    System.err.println("Error al crear la transacción: " + error.getMessage());
                });
    }
}
