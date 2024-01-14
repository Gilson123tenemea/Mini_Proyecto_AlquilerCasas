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
public class Encabezado_Factura {

    private String codigo_fac;
    private String cod_cliente;
    private String cod_agente;
    private String cod_casa;
    private Date fecha;
    private double valor_cancelar;

    public Encabezado_Factura() {
    }

    public Encabezado_Factura(String codigo_fac, String cod_cliente, String cod_agente, String cod_casa, Date fecha, double valor_cancelar) {
        this.codigo_fac = codigo_fac;
        this.cod_cliente = cod_cliente;
        this.cod_agente = cod_agente;
        this.cod_casa = cod_casa;
        this.fecha = fecha;
        this.valor_cancelar = valor_cancelar;
    }

    public String getCodigo_fac() {
        return codigo_fac;
    }

    public void setCodigo_fac(String codigo_fac) {
        this.codigo_fac = codigo_fac;
    }

    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getCod_agente() {
        return cod_agente;
    }

    public void setCod_agente(String cod_agente) {
        this.cod_agente = cod_agente;
    }

    public String getCod_casa() {
        return cod_casa;
    }

    public void setCod_casa(String cod_casa) {
        this.cod_casa = cod_casa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValor_cancelar() {
        return valor_cancelar;
    }

    public void setValor_cancelar(double valor_cancelar) {
        this.valor_cancelar = valor_cancelar;
    }

    @Override
    public String toString() {
        return "Encabezado_Factura{" + "codigo_fac=" + codigo_fac + ", cod_cliente=" + cod_cliente + ", cod_agente=" + cod_agente + ", cod_casa=" + cod_casa + ", fecha=" + fecha + ", valor_cancelar=" + valor_cancelar + '}';
    }

}
