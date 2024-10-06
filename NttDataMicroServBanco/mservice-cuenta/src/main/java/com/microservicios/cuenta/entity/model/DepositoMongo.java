package com.microservicios.cuenta.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositoMongo {
    private Double monto; // 200.00
    private String cuentaOrigen; // "comison"
}
