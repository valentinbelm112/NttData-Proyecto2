package com.microservicios.cuenta.apidelegate;

import com.microservicios.cuenta.api.ClienteApi;
import com.microservicios.cuenta.api.ClienteApiDelegate;
import com.microservicios.cuenta.business.CuentaService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ValidarEstadoCuentaCliApiDelegate implements ClienteApiDelegate {
    @Autowired
    CuentaService cuentaService;

    public  ResponseEntity<Boolean> verificarCuentasActivas(@ApiParam(value = "ID del cliente a verificar.",required=true) @PathVariable("clienteId") Integer clienteId) {
        Boolean estadoBoleano=cuentaService.verificarCuenta(Long.valueOf(clienteId));
        // Devuelve el estado como respuesta
        return ResponseEntity.ok(estadoBoleano);
    }
}
