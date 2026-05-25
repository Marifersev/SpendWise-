package com.example.SpendWise_app.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.SpendWise_app.modelos.Gastos;
import com.example.SpendWise_app.repositorio.IGastoRepositorio;



@Service
public class GastoServicio {
    @Autowired
    private IGastoRepositorio repositorio;

    public Gastos guardar(Gastos datosGastos){
        if(datosGastos.getDescripcion() == null || datosGastos.getDescripcion() .isBlank() ||  datosGastos.getDescripcion() .isEmpty() ){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre es obligatorio"
            );
        }

        if(datosGastos.getValor() <= 0){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el valor no debe estar vacido"
            );

        }


        return repositorio.save(datosGastos);
    }

    public List<Gastos> listar_gastos(){
        return repositorio.findAll();
    }

    public Gastos modificar_gasto(Integer id, Gastos datosNuevos){
        Optional<Gastos> gasto_que_busco=repositorio.findById(id);
        if (gasto_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Gasto no encontrado"
            );
        }else{
            Gastos gasto_encontrado=gasto_que_busco.get();
            gasto_encontrado.setFecha(datosNuevos.getFecha());
            gasto_encontrado.setCantidad(datosNuevos.getCantidad());
            return repositorio.save(gasto_encontrado);
        }
    }

    public boolean eliminar_gasto(Integer id){
        Optional<Gastos> gasto_que_busco=repositorio.findById(id);
        if (gasto_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Gasto no encontrado"
            );
        }else{
            repositorio.deleteById(id);
            return true;
        }
    }

    public Gastos buscar_gasto_por_id(Integer id){
        Optional<Gastos> gasto_que_busco=repositorio.findById(id);
        if (gasto_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Gasto no encontrado"
            );
        }else{
            return gasto_que_busco.get();
        }
    }
}
