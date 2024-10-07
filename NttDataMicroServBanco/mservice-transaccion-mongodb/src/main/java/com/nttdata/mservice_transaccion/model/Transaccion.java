package com.nttdata.mservice_transaccion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;


@Data
@Document(collection = "transacciones")
@AllArgsConstructor
public class Transaccion {

    @Id
    private String id;
    private String tipo; // Depósito, Retiro, Transferencia
    private double monto;
    private LocalDate fecha;
    private String cuentaOrigen;
    private String cuentaDestino; // Puede ser nulo para depósitos y retiros

    public Transaccion() {

    }
}
