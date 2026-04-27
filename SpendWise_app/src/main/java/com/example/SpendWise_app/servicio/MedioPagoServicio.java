package com.example.SpendWise_app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.SpendWise_app.modelos.MedioPago;
import com.example.SpendWise_app.repositorio.IMedioPagoRepositorio;

@Service
public class MedioPagoServicio {
    @Autowired
    IMedioPagoRepositorio repositorio;

    public MedioPago guardar(MedioPago datosMedio_Pago){

        if(datosMedio_Pago.getNombre() == null || datosMedio_Pago.getNombre().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del medio de pago es obligatorio"
            );
        }

        if(datosMedio_Pago.getEstado() == null ){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El estado es obligatorio"
            );
        }

        return repositorio.save(datosMedio_Pago);
    }

    public List<MedioPago> listar_medio_pago(){
        return repositorio.findAll();
    }
}
