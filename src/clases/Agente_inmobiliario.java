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
public class Agente_inmobiliario extends Persona {
    private String codigo_agente,usuario,password;

    public Agente_inmobiliario() {
        super();
    }

    public Agente_inmobiliario(String codigo_agente, String usuario, String password, String cedula, String nombre, String apellido, String email, String telefono, String genero, Date fecha_nac) {
        super(cedula, nombre, apellido, email, telefono, genero, fecha_nac);
        this.codigo_agente = codigo_agente;
        this.usuario = usuario;
        this.password = password;
    }

  
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

  

    
    public String getCodigo_agente() {
        return codigo_agente;
    }

    public void setCodigo_agente(String codigo_agente) {
        this.codigo_agente = codigo_agente;
    }

    @Override
    public String toString() {
        return "Agente_inmobiliario{" + "codigo_agente=" + codigo_agente + '}';
    }
    
    
    
}
