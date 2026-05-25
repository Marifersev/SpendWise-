package com.example.SpendWise_app.servicio;

import java.util.List;
import java.util.Optional;

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

    public MedioPago modificar_medioPago(Integer id, MedioPago datosNuevos){
        Optional<MedioPago> medioPago_que_busco=repositorio.findById(id);
        if (medioPago_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Medio de pago no encontrado"
            );
        }else{
            MedioPago medioPago_encontrado=medioPago_que_busco.get();
            medioPago_encontrado.setEstado(datosNuevos.getEstado());
            medioPago_encontrado.setFranquicia(datosNuevos.getFranquicia());
            return repositorio.save(medioPago_encontrado);
        }
    }

    public boolean eliminar_medioPago(Integer id){
        Optional<MedioPago> medioPago_que_busco=repositorio.findById(id);
        if ( medioPago_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Medio de pago no encontrado"
            );
        }else{
            repositorio.deleteById(id);
            return true;
        }
    }

    public MedioPago buscar_medioPago_por_id(Integer id){
        Optional<MedioPago> medioPago_que_busco=repositorio.findById(id);
        if (medioPago_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Medio de pago no encontrado"
            );
        }else{
            return medioPago_que_busco.get();
        }
    }
}
