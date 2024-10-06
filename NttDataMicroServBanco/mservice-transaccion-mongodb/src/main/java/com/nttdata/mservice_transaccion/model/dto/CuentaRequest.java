package com.nttdata.mservice_transaccion.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CuentaRequest {

    private String numeroCuenta;

    private Double saldo;

    private String tipoCuenta;

    private String estadoCuenta;

    private Integer clienteId;

    public CuentaRequest() {

    }
}
