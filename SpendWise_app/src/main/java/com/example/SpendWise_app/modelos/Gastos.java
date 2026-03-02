package com.example.SpendWise_app.modelos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "gasto")
public class Gastos {
      //id, descripcion, fecha, valor, imagen(icono)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "descripcion", length = 150)
    private String descripcion;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "valor", nullable = false)
    private double valor;
    private String icono;
    //---------------------------------------------------------

    @Column(name = "comprobante", nullable = false)
    private String comprobante;
    @Column(name = "descuento")
    private Integer descuento;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    @Column(name = "impuesto", nullable = false)
    private Integer impuesto;
    @Column(name = "recurente")
    private String recurente;

    public Gastos() {
    }


    public Gastos(Integer id, String descripcion, LocalDate fecha, double valor, String icono, String comprobante,
            Integer descuento, Integer cantidad, Integer impuesto, String recurente) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.valor = valor;
        this.icono = icono;
        this.comprobante = comprobante;
        this.descuento = descuento;
        this.cantidad = cantidad;
        this.impuesto = impuesto;
        this.recurente = recurente;
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


    public String getComprobante() {
        return comprobante;
    }


    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }


    public Integer getDescuento() {
        return descuento;
    }


    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }


    public Integer getCantidad() {
        return cantidad;
    }


    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    public Integer getImpuesto() {
        return impuesto;
    }


    public void setImpuesto(Integer impuesto) {
        this.impuesto = impuesto;
    }


    public String getRecurente() {
        return recurente;
    }


    public void setRecurente(String recurente) {
        this.recurente = recurente;
    } 

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "comercio_id")
    private Comercio comercio;

    @ManyToOne
    @JoinColumn(name = "mediopago_id")
    private MedioPago medioPago;
}
