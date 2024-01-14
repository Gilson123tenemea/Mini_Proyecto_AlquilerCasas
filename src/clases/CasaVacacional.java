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
public class CasaVacacional  {
    
    private String cod_casa;
    private String Nombre_casa;
    private String Tipo_casa;
    private int num_pisos;
    private int capacidad_max;
    private int num_habitaciones;
    private int num_baños;
    
    private String codigo_propie;
    
    private double precio;
    private boolean disponibilidad;
    private String cod_ubicacion;

    public CasaVacacional() {
        super();
    }

    public CasaVacacional(String cod_casa, String Nombre_casa, String Tipo_casa, int num_pisos, int capacidad_max, int num_habitaciones, int num_baños, String codigo_propie, double precio, boolean disponibilidad, String cod_ubicacion) {
        this.cod_casa = cod_casa;
        this.Nombre_casa = Nombre_casa;
        this.Tipo_casa = Tipo_casa;
        this.num_pisos = num_pisos;
        this.capacidad_max = capacidad_max;
        this.num_habitaciones = num_habitaciones;
        this.num_baños = num_baños;
        this.codigo_propie = codigo_propie;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.cod_ubicacion = cod_ubicacion;
    }

    public String getCod_casa() {
        return cod_casa;
    }

    public void setCod_casa(String cod_casa) {
        this.cod_casa = cod_casa;
    }

    public String getNombre_casa() {
        return Nombre_casa;
    }

    public void setNombre_casa(String Nombre_casa) {
        this.Nombre_casa = Nombre_casa;
    }

    public String getTipo_casa() {
        return Tipo_casa;
    }

    public void setTipo_casa(String Tipo_casa) {
        this.Tipo_casa = Tipo_casa;
    }

    public int getNum_pisos() {
        return num_pisos;
    }

    public void setNum_pisos(int num_pisos) {
        this.num_pisos = num_pisos;
    }

    public int getCapacidad_max() {
        return capacidad_max;
    }

    public void setCapacidad_max(int capacidad_max) {
        this.capacidad_max = capacidad_max;
    }

    public int getNum_habitaciones() {
        return num_habitaciones;
    }

    public void setNum_habitaciones(int num_habitaciones) {
        this.num_habitaciones = num_habitaciones;
    }

    public int getNum_baños() {
        return num_baños;
    }

    public void setNum_baños(int num_baños) {
        this.num_baños = num_baños;
    }

    public String getCodigo_propie() {
        return codigo_propie;
    }

    public void setCodigo_propie(String codigo_propie) {
        this.codigo_propie = codigo_propie;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getCod_ubicacion() {
        return cod_ubicacion;
    }

    public void setCod_ubicacion(String cod_ubicacion) {
        this.cod_ubicacion = cod_ubicacion;
    }

    @Override
    public String toString() {
        return "CasaVacacional{" + "cod_casa=" + cod_casa + ", Nombre_casa=" + Nombre_casa + ", Tipo_casa=" + Tipo_casa + ", num_pisos=" + num_pisos + ", capacidad_max=" + capacidad_max + ", num_habitaciones=" + num_habitaciones + ", num_ba\u00f1os=" + num_baños + ", codigo_propie=" + codigo_propie + ", precio=" + precio + ", disponibilidad=" + disponibilidad + ", cod_ubicacion=" + cod_ubicacion + '}';
    }

    
   
  
}
