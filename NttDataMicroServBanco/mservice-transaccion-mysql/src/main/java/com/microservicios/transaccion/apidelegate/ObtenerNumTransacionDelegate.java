package com.microservicios.transaccion.apidelegate;

import com.microservicios.transaccion.api.ObtenerApiDelegate;
import com.microservicios.transaccion.business.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ObtenerNumTransacionDelegate implements ObtenerApiDelegate {

    @Autowired
    TransaccionService transaccionService;
    public ResponseEntity<String> obtenerNumeroTransaccion() {
        String numeroCuenta = transaccionService.generarNumeroCuentaUnico();
        return ResponseEntity.ok( numeroCuenta);
    }
}
