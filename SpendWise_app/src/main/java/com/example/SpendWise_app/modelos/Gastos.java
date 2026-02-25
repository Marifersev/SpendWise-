package com.example.SpendWise_app.modelos;

import java.time.LocalDate;

public class Gastos {
      //id, descripcion, fecha, valor, imagen(icono)

    private Integer id;
    private String descripcion;
    private LocalDate fecha;
    private double valor;
    private String icono;
    
    public Gastos() {
    }

    public Gastos(Integer id, String descripcion, LocalDate fecha, double valor, String icono) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.valor = valor;
        this.icono = icono;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    } 

}
