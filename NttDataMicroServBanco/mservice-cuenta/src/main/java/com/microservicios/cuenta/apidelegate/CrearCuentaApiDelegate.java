package com.microservicios.cuenta.apidelegate;

import com.microservicios.cuenta.api.CrearApiDelegate;
import com.microservicios.cuenta.business.CuentaService;
import com.microservicios.cuenta.model.CuentaRequest;
import com.microservicios.cuenta.model.CuentaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CrearCuentaApiDelegate implements CrearApiDelegate {
    @Autowired
    CuentaService cuentaService;

    public ResponseEntity<CuentaResponse> crearCuenta(CuentaRequest cuentaRequest) {
        CuentaResponse cuentaResponse=cuentaService.crearCuenta(cuentaRequest);
        return new ResponseEntity<>(cuentaResponse, HttpStatus.CREATED);

    }

}