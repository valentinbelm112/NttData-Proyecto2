package com.microservicios.cuenta.apidelegate;

import com.microservicios.cuenta.api.ListarApiDelegate;
import com.microservicios.cuenta.business.CuentaService;
import com.microservicios.cuenta.model.CuentaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerCuentasServiceImpl implements ListarApiDelegate {

    @Autowired
    CuentaService cuentaService;

    public  ResponseEntity<List<CuentaResponse>> listarCuentas() {

         List<CuentaResponse> cuentaResponses=cuentaService.obtenerTodasLasCuentas();
        // Verificar si la lista de ClienteModel está vacía
        if (cuentaResponses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Devuelve 204 si la lista está vacía
        }

        return new ResponseEntity<>(cuentaResponses, HttpStatus.OK); // Devuelve 200 con la lista de ClienteModel

    }



}
