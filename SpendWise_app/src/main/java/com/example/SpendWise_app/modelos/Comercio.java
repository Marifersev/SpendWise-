package com.example.SpendWise_app.modelos;

public class Comercio {
    //id,nit,nombre,actividad,contacto(correo)

    private Integer id;
    private Integer nit;
    private String nombre;
    private String actividad;
    private String contacto;
   
    public Comercio() {
    }

    public Comercio(Integer id, Integer nit, String nombre, String actividad, String contacto) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.actividad = actividad;
        this.contacto = contacto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    } 

}
