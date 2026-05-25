package com.example.SpendWise_app.modelos;

import java.time.LocalDate;
import java.util.List;

import com.example.SpendWise_app.modelos.utils.TipoCategoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "categoria")
public class Categoria {
    //id, nombre, fechaCreacion, responsable, justificacion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechacreacion;
    @Column(name = "responsable", nullable = false)
    private String responsable;
    @Column(name = "justificacion")
    private String justificacion;
    //---------------------------------------------------------------------

    @Column(name = "presupuesto", nullable = false)
    private Integer presupuesto;
    @Column(name = "prioridad")
    private String prioridad;
    @Column(name = "limite", nullable = false)
    private Integer limite;
    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoCategoria tipo;
    @Column(name = "periodicidad")
    private String periodicidad;

    // @ManyToOne
    // @JoinColumn(name = "fk_gasto_id", referencedColumnName = "id")
    // private Gastos gasto;

    @OneToMany(mappedBy = "categoria")
    private List<Gastos> gastos;

    public Categoria() {
    }


    public Categoria(Integer id, String nombre, LocalDate fechacreacion, String responsable, String justificacion,
            Integer presupuesto, String prioridad, Integer limite, TipoCategoria tipo, String periodicidad) {
        this.id = id;
        this.nombre = nombre;
        this.fechacreacion = fechacreacion;
        this.responsable = responsable;
        this.justificacion = justificacion;
        this.presupuesto = presupuesto;
        this.prioridad = prioridad;
        this.limite = limite;
        this.tipo = tipo;
        this.periodicidad = periodicidad;
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


    public Integer getPresupuesto() {
        return presupuesto;
    }


    public void setPresupuesto(Integer presupuesto) {
        this.presupuesto = presupuesto;
    }


    public String getPrioridad() {
        return prioridad;
    }


    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }


    public Integer getLimite() {
        return limite;
    }


    public void setLimite(Integer limite) {
        this.limite = limite;
    }


    public TipoCategoria getTipo() {
        return tipo;
    }


    public void setTipo(TipoCategoria tipo) {
        this.tipo = tipo;
    }


    public String getPeriodicidad() {
        return periodicidad;
    }


    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

        // @OneToMany(mappedBy = "categoria")
        // private List<Gastos> gastos;

}
