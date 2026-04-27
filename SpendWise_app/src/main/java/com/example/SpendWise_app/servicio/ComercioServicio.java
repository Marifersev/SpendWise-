package com.example.SpendWise_app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.SpendWise_app.modelos.Comercio;
import com.example.SpendWise_app.repositorio.IComercioRepositorio;


@Service
public class ComercioServicio {
    @Autowired
    private IComercioRepositorio repositorio;

    public Comercio guardar(Comercio datosComercio){
        if(datosComercio.getNombre() == null || datosComercio.getNombre().isBlank() ||  datosComercio.getNombre().isEmpty() ){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre es obligatorio"
            );
        }

        if(datosComercio.getTipo_de_comercio() == null ){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El Tipo de comercio es obligatorio"
            );
        }


        return repositorio.save(datosComercio);
    }

    public List<Comercio> listar_comercios(){
        return repositorio.findAll();
    }
}
