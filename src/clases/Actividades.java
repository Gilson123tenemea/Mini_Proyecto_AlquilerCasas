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
    private String cod_casa;
    private String tipo_actividad;
   
    private Date fecha;
    private String hora;

    public Actividades() {
    }

    public Actividades(String id_actividades, String cod_casa, String tipo_actividad, Date fecha, String hora) {
        this.id_actividades = id_actividades;
        this.cod_casa = cod_casa;
        this.tipo_actividad = tipo_actividad;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getId_actividades() {
        return id_actividades;
    }

    public void setId_actividades(String id_actividades) {
        this.id_actividades = id_actividades;
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
        return "Actividades{" + "id_actividades=" + id_actividades + ", cod_casa=" + cod_casa + ", tipo_actividad=" + tipo_actividad + ", fecha=" + fecha + ", hora=" + hora + '}';
    }

    
}
