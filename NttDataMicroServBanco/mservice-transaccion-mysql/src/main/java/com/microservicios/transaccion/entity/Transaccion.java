package com.microservicios.transaccion.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Retiro.class, name = "retiro"),
        @JsonSubTypes.Type(value = Deposito.class, name = "deposito")
})
@AllArgsConstructor
@Data
public abstract  class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numTransaccion;

    @Column(nullable = false)
    private String numCuenta;


    @Column(nullable = false)
    private Double monto;

    public Transaccion() {

    }
}
