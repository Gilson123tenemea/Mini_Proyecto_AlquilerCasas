/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Propietario extends Persona {
    
    private String codigo_propie;
    private String ocupacion;

    public Propietario() {
    }

    public Propietario(String codigo_propie) {
        this.codigo_propie = codigo_propie;
    }

    public Propietario(String codigo_propie, String ocupacion, String cedula, String nombre, String apellido, String email, String telefono, String genero, Date fecha_nac) {
        super(cedula, nombre, apellido, email, telefono, genero, fecha_nac);
        this.codigo_propie = codigo_propie;
        this.ocupacion = ocupacion;
    }

    

    public String getCodigo_propie() {
        return codigo_propie;
    }

    public void setCodigo_propie(String codigo_propie) {
        this.codigo_propie = codigo_propie;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return "Propietario{" + "codigo_propie=" + codigo_propie + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
}
