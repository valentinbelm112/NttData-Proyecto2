package com.microservicios.cuenta.apidelegate;


import com.microservicios.cuenta.api.NumeroCuentaApiDelegate;
import com.microservicios.cuenta.business.CuentaService;
import com.microservicios.cuenta.model.CuentaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ObtenerCuentaNumCuDelegate implements NumeroCuentaApiDelegate {

    @Autowired
    CuentaService cuentaService;
    public ResponseEntity<CuentaResponse> obtenerCuentaPorNumCuenta(String numCuenta) {

           CuentaResponse cuentaResponse=cuentaService.obtenerCuentaPorNumCuenta(numCuenta);

        return new ResponseEntity<>(cuentaResponse, HttpStatus.OK);
    }
}
