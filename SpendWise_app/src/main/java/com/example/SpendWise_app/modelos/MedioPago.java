package com.example.SpendWise_app.modelos;

import com.example.SpendWise_app.modelos.utils.Estado;

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
@Table (name = "medio de pago")
public class MedioPago {
     //id,nombre,franquicia,estado(activo/inactivo)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "franquicia", nullable = false)
    private String franquicia;
    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "fk_usuario_id", referencedColumnName = "id")
    private Usuario usuario;
    
    public MedioPago() {
    }

    public MedioPago(Integer id, String nombre, String franquicia, Estado estado) {
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    

    

    // @OneToMany(mappedBy = "medioPago")
    // private List<Gastos> gastos;

}
