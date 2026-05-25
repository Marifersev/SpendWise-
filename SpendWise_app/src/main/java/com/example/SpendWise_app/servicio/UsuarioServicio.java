package com.example.SpendWise_app.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.SpendWise_app.modelos.Usuario;
import com.example.SpendWise_app.repositorio.IUsuarioRepositorio;


@Service
public class UsuarioServicio {

    //Inyectando la dependencia al repositorio Usuario
    @Autowired
    private IUsuarioRepositorio repositorio;

    //Se programa una funcion por cada servicio que voy a ofrecer


    //funcion para guardar un usuario
    public Usuario guardar_usuario(Usuario datosUsuario){
        //validar los campos del modelo segun la LN

        //validar que el usuario me mande sus nombres
        if(datosUsuario.getNombre()==null || datosUsuario.getNombre().isEmpty() || datosUsuario.getNombre().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el nombre de usuario es obligatorio"
            );

        }

        //valdiar documento tenga al menos 6 caracteres
        if(datosUsuario.getDocumento().length()<6){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el documento debe tener mas de 6 caracteres"
            );

        }

        //Si paso todas las validaciones
        //intentare activar el guardado de los datos
        return repositorio.save(datosUsuario);

    }

    //funcion para listar todos los usuarios

    public List<Usuario> listar_usuarios(){
        return repositorio.findAll();
    }

    //funcion para modificar un usuario
    public Usuario modificar_usuario(Integer id, Usuario datosNuevos){
        Optional<Usuario> usuario_que_busco=repositorio.findById(id);
        if (usuario_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Usuario no encontrado"
            );
        }else{
            Usuario usuario_encontrado=usuario_que_busco.get();
            usuario_encontrado.setNombre(datosNuevos.getNombre());
            usuario_encontrado.setTipodocu(datosNuevos.getTipodocu());
            return repositorio.save(usuario_encontrado);
        }
    }

    //funcion para eliminar un usuario
    public boolean eliminar_usuario(Integer id){
        Optional<Usuario> usuario_que_busco=repositorio.findById(id);
        if (usuario_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Usuario no encontrado"
            );
        }else{
            repositorio.deleteById(id);
            return true;
        }
    }

    //funcion para buscar un usuario por id
    public Usuario buscar_usuario_por_id(Integer id){
        Optional<Usuario> usuario_que_busco=repositorio.findById(id);
        if (usuario_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Usuario no encontrado"
            );
        }else{
            return usuario_que_busco.get();
        }
    }


}
