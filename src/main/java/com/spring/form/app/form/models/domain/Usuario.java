package com.spring.form.app.form.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.spring.form.app.form.validation.IdentificadorRegex;

public class Usuario {

    // @Pattern(regexp = "[0-9]{2}.[\\d]{3}.[\\d]{3}-[A-Z]{1}")
    @IdentificadorRegex
    private String identificador;

    @NotEmpty(message="el nombre no puede ser vacio")
    private String nombre;
    @NotEmpty
    private String apellido;

    @NotEmpty
    @Size(min = 3, max=8)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email
    private String email;

    public Usuario() {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Usuario(String usuario, String password, String email) {
        this.username = usuario;
        this.password = password;
        this.email = email;
    }

    public String getUsuario() {
        return username;
    }

    public void setUsuario(String usuario) {
        this.username = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
