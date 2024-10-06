package com.microservicios.cuenta.mapper;

import com.microservicios.cuenta.entity.CuentaEntity;
import com.microservicios.cuenta.model.CuentaResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CuentaMapperEntity {

    public static CuentaResponse getCuentaResponseofCuentaEntity( CuentaEntity cuentaEntity){
        CuentaResponse cuentaResponse = new CuentaResponse();

        cuentaResponse.setId(Math.toIntExact(cuentaEntity.getId()));
        cuentaResponse.setNumeroCuenta(cuentaEntity.getNumeroCuenta());
        cuentaResponse.setSaldo(cuentaEntity.getSaldo());
        cuentaResponse.setTipoCuenta(CuentaResponse.TipoCuentaEnum.valueOf(cuentaEntity.getTipoCuenta().name()));
        cuentaResponse.setEstadoCuenta(CuentaResponse.EstadoCuentaEnum.valueOf(cuentaEntity.getTipoestado().name()));
        cuentaResponse.setClienteId(Math.toIntExact(cuentaEntity.getClienteId()));
        return cuentaResponse;
    }

    public static List<CuentaResponse> getCuentaArrayEntityofCuentaArrayResponse(List<CuentaEntity> cuentaEntities){

        List<CuentaResponse> clienteModels = cuentaEntities.stream()
                .map(cuentaEntity -> {
                    CuentaResponse cuentaModel = new CuentaResponse();
                    cuentaModel.setId(Math.toIntExact(cuentaEntity.getId()));
                    cuentaModel.setNumeroCuenta(cuentaEntity.getNumeroCuenta());
                    cuentaModel.setSaldo(cuentaEntity.getSaldo());
                    cuentaModel.setTipoCuenta(CuentaResponse.TipoCuentaEnum.valueOf(cuentaEntity.getTipoCuenta().name()));
                    cuentaModel.setEstadoCuenta(CuentaResponse.EstadoCuentaEnum.valueOf(cuentaEntity.getTipoestado().name()));
                    cuentaModel.setClienteId(Math.toIntExact(cuentaEntity.getClienteId()));
                    return cuentaModel; // Retornar el objeto ClienteModel
                })
                .collect(Collectors.toList()); // Recoger en una lista

        return clienteModels;
    }
}
