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
public class Promocion {

    private String cod_promo;
    private String cod_casa;
    private int Descuento;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String descripcion;

    public Promocion() {
    }

    public Promocion(String cod_promo, String cod_casa, int Descuento, Date fecha_inicio, Date fecha_fin, String descripcion) {
        this.cod_promo = cod_promo;
        this.cod_casa = cod_casa;
        this.Descuento = Descuento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.descripcion = descripcion;
    }

    public String getCod_promo() {
        return cod_promo;
    }

    public void setCod_promo(String cod_promo) {
        this.cod_promo = cod_promo;
    }

    public String getCod_casa() {
        return cod_casa;
    }

    public void setCod_casa(String cod_casa) {
        this.cod_casa = cod_casa;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Promocion{" + "cod_promo=" + cod_promo + ", cod_casa=" + cod_casa + ", Descuento=" + Descuento + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", descripcion=" + descripcion + '}';
    }

}
