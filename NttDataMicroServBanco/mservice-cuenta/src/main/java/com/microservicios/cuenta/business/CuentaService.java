package com.microservicios.cuenta.business;

import com.microservicios.cuenta.model.CuentaRequest;
import com.microservicios.cuenta.model.CuentaResponse;
import java.util.List;

public interface CuentaService {
    CuentaResponse crearCuenta(CuentaRequest cuenta);
    CuentaResponse obtenerCuentaPorId(Long id);
    List<CuentaResponse> obtenerTodasLasCuentas();
    void eliminarCuenta(Long id);
    CuentaResponse depositar(Long cuentaId, Double monto);
    CuentaResponse retirar(Long cuentaId, Double monto);
    boolean verificarCuenta(Long clienteId);
    CuentaResponse obtenerCuentaPorNumCuenta(String numCuenta);
    CuentaResponse ActualizaCuenta(Integer id, CuentaRequest cuentaRequest);
}
