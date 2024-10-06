package com.microservicios.cliente.mapper;

import com.microservicios.cliente.entity.ClienteEntity;
import com.microservicios.cliente.model.ClienteRequest;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapperRequest {

    public static  ClienteEntity ClienteEntityMapperofClientesRequest(ClienteRequest clienteRequest){
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNombre(clienteRequest.getNombre());
        clienteEntity.setApellido(clienteRequest.getApellido());
        clienteEntity.setDni(clienteRequest.getDni());
        clienteEntity.setEmail(clienteRequest.getEmail());
        clienteEntity.setTelefono(clienteRequest.getTelefono());
        clienteEntity.setDireccion(clienteRequest.getDireccion());
        return clienteEntity;
    }
}
