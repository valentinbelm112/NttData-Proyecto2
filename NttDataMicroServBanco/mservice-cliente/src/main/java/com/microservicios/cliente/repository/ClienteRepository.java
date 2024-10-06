package com.microservicios.cliente.repository;

import com.microservicios.cliente.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    // Opcional: Puedes agregar métodos personalizados si es necesario.
}
