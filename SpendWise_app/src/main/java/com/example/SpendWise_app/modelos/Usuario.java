package com.example.SpendWise_app.modelos;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "usuario")
public class Usuario {
    //id,nombres,tipodocumento,documento,edad
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String documento;
    private String tipodocu;
    private Integer edad;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String documento, String tipodocu, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.tipodocu = tipodocu;
        this.edad = edad;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipodocu() {
        return tipodocu;
    }

    public void setTipodocu(String tipodocu) {
        this.tipodocu = tipodocu;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }


}
