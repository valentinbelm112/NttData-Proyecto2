package com.microservicios.transaccion.repository;

import com.microservicios.transaccion.entity.Retiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetiroRepository extends JpaRepository<Retiro, Long> {
}