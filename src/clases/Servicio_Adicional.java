/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author eliza
 */
public class Servicio_Adicional {

    private String codigo_servicio_adi;
    private Date fecha;
    private String nombre;
    private String costos;
    private String codigo_cli;

    public Servicio_Adicional(String codigo_servicio_adi, Date fecha, String nombre, String costos, String codigo_cli) {
        this.codigo_servicio_adi = codigo_servicio_adi;
        this.fecha = fecha;
        this.nombre = nombre;
        this.costos = costos;
        this.codigo_cli = codigo_cli;
    }

    

    public String getCodigo_servicio_adi() {
        return codigo_servicio_adi;
    }

    public void setCodigo_servicio_adi(String codigo_servicio_adi) {
        this.codigo_servicio_adi = codigo_servicio_adi;
    }
    
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCostos() {
        return costos;
    }

    public void setCostos(String costos) {
        this.costos = costos;
    }

    public String getCodigo_cli() {
        return codigo_cli;
    }

    public void setCodigo_cli(String codigo_cli) {
        this.codigo_cli = codigo_cli;
    }

}
