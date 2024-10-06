package com.microservicios.cliente.apidelegate;

import com.microservicios.cliente.api.EliminarApiDelegate;
import com.microservicios.cliente.business.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class EliminarClienteServiceImpl implements EliminarApiDelegate {

    @Autowired
    ClienteService clienteService;

    public ResponseEntity<String> eliminarCliente(Integer id) {
        String resultadoOper = clienteService.eliminarCliente(Long.valueOf(id));
        return ResponseEntity.ok(resultadoOper);
    }



}
