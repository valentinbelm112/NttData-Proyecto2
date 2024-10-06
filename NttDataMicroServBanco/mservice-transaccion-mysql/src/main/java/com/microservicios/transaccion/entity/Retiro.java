package com.microservicios.transaccion.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@AllArgsConstructor
@Data
public class Retiro  extends Transaccion{
    private double comision;

    public Retiro() {

    }
}
