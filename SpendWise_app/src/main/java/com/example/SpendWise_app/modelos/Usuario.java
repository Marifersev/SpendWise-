package com.example.SpendWise_app.modelos;
import java.util.List;

import com.example.SpendWise_app.modelos.utils.Estado;
import com.example.SpendWise_app.modelos.utils.TipoDocumento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "usuario")
public class Usuario {
    //id,nombres,tipodocumento,documento,edad
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "documento", nullable = false, unique = true, length = 15)
    private String documento;
    @Column(name = "tipo_de_documento", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipodocu;
    @Column(name = "edad")
    private Integer edad;
    //-------------------------------------------------------------------

    @Column(name = "telefono", nullable = false, unique = true)
    private Integer telefono;
    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String correo;
    @Column(name = "password", nullable = false, unique = true, length = 50)
    private String password;
    @Column(name = "estado_de_cuenta")
    @Enumerated(EnumType.STRING)
    private Estado estado_de_cuenta;
    @Column(name = "foto", length = 250)
    private String foto_de_perfil;

    @OneToMany(mappedBy = "usuario")
    private List<Gastos> gastos;

    @OneToMany(mappedBy = "usuario")
    private List<MedioPago> medioPago;

    public Usuario() {
    }


    public Usuario(Integer id, String nombre, String documento, TipoDocumento tipodocu, Integer edad, Integer telefono,
            String correo, String password, Estado estado_de_cuenta, String foto_de_perfil) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.tipodocu = tipodocu;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
        this.estado_de_cuenta = estado_de_cuenta;
        this.foto_de_perfil = foto_de_perfil;
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

    public TipoDocumento getTipodocu() {
        return tipodocu;
    }

    public void setTipodocu(TipoDocumento    tipodocu) {
        this.tipodocu = tipodocu;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
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


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public Estado getEstado_de_cuenta() {
        return estado_de_cuenta;
    }


    public void setEstado_de_cuenta(Estado estado_de_cuenta) {
        this.estado_de_cuenta = estado_de_cuenta;
    }


    public String getFoto_de_perfil() {
        return foto_de_perfil;
    }


    public void setFoto_de_perfil(String foto_de_perfil) {
        this.foto_de_perfil = foto_de_perfil;
    }


}
