package com.example.SpendWise_app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpendWise_app.modelos.Usuario;
import com.example.SpendWise_app.servicio.UsuarioServicio;



@RestController
@RequestMapping("/apineoapp/v1/usuarios")
public class ControladorUsuario {

    @Autowired
    UsuarioServicio servicio;

    //por cada servicio programa un metodo, para recibir y enviar respuestas al cliente 

    //funcion controladora para el servicio de guardar usuario
    public ResponseEntity <?> controladorGuardar(@RequestBody Usuario datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_usuario(datos)
        );
    }

    //funcion controladora para el servicio de listar todos los usuarios
    public ResponseEntity <?> controladorListar(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_usuarios()
        );
    }
    
}
