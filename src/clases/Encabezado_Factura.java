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
    private String cod_reserva;
    private String cod_servicio;
    private String cod_promocion;
    private String doc_ser_adici;
    public Encabezado_Factura() {
    }

    public Encabezado_Factura(String codigo_fac, String cod_cliente, String cod_agente, String cod_casa, Date fecha, double valor_cancelar, String cod_reserva, String cod_servicio, String cod_promocion, String doc_ser_adici) {
        this.codigo_fac = codigo_fac;
        this.cod_cliente = cod_cliente;
        this.cod_agente = cod_agente;
        this.cod_casa = cod_casa;
        this.fecha = fecha;
        this.valor_cancelar = valor_cancelar;
        this.cod_reserva = cod_reserva;
        this.cod_servicio = cod_servicio;
        this.cod_promocion = cod_promocion;
        this.doc_ser_adici = doc_ser_adici;
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

    public String getCod_reserva() {
        return cod_reserva;
    }

    public void setCod_reserva(String cod_reserva) {
        this.cod_reserva = cod_reserva;
    }

    public String getCod_servicio() {
        return cod_servicio;
    }

    public void setCod_servicio(String cod_servicio) {
        this.cod_servicio = cod_servicio;
    }

    public String getCod_promocion() {
        return cod_promocion;
    }

    public void setCod_promocion(String cod_promocion) {
        this.cod_promocion = cod_promocion;
    }

    public String getDoc_ser_adici() {
        return doc_ser_adici;
    }

    public void setDoc_ser_adici(String doc_ser_adici) {
        this.doc_ser_adici = doc_ser_adici;
    }

    @Override
    public String toString() {
        return "Encabezado_Factura{" + "codigo_fac=" + codigo_fac + ", cod_cliente=" + cod_cliente + ", cod_agente=" + cod_agente + ", cod_casa=" + cod_casa + ", fecha=" + fecha + ", valor_cancelar=" + valor_cancelar + ", cod_reserva=" + cod_reserva + ", cod_servicio=" + cod_servicio + ", cod_promocion=" + cod_promocion + ", doc_ser_adici=" + doc_ser_adici + '}';
    }

   

}
