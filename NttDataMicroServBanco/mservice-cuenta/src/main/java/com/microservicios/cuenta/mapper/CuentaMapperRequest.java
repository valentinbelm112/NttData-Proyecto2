package com.microservicios.cuenta.mapper;

import com.microservicios.cuenta.entity.CuentaEntity;
import com.microservicios.cuenta.entity.TipoCuenta;
import com.microservicios.cuenta.entity.TipoEstado;
import com.microservicios.cuenta.model.CuentaRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CuentaMapperRequest {

    public static CuentaEntity getCuentaEntityofCuentaResponse(CuentaRequest cuentaRequest){
        CuentaEntity cuentaEntity = new CuentaEntity();

        cuentaEntity.setNumeroCuenta(cuentaRequest.getNumeroCuenta());
        cuentaEntity.setSaldo(cuentaRequest.getSaldo());
        cuentaEntity.setTipoCuenta(TipoCuenta.valueOf(cuentaRequest.getTipoCuenta().name()));
        cuentaEntity.setTipoestado(TipoEstado.valueOf(cuentaRequest.getEstadoCuenta().name()));
        cuentaEntity.setClienteId(Long.valueOf(cuentaRequest.getClienteId()));
        return cuentaEntity;
    }



}
