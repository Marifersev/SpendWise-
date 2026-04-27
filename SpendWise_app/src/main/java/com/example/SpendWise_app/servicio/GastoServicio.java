package com.example.SpendWise_app.servicio;

import java.util.List;

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
}
