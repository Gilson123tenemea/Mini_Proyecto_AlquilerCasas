/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Lenovo
 */
public class Tipo_Actividad {
    
    private String  cod_tipoactividad,nombre,descripcion;

    public Tipo_Actividad(String cod_tipoactividad, String nombre, String descripcion) {
        this.cod_tipoactividad = cod_tipoactividad;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Tipo_Actividad() {
    }

    public String getCod_tipoactividad() {
        return cod_tipoactividad;
    }

    public void setCod_tipoactividad(String cod_tipoactividad) {
        this.cod_tipoactividad = cod_tipoactividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Tipo_Actividad{" + "cod_tipoactividad=" + cod_tipoactividad + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
    
    
}
