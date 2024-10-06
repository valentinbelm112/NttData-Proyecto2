package com.microservicios.cliente.business;

import com.microservicios.cliente.entity.ClienteEntity;
import com.microservicios.cliente.model.ClienteRequest;
import com.microservicios.cliente.model.ClienteResponse;

import java.util.List;

public interface ClienteService {

    ClienteResponse crearCliente(ClienteRequest cliente);
    List<ClienteResponse> listarClientes();
    ClienteResponse obtenerClientePorId(Long id);
    ClienteResponse actualizarCliente(Long id, ClienteRequest clienteActualizado);
    String eliminarCliente(Long id);
}
