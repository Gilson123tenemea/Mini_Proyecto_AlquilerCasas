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
public class Contrato {
    
    private String codigo_contrato;
    private String codigo_cli;
    private String codigo_age;
    private String nombre_casa;
    private String precio_casa;
    private boolean TerminosCondiciones;

    public Contrato(String codigo_contrato, String codigo_cli, String codigo_age, String nombre_casa, String precio_casa, boolean TerminosCondiciones) {
        this.codigo_contrato = codigo_contrato;
        this.codigo_cli = codigo_cli;
        this.codigo_age = codigo_age;
        this.nombre_casa = nombre_casa;
        this.precio_casa = precio_casa;
        this.TerminosCondiciones = TerminosCondiciones;
    }

   

   

    public String getCodigo_contrato() {
        return codigo_contrato;
    }

    public void setCodigo_contrato(String codigo_contrato) {
        this.codigo_contrato = codigo_contrato;
    }

    public String getCodigo_cli() {
        return codigo_cli;
    }

    public void setCodigo_cli(String codigo_cli) {
        this.codigo_cli = codigo_cli;
    }

    public String getCodigo_age() {
        return codigo_age;
    }

    public void setCodigo_age(String codigo_age) {
        this.codigo_age = codigo_age;
    }

    public boolean isTerminosCondiciones() {
        return TerminosCondiciones;
    }

    public String getNombre_casa() {
        return nombre_casa;
    }

    public void setNombre_casa(String nombre_casa) {
        this.nombre_casa = nombre_casa;
    }

    public String getPrecio_casa() {
        return precio_casa;
    }

    public void setPrecio_casa(String precio_casa) {
        this.precio_casa = precio_casa;
    }
    

    public void setTerminosCondiciones(boolean TerminosCondiciones) {
        this.TerminosCondiciones = TerminosCondiciones;
    }
    
 
}
