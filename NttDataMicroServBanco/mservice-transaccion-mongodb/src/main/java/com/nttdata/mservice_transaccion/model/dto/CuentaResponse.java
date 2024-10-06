package com.nttdata.mservice_transaccion.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaResponse {
    private Long id;
    private String numeroCuenta;
    private Double saldo;
    private String tipoCuenta;
    private String estadoCuenta;
    private Long clienteId;
}
