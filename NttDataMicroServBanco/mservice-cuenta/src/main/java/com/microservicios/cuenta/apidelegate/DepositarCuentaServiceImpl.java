package com.microservicios.cuenta.apidelegate;

import com.microservicios.cuenta.api.CuentaIdApiDelegate;
import com.microservicios.cuenta.business.CuentaService;
import com.microservicios.cuenta.model.CuentaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepositarCuentaServiceImpl implements CuentaIdApiDelegate {

    @Autowired
    CuentaService cuentaService;

    public  ResponseEntity<CuentaResponse> depositar(Integer cuentaId,
                                                     Double monto) {
        CuentaResponse cuentaResponse=cuentaService.depositar(Long.valueOf(cuentaId),monto);
        return new ResponseEntity<>(cuentaResponse, HttpStatus.OK);
    }


    public  ResponseEntity<CuentaResponse> retirar(Integer cuentaId,
                                                   Double monto) {
        CuentaResponse cuentaResponse=cuentaService.retirar(Long.valueOf(cuentaId),monto);
        return new ResponseEntity<>(cuentaResponse, HttpStatus.OK);
    }

}
