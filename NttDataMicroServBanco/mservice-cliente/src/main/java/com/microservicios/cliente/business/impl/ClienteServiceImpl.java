package com.microservicios.cliente.business.impl;

import com.microservicios.cliente.business.ClienteService;
import com.microservicios.cliente.business.Externo.TransaccionServiceClient;
import com.microservicios.cliente.entity.ClienteEntity;
import com.microservicios.cliente.mapper.ClienteMapperEntity;
import com.microservicios.cliente.mapper.ClienteMapperRequest;
import com.microservicios.cliente.model.ClienteRequest;
import com.microservicios.cliente.model.ClienteResponse;
import com.microservicios.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.microservicios.cliente.mapper.ClienteMapperEntity.getCuentaArrayEntityofCuentaArrayResponse;
import static com.microservicios.cliente.util.clientUtil.clienteNoEncontrado;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    TransaccionServiceClient transaccionServiceClient;

    @Override
    public ClienteResponse crearCliente(ClienteRequest cliente) {
        ClienteEntity clienteEntity= Optional.of(ClienteMapperRequest.ClienteEntityMapperofClientesRequest(cliente))
                .map(clienteRepository::save)
                .orElseThrow(() -> new IllegalArgumentException("Error al crear la cuenta"));

        return ClienteMapperEntity.ClienteresponseMapperofClienteEntity(clienteEntity);

    }

    @Override
    public List<ClienteResponse> listarClientes() {
        List<ClienteEntity> clienteEntities= clienteRepository.findAll().stream()
                .filter(cliente -> cliente.getId() != null)
                .collect(Collectors.toList());

         return getCuentaArrayEntityofCuentaArrayResponse(clienteEntities);
    }

    @Override
    public ClienteResponse obtenerClientePorId(Long id) {
        ClienteEntity clienteEntity= clienteRepository.findById(Long.valueOf(id))
                .orElseThrow(clienteNoEncontrado(Long.valueOf(id)));
        return ClienteMapperEntity.ClienteresponseMapperofClienteEntity(clienteEntity);
    }

    @Override
    public ClienteResponse actualizarCliente(Long id, ClienteRequest clienteActualizado) {
        ClienteEntity clienteEntity= clienteRepository.findById(id)
                .map(clienteExistente -> {
                    clienteExistente.setNombre(clienteActualizado.getNombre());
                    clienteExistente.setApellido(clienteActualizado.getApellido());
                    clienteExistente.setDni(clienteActualizado.getDni());
                    clienteExistente.setEmail(clienteActualizado.getEmail());

                    return clienteRepository.save(clienteExistente);
                })
                .orElseThrow(clienteNoEncontrado(id));

        return ClienteMapperEntity.ClienteresponseMapperofClienteEntity(clienteEntity);
    }

    @Override
    public String eliminarCliente(Long id) {
        if (transaccionServiceClient.validarCuentaActiva(id)) {
            throw new IllegalArgumentException("No se puede eliminar el cliente porque tiene la cuenta activa: " + id);
        } else {
            return Optional.of(id)
                    .filter(clienteRepository::existsById)
                    .map(clienteId -> {
                        clienteRepository.deleteById(clienteId);
                        return "Cliente eliminado con éxito: " + clienteId;
                    })
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + id));
        }
    }
}
