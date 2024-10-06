package com.microservicios.transaccion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@Data
public class Deposito  extends Transaccion{

    private String odeposito;

    public Deposito() {

    }
}
