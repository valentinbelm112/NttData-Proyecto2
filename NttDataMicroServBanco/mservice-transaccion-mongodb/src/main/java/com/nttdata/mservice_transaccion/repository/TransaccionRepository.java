package com.nttdata.mservice_transaccion.repository;

import com.nttdata.mservice_transaccion.model.Transaccion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends MongoRepository<Transaccion, String> {
}
