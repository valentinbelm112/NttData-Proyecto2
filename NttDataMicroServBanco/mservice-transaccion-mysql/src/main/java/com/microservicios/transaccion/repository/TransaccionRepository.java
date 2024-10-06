package com.microservicios.transaccion.repository;

import com.microservicios.transaccion.entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    boolean existsByNumTransaccion(String numeroCuenta);
}

