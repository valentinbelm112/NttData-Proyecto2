package com.microservicios.cliente.apidelegate;


import com.microservicios.cliente.api.CrearApiDelegate;
import com.microservicios.cliente.business.ClienteService;
import com.microservicios.cliente.model.ClienteRequest;
import com.microservicios.cliente.model.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CrearClienteApiDelegate implements CrearApiDelegate {

    @Autowired
    ClienteService clienteService;

    public  ResponseEntity<ClienteResponse> crearCliente(ClienteRequest clienteRequest) {
        ClienteResponse clienteResponse=clienteService.crearCliente(clienteRequest);
         return new ResponseEntity<>(clienteResponse, HttpStatus.CREATED);
    }

}
