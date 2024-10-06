package com.nttdata.mservice_transaccion.business.Externo;


import com.nttdata.mservice_transaccion.model.dto.CuentaRequest;
import com.nttdata.mservice_transaccion.model.dto.CuentaResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CuentaServiceClient {

    private final WebClient webClient;

    public CuentaServiceClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:6060").build(); // Cambia la URL según tu configuración
    }


    public CuentaResponse obtenerCuentaPorNumero(String numeroCuenta) {

        try {
            return webClient.get()
                    .uri("/api/cuentas/numero-cuenta/{numeroCuenta}", numeroCuenta)
                    .retrieve()
                    .bodyToMono(CuentaResponse.class)
                    .block();
        } catch (Exception e) {

            return null;
        }
    }

    public CuentaResponse ActualizarSaldo(Integer id, CuentaRequest cuentaRequest) {

        try {
            return webClient.put()
                    .uri("/api/cuentas/actualizar/{id}", id)
                    .bodyValue(cuentaRequest) // Envía el cuerpo de la solicitud como CuentaRequest
                    .retrieve() // Realiza la solicitud
                    .bodyToMono(CuentaResponse.class) // Espera la respuesta como CuentaResponse
                    .block(); // Bloquea hasta que se complete la solicitud
        } catch (Exception e) {

            return null;
        }
    }

}
