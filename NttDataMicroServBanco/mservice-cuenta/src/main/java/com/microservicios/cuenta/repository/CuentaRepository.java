package com.microservicios.cuenta.repository;

import com.microservicios.cuenta.entity.CuentaEntity;
import com.microservicios.cuenta.entity.TipoEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CuentaRepository extends JpaRepository<CuentaEntity, Long> {
    boolean existsByNumeroCuenta(String numeroCuenta);
    boolean existsByClienteIdAndTipoestado(Long clienteId, TipoEstado tipoEstado);
    public CuentaEntity findByNumeroCuenta(String numeroCuenta);

}
