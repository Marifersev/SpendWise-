package com.example.SpendWise_app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpendWise_app.modelos.Comercio;
import com.example.SpendWise_app.servicio.ComercioServicio;



@RestController
@RequestMapping("/apispendwiseapp/v1/comercios")
public class ControladorComercio {
    @Autowired
    ComercioServicio servicio;

    @PostMapping
    public ResponseEntity <?> controladorGuardar(@RequestBody Comercio datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar(datos)
        );
    }

    @GetMapping
    public ResponseEntity <?> controladorListar(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_comercios()
        );
    }

    //control para modificar
    @PutMapping("/{id}")
    public ResponseEntity <?> controladorModificar(@PathVariable Integer id, @RequestBody Comercio datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.modificar_comercio(id,datos)
        );
    }

    //control para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity <?> controladorEliminar(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.eliminar_comercio(id)
        );
    }

    //control para buscar por id
    @GetMapping("/{id}") 
    public ResponseEntity <?> controladorBuscar(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.buscar_comercio_por_id(id)
        );
    }
}
