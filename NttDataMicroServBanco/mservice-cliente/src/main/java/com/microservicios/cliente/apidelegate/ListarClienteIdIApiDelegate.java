package com.microservicios.cliente.apidelegate;

import com.microservicios.cliente.api.IdApiDelegate;
import com.microservicios.cliente.business.ClienteService;
import com.microservicios.cliente.model.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ListarClienteIdIApiDelegate implements IdApiDelegate {
 @Autowired
    ClienteService clienteService;

    public  ResponseEntity<ClienteResponse> obtenerClientePorId(Integer id) {
       ClienteResponse clienteResponse= clienteService.obtenerClientePorId(Long.valueOf(id));
        return new ResponseEntity<>(clienteResponse, HttpStatus.OK);
    }


}
