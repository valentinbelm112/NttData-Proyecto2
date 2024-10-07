package com.nttdata.mservice_transaccion.apidelegate;

import com.nttdata.mservice_transaccion.api.TransaccionesApiDelegate;
import com.nttdata.mservice_transaccion.business.TransaccionService;
import com.nttdata.mservice_transaccion.model.DepositoRequest;
import com.nttdata.mservice_transaccion.model.RetiroRequest;
import com.nttdata.mservice_transaccion.model.TransaccionResponse;
import com.nttdata.mservice_transaccion.model.TransferenciaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionCuentaApiDelegate implements TransaccionesApiDelegate {
    @Autowired
    TransaccionService transaccionService;

    public  ResponseEntity<TransaccionResponse> registrarRetiro(RetiroRequest retiroRequest) {

       TransaccionResponse transaccionResponse= transaccionService.registrarRetiro(retiroRequest);

        return new ResponseEntity<>(transaccionResponse, HttpStatus.CREATED);

    }

    public  ResponseEntity<TransaccionResponse> registrarDeposito(DepositoRequest depositoRequest) {
        TransaccionResponse transaccionResponse= transaccionService.registrarDeposito(depositoRequest);

        return new ResponseEntity<>(transaccionResponse, HttpStatus.CREATED);

    }

    public ResponseEntity<TransaccionResponse> registrarTransferencia(TransferenciaRequest transferenciaRequest) {
        TransaccionResponse transaccionResponse= transaccionService.registrarTransferencia(transferenciaRequest);

        return new ResponseEntity<>(transaccionResponse, HttpStatus.CREATED);

    }

    public  ResponseEntity<List<TransaccionResponse>> consultarHistorialTransacciones() {

        List<TransaccionResponse> transaccionResponses= transaccionService.consultarHistorialtransacciones();
        if (transaccionResponses.isEmpty()) {
            return new ResponseEntity<>(transaccionResponses, HttpStatus.OK); //
        }

        return new ResponseEntity<>(transaccionResponses, HttpStatus.OK); // Devuelve 200 con la lista de ClienteModel
    }
}
