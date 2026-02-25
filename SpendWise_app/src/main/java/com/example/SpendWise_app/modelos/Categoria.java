package com.example.SpendWise_app.modelos;

import java.time.LocalDate;

public class Categoria {
    //id, nombre, fechaCreacion, responsable, justificacion

    private Integer id;
    private String nombre;
    private LocalDate fechacreacion;
    private String responsable;
    private String justificacion;
    
    public Categoria() {
    }

    public Categoria(Integer id, String nombre, LocalDate fechacreacion, String responsable, String justificacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechacreacion = fechacreacion;
        this.responsable = responsable;
        this.justificacion = justificacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(LocalDate fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

}
