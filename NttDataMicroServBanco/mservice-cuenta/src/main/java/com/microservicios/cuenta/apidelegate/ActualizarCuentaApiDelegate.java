package com.microservicios.cuenta.apidelegate;

import com.microservicios.cuenta.api.ActualizarApiDelegate;
import com.microservicios.cuenta.api.ApiUtil;
import com.microservicios.cuenta.business.CuentaService;
import com.microservicios.cuenta.model.CuentaRequest;
import com.microservicios.cuenta.model.CuentaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ActualizarCuentaApiDelegate implements ActualizarApiDelegate {

    @Autowired
    CuentaService cuentaService;
    public  ResponseEntity<CuentaResponse> actualizarCuenta(Integer id,
                                                            CuentaRequest cuentaRequest) {

        CuentaResponse cuentaResponse=cuentaService.ActualizaCuenta(id,cuentaRequest);
        return new ResponseEntity<>(cuentaResponse, HttpStatus.CREATED);

    }
}
