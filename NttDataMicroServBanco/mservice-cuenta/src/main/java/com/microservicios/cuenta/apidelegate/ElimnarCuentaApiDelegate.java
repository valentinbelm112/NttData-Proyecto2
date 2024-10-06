package com.microservicios.cuenta.apidelegate;

import com.microservicios.cuenta.api.EliminarApiDelegate;
import com.microservicios.cuenta.business.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ElimnarCuentaApiDelegate implements EliminarApiDelegate {
    @Autowired
    CuentaService cuentaService;

    public ResponseEntity<Void> eliminarCuenta(Integer id) {
        cuentaService.eliminarCuenta(Long.valueOf(id));


        return ResponseEntity.noContent().build();

    }
}
