package com.example.SpendWise_app.modelos;

public class MedioPago {
     //id,nombre,franquicia,estado(activo/inactivo)
    private Integer id;
    private String nombre;
    private String franquicia;
    private String estado;
    
    public MedioPago() {
    }

    public MedioPago(Integer id, String nombre, String franquicia, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.franquicia = franquicia;
        this.estado = estado;
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

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
