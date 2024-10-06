package com.nttdata.mservice_transaccion.business;

import com.nttdata.mservice_transaccion.model.DepositoRequest;
import com.nttdata.mservice_transaccion.model.RetiroRequest;
import com.nttdata.mservice_transaccion.model.TransaccionResponse;
import com.nttdata.mservice_transaccion.model.TransferenciaRequest;

import java.util.List;

public interface TransaccionService {
    public TransaccionResponse registrarDeposito(DepositoRequest deposito);
    public TransaccionResponse registrarRetiro(RetiroRequest retiro);
    public TransaccionResponse registrarTransferencia(TransferenciaRequest transferencia);
    public List<TransaccionResponse> consultarHistorialtransacciones();
}
