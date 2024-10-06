package com.microservicios.cliente.mapper;

import com.microservicios.cliente.entity.ClienteEntity;
import com.microservicios.cliente.model.ClienteRequest;
import com.microservicios.cliente.model.ClienteResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapperEntity {

    public static ClienteResponse ClienteresponseMapperofClienteEntity(ClienteEntity clienteEntity){
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setId(Math.toIntExact(clienteEntity.getId()));
        clienteResponse.setNombre(clienteEntity.getNombre());
        clienteResponse.setApellido(clienteEntity.getApellido());
        clienteResponse.setDni(clienteEntity.getDni());
        clienteResponse.setEmail(clienteEntity.getEmail());
        clienteResponse.setTelefono(clienteEntity.getTelefono());
        clienteResponse.setDireccion(clienteEntity.getDireccion());
        return clienteResponse;
    }

    public static List<ClienteResponse> getCuentaArrayEntityofCuentaArrayResponse(List<ClienteEntity> cuentaEntities){
        List<ClienteResponse> clienteModels = cuentaEntities.stream()
                .map(clienteEntity -> {
                    ClienteResponse clienteResponse = new ClienteResponse();
                    clienteResponse.setId(Math.toIntExact(clienteEntity.getId()));
                    clienteResponse.setNombre(clienteEntity.getNombre());
                    clienteResponse.setApellido(clienteEntity.getApellido());
                    clienteResponse.setDni(clienteEntity.getDni());
                    clienteResponse.setEmail(clienteEntity.getEmail());
                    clienteResponse.setTelefono(clienteEntity.getTelefono());
                    clienteResponse.setDireccion(clienteEntity.getDireccion());
                    return clienteResponse; // Retornar el objeto ClienteModel
                })
                .collect(Collectors.toList()); // Recoger en una lista
        return clienteModels;
    }
}
