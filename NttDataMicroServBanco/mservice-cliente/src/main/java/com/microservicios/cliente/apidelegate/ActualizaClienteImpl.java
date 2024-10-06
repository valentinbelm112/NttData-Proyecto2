package com.microservicios.cliente.apidelegate;

import com.microservicios.cliente.api.ActualizarApiDelegate;
import com.microservicios.cliente.business.ClienteService;
import com.microservicios.cliente.model.ClienteRequest;
import com.microservicios.cliente.model.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ActualizaClienteImpl implements ActualizarApiDelegate {
  @Autowired
    ClienteService clienteService;

    public  ResponseEntity<ClienteResponse> actualizarCliente(Integer id,
                                                              ClienteRequest clienteRequest) {
      ClienteResponse clienteResponse=  clienteService.actualizarCliente(Long.valueOf(id),clienteRequest);
        return new ResponseEntity<>(clienteResponse, HttpStatus.OK);
    }

}
