package com.microservicios.transaccion.apidelegate;

import com.microservicios.transaccion.api.CrearApiDelegate;
import com.microservicios.transaccion.business.TransaccionService;
import com.microservicios.transaccion.model.TransaccionRequest;
import com.microservicios.transaccion.model.TransaccionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CrearTransaccionApiDelegate implements CrearApiDelegate {
    @Autowired
    TransaccionService transaccionService;
    public  ResponseEntity<TransaccionResponse> crearTransaccion(TransaccionRequest transaccionRequest) {
        TransaccionResponse transaccionResponse=transaccionService.crearTransaccion(transaccionRequest);
        return ResponseEntity.ok(transaccionResponse);
    }
}
