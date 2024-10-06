package com.microservicios.cuenta.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "cuentas")
@AllArgsConstructor
@Data
public class CuentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_cuenta", unique = true, nullable = false)
    private String numeroCuenta;

    @Column(name = "saldo", nullable = false)
    private Double saldo = 0.0;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cuenta", nullable = false)
    private TipoCuenta tipoCuenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_cuenta", nullable = false)
    private TipoEstado tipoestado;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    public CuentaEntity() {

    }
}
