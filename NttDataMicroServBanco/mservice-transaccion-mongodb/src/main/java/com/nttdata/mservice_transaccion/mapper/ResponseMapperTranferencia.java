package com.nttdata.mservice_transaccion.mapper;


import com.nttdata.mservice_transaccion.model.Transaccion;
import com.nttdata.mservice_transaccion.model.TransaccionResponse;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResponseMapperTranferencia {

    public static TransaccionResponse getTransaccionoResponseofTransaccion(Transaccion transaccion){
        TransaccionResponse transaccionResponse = new TransaccionResponse();

        transaccionResponse.setTipo(transaccion.getTipo());
        transaccionResponse.setCuentaOrigen(transaccion.getCuentaOrigen());
        transaccionResponse.setMonto(transaccion.getMonto());
        transaccionResponse.setId(transaccion.getId());
        transaccionResponse.setFecha(transaccion.getFecha());
        transaccionResponse.setCuentaDestino(transaccion.getCuentaDestino());

        return transaccionResponse;
    }

    public static List<TransaccionResponse> getTransaccionResponseArrayofTransaccionArray(List<Transaccion> transaccions){
        List<TransaccionResponse> clienteModels = transaccions.stream()
                .map(transaccion -> {
                    TransaccionResponse transaccionResponse = new TransaccionResponse();
                    transaccionResponse.setId(transaccion.getId());
                    transaccionResponse.setTipo(transaccion.getTipo());
                    transaccionResponse.setCuentaOrigen(transaccion.getCuentaOrigen());
                    transaccionResponse.setMonto(transaccion.getMonto());
                    transaccionResponse.setFecha(transaccion.getFecha());
                    transaccionResponse.setCuentaDestino(transaccion.getCuentaDestino());

                    return transaccionResponse; // Retornar el objeto ClienteModel
                })
                .collect(Collectors.toList()); // Recoger en una lista
        return clienteModels;
    }


}
