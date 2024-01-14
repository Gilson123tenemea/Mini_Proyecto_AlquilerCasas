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
public class Actividades {
    private String id_actividades;
    private String cod_cliente;
    private String cod_casa;
    private String tipo_actividad;
    private String costo_adicional;
    private Date fecha;
    private String hora;

    public Actividades() {
    }

    public Actividades(String id_actividades, String cod_cliente, String cod_casa, String tipo_actividad, String costo_adicional, Date fecha, String hora) {
        this.id_actividades = id_actividades;
        this.cod_cliente = cod_cliente;
        this.cod_casa = cod_casa;
        this.tipo_actividad = tipo_actividad;
        this.costo_adicional = costo_adicional;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getId_actividades() {
        return id_actividades;
    }

    public void setId_actividades(String id_actividades) {
        this.id_actividades = id_actividades;
    }
    

    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getCod_casa() {
        return cod_casa;
    }

    public void setCod_casa(String cod_casa) {
        this.cod_casa = cod_casa;
    }

    public String getTipo_actividad() {
        return tipo_actividad;
    }

    public void setTipo_actividad(String tipo_actividad) {
        this.tipo_actividad = tipo_actividad;
    }

    public String getCosto_adicional() {
        return costo_adicional;
    }

    public void setCosto_adicional(String costo_adicional) {
        this.costo_adicional = costo_adicional;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Actividades{" + "id_actividades=" + id_actividades + ", cod_cliente=" + cod_cliente + ", cod_casa=" + cod_casa + ", tipo_actividad=" + tipo_actividad + ", costo_adicional=" + costo_adicional + ", fecha=" + fecha + ", hora=" + hora + '}';
    }

    

}
