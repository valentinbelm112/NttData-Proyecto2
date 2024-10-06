package com.microservicios.cliente.apidelegate;

import com.microservicios.cliente.api.ListarApiDelegate;
import com.microservicios.cliente.business.ClienteService;
import com.microservicios.cliente.model.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class ListarClienteImpl implements ListarApiDelegate {

    @Autowired
    ClienteService clienteService;
    public  ResponseEntity<List<ClienteResponse>> listarClientes() {
       List<ClienteResponse> clienteResponses= clienteService.listarClientes();
        if (clienteResponses.isEmpty()) {
            return new ResponseEntity<>(clienteResponses, HttpStatus.OK); //
        }

        return new ResponseEntity<>(clienteResponses, HttpStatus.OK); // Devuelve 200 con la lista de ClienteModel
    }


}
