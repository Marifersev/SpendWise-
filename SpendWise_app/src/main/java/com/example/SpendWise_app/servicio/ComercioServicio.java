package com.example.SpendWise_app.servicio;

import java.util.List;
import java.util.Optional;

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

    public Comercio modificar_comercio(Integer id, Comercio datosNuevos){
        Optional<Comercio> comercio_que_busco=repositorio.findById(id);
        if (comercio_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Comercio no encontrado"
            );
        }else{
            Comercio comercio_encontrado=comercio_que_busco.get();
            comercio_encontrado.setContacto(datosNuevos.getContacto());
            comercio_encontrado.setTipo_de_comercio(datosNuevos.getTipo_de_comercio());
            return repositorio.save(comercio_encontrado);
        }
    }

    public boolean eliminar_comercio(Integer id){
        Optional<Comercio> comercio_que_busco=repositorio.findById(id);
        if (comercio_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Comercio no encontrado"
            );
        }else{
            repositorio.deleteById(id);
            return true;
        }
    }

    public Comercio buscar_comercio_por_id(Integer id){
        Optional<Comercio> comercio_que_busco=repositorio.findById(id);
        if (comercio_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Comercio no encontrado"
            );
        }else{
            return comercio_que_busco.get();
        }
    }
}
