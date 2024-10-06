package com.nttdata.mservice_transaccion.mapper;


import com.nttdata.mservice_transaccion.model.DepositoRequest;
import com.nttdata.mservice_transaccion.model.RetiroRequest;
import com.nttdata.mservice_transaccion.model.Transaccion;
import com.nttdata.mservice_transaccion.model.TransferenciaRequest;
import org.springframework.stereotype.Component;


import java.time.LocalDate;


@Component
public class TransferenciaMapperRequest {

    public static Transaccion getTransaccionofRetiroRequest(RetiroRequest retiroRequest){
        Transaccion transaccion = new Transaccion();

        transaccion.setTipo("Retiro");
        transaccion.setCuentaOrigen(retiroRequest.getCuentaOrigen());
        transaccion.setMonto(retiroRequest.getMonto());

        // Almacenar la fecha actual
        LocalDate now = LocalDate.now(); // Obtener la fecha y hora actuales con el offset
        transaccion.setFecha(now);

        return transaccion;
    }

    public static Transaccion getTransaccionofDepositoRequest(DepositoRequest retiroRequest){
        Transaccion transaccion = new Transaccion();

        transaccion.setTipo("Deposito");
        transaccion.setCuentaOrigen(retiroRequest.getCuentaOrigen());
        transaccion.setMonto(retiroRequest.getMonto());

        // Almacenar la fecha actual
        LocalDate now = LocalDate.now(); // Obtener la fecha y hora actuales con el offset
        transaccion.setFecha(now);

        return transaccion;
    }

    public static Transaccion getTransaccionofTranferenciaRequest(TransferenciaRequest transferenciaRequest){
        Transaccion transaccion = new Transaccion();

        transaccion.setTipo("Transferencia");
        transaccion.setCuentaOrigen(transferenciaRequest.getCuentaOrigen());
        transaccion.setMonto(transferenciaRequest.getMonto());
        transaccion.setCuentaDestino(transferenciaRequest.getCuentaDestino());
        // Almacenar la fecha actual
        LocalDate now = LocalDate.now(); // Obtener la fecha y hora actuales con el offset
        transaccion.setFecha(now);

        return transaccion;
    }



}
