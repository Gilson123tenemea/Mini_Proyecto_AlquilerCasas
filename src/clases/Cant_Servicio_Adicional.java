/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author eliza
 */
public class Cant_Servicio_Adicional {

    private String codigo_adicional;
    private String codigo_servicio;
    private String cod_casa;
    private double valor_adicional;
    private int cantidad_adicional;

    public Cant_Servicio_Adicional() {
    }

    public Cant_Servicio_Adicional(String codigo_adicional, String codigo_servicio, String cod_casa, double valor_adicional, int cantidad_adicional) {
        this.codigo_adicional = codigo_adicional;
        this.codigo_servicio = codigo_servicio;
        this.cod_casa = cod_casa;
        this.valor_adicional = valor_adicional;
        this.cantidad_adicional = cantidad_adicional;
    }

    public String getCodigo_adicional() {
        return codigo_adicional;
    }

    public void setCodigo_adicional(String codigo_adicional) {
        this.codigo_adicional = codigo_adicional;
    }

    public String getCodigo_servicio() {
        return codigo_servicio;
    }

    public void setCodigo_servicio(String codigo_servicio) {
        this.codigo_servicio = codigo_servicio;
    }

    public String getCod_casa() {
        return cod_casa;
    }

    public void setCod_casa(String cod_casa) {
        this.cod_casa = cod_casa;
    }

    public double getValor_adicional() {
        return valor_adicional;
    }

    public void setValor_adicional(double valor_adicional) {
        this.valor_adicional = valor_adicional;
    }

    public int getCantidad_adicional() {
        return cantidad_adicional;
    }

    public void setCantidad_adicional(int cantidad_adicional) {
        this.cantidad_adicional = cantidad_adicional;
    }

    @Override
    public String toString() {
        return "Cant_Servicio_Adicional{" + "codigo_adicional=" + codigo_adicional + ", codigo_servicio=" + codigo_servicio + ", cod_casa=" + cod_casa + ", valor_adicional=" + valor_adicional + ", cantidad_adicional=" + cantidad_adicional + '}';
    }

}
