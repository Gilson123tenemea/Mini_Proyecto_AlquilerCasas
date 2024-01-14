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
public class Supervisor extends Persona{
    
    private String codigo_supervisor,usuario,contraseña;

    public Supervisor() {
        super();
    }

    public Supervisor(String codigo_supervisor, String usuario, String contraseña, String cedula, String nombre, String apellido, String email, String telefono, String genero, Date fecha_nac) {
        super(cedula, nombre, apellido, email, telefono, genero, fecha_nac);
        this.codigo_supervisor = codigo_supervisor;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getCodigo_supervisor() {
        return codigo_supervisor;
    }

    public void setCodigo_supervisor(String codigo_supervisor) {
        this.codigo_supervisor = codigo_supervisor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Supervisor{" + "codigo_supervisor=" + codigo_supervisor + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
    
}
