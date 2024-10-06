package com.microservicios.cuenta.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Retiro {
    private String tipo; // "deposito"
    private String tipoTransaccion; // "deposito"
    private String numTransaccion; // "TRANS123456789"
    private String ipTransaccion; // "192.168.1.30"
    private String numCuenta; // 2
    private Double monto; // 200.00
    private Double comision; // "comison"


}
