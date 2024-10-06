package com.microservicios.transaccion.mapper;

import com.microservicios.transaccion.entity.Deposito;
import com.microservicios.transaccion.entity.Retiro;
import com.microservicios.transaccion.entity.Transaccion;
import com.microservicios.transaccion.model.TransaccionRequest;
import com.microservicios.transaccion.model.TransaccionResponse;
import org.springframework.stereotype.Component;

@Component
public class TransaccionMapperRequest {
    public static Transaccion transaccionmapperofTransaccionRequest(TransaccionRequest transaccionRequest) {
        Transaccion transaccion;

        // Verificar el tipo de transacción
        if ("deposito".equalsIgnoreCase(transaccionRequest.getTipo())) {
            // Crear una instancia de Deposito
            Deposito deposito = new Deposito();
            deposito.setNumTransaccion(transaccionRequest.getNumTransaccion());
            deposito.setNumCuenta(transaccionRequest.getNumCuenta());
            deposito.setMonto(transaccionRequest.getMonto());
            deposito.setOdeposito(transaccionRequest.getOdeposito());
            // Asigna otros atributos específicos de Deposito si es necesario
            transaccion = deposito;
        } else if ("retiro".equalsIgnoreCase(transaccionRequest.getTipo())) {
            // Crear una instancia de Retiro
            Retiro retiro = new Retiro();
            retiro.setNumTransaccion(transaccionRequest.getNumTransaccion());
            retiro.setNumCuenta(transaccionRequest.getNumCuenta());
            retiro.setMonto(transaccionRequest.getMonto());
            retiro.setComision(transaccionRequest.getComision());
            // Asigna otros atributos específicos de Retiro si es necesario
            transaccion = retiro;
        } else {
            throw new IllegalArgumentException("Tipo de transacción desconocido: " + transaccionRequest.getTipo());
        }

        return transaccion;
    }


    public static TransaccionResponse transaccionmapperofTransaccionRequest(Transaccion transaccion) {

        if (transaccion == null) {
            return null;
        }

        TransaccionResponse response = new TransaccionResponse();

        response.setId(Math.toIntExact(transaccion.getId()));
        response.setNumTransaccion(transaccion.getNumTransaccion());
        response.setNumCuenta(transaccion.getNumCuenta());
        response.setMonto(transaccion.getMonto());

        if (transaccion instanceof Retiro) {
            response.setTipo("retiro");
            Retiro deposito = (Retiro) transaccion;
            response.setComision(deposito.getComision());

        } else if (transaccion instanceof Deposito) {
            response.setTipo("deposito");

            Deposito deposito = (Deposito) transaccion;
            response.setOdeposito(deposito.getOdeposito());

        }

        return response;
    }
}
