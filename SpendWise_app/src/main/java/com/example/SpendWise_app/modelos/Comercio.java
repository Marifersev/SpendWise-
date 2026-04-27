package com.example.SpendWise_app.modelos;

import com.example.SpendWise_app.modelos.utils.TipoComercio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "comercio")
public class Comercio {
    //id,nit,nombre,actividad,contacto(correo)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nit", nullable = false, unique = true)
    private Integer nit;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "actividad")
    private String actividad;
    @Column(name = "contacto")
    private String contacto;
  //-----------------------------

    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "sitio web")
    private String sitio_web;
    @Column(name = "tipo de comercio")
    @Enumerated(EnumType.STRING)
    private TipoComercio tipo_de_comercio;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "correo")
    private String correo;

    @ManyToOne
    @JoinColumn(name = "fk_gasto_id", referencedColumnName = "id")
    private Gastos gasto;

    public Comercio() {
    }


    public Comercio(Integer id, Integer nit, String nombre, String actividad, String contacto, String ciudad,
            String sitio_web, TipoComercio tipo_de_comercio, Integer telefono, String correo) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.actividad = actividad;
        this.contacto = contacto;
        this.ciudad = ciudad;
        this.sitio_web = sitio_web;
        this.tipo_de_comercio = tipo_de_comercio;
        this.telefono = telefono;
        this.correo = correo;
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


    public String getCiudad() {
        return ciudad;
    }


    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    public String getSitio_web() {
        return sitio_web;
    }


    public void setSitio_web(String sitio_web) {
        this.sitio_web = sitio_web;
    }


    public TipoComercio getTipo_de_comercio() {
        return tipo_de_comercio;
    }


    public void setTipo_de_comercio(TipoComercio tipo_de_comercio) {
        this.tipo_de_comercio = tipo_de_comercio;
    }


    public Integer getTelefono() {
        return telefono;
    }


    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    } 

    
    // @OneToMany(mappedBy = "comercio")
    // private List<Gastos> gastos;

}
