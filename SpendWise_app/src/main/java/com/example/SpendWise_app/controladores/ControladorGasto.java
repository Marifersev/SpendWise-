package com.example.SpendWise_app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpendWise_app.modelos.Gastos;
import com.example.SpendWise_app.servicio.GastoServicio;



@RestController
@RequestMapping("/apineoapp/v1/gastos")
public class ControladorGasto {
    @Autowired
    GastoServicio servicio;

    public ResponseEntity <?> controladorGuardar(@RequestBody Gastos datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar(datos)
        );
    }

    public ResponseEntity <?> controladorListar(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_gastos()
        );
    }
}
