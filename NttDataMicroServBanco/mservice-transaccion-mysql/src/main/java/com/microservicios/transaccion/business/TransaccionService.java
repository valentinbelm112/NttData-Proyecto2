package com.microservicios.transaccion.business;

import com.microservicios.transaccion.entity.Transaccion;
import com.microservicios.transaccion.model.TransaccionRequest;
import com.microservicios.transaccion.model.TransaccionResponse;

import java.util.List;

public interface TransaccionService {
    TransaccionResponse crearTransaccion(TransaccionRequest transaccion);

    String  generarNumeroCuentaUnico();

}
