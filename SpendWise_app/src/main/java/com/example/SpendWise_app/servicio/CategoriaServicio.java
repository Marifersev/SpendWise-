package com.example.SpendWise_app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.SpendWise_app.modelos.Categoria;
import com.example.SpendWise_app.repositorio.ICategoriaRepositorio;

@Service
public class CategoriaServicio {
    
    @Autowired
    private ICategoriaRepositorio repositorio;

    public Categoria guardar(Categoria datosCategoria){
        if(datosCategoria.getNombre() == null || datosCategoria.getNombre().isBlank() ||  datosCategoria.getNombre().isEmpty() ){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre es obligatorio"
            );
        }

        if(datosCategoria.getTipo() == null ){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El Tipo de categoria es obligatorio"
            );
        }


        return repositorio.save(datosCategoria);
    }

    public List<Categoria> listar_categorias(){
        return repositorio.findAll();
    }
}
