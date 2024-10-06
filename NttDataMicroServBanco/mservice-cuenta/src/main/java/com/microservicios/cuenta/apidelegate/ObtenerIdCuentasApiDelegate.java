package com.microservicios.cuenta.apidelegate;

import com.microservicios.cuenta.api.IdApiDelegate;
import com.microservicios.cuenta.business.CuentaService;
import com.microservicios.cuenta.model.CuentaResponse;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ObtenerIdCuentasApiDelegate implements IdApiDelegate {

    @Autowired
    CuentaService cuentaService;

    public ResponseEntity<CuentaResponse> obtenerCuentaPorId(@ApiParam(value = "ID de la cuenta a obtener.", required = true) @PathVariable("id") Integer id) {
        CuentaResponse cuentaResponse= cuentaService.obtenerCuentaPorId(Long.valueOf(id));
        return new ResponseEntity<>(cuentaResponse, HttpStatus.OK);
    }

}
