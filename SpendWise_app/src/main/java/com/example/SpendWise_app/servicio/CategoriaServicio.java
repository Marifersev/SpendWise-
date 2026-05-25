package com.example.SpendWise_app.servicio;

import java.util.List;
import java.util.Optional;

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

    public Categoria modificar_categoria(Integer id, Categoria datosNuevos){
        Optional<Categoria> categoria_que_busco=repositorio.findById(id);
        if (categoria_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Categoria no encontrado"
            );
        }else{
            Categoria categoria_encontrado=categoria_que_busco.get();
            categoria_encontrado.setFechacreacion(datosNuevos.getFechacreacion());
            categoria_encontrado.setTipo(datosNuevos.getTipo());
            return repositorio.save(categoria_encontrado);
        }
    }

    public boolean eliminar_categoria(Integer id){
        Optional<Categoria> categoria_que_busco=repositorio.findById(id);
        if (categoria_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Categoria no encontrado"
            );
        }else{
            repositorio.deleteById(id);
            return true;
        }
    }

    public Categoria buscar_categoria_por_id(Integer id){
        Optional<Categoria> categoria_que_busco=repositorio.findById(id);
        if (categoria_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Categoria no encontrado"
            );
        }else{
            return categoria_que_busco.get();
        }
    }
}
