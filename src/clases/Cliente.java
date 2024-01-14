/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author Lenovo.User
 */
public class Cliente extends Persona {

    private String codigo_cli;
    private String discapacidad;
    private String contraseña;

    public Cliente() {
        super();
    }

    public Cliente(String codigo_cli, String discapacidad, String contraseña, String cedula, String nombre, String apellido, String email, String telefono, String genero, Date fecha_nac) {
        super(cedula, nombre, apellido, email, telefono, genero, fecha_nac);
        this.codigo_cli = codigo_cli;
        this.discapacidad = discapacidad;
        this.contraseña = contraseña;
    }

    public String getCodigo_cli() {
        return codigo_cli;
    }

    public void setCodigo_cli(String codigo_cli) {
        this.codigo_cli = codigo_cli;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
