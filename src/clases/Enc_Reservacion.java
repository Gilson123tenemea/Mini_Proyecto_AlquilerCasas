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


public class Enc_Reservacion {

    private String id_enc_reserva;
    private String cod_cliente;
    private Date fecha_reserva;

    public Enc_Reservacion() {
    }

    public Enc_Reservacion(String id_enc_reserva, String cod_cliente, Date fecha_reserva) {
        this.id_enc_reserva = id_enc_reserva;
        this.cod_cliente = cod_cliente;
        this.fecha_reserva = fecha_reserva;
    }

    public String getId_enc_reserva() {
        return id_enc_reserva;
    }

    public void setId_enc_reserva(String id_enc_reserva) {
        this.id_enc_reserva = id_enc_reserva;
    }

    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    @Override
    public String toString() {
        return "Enc_Reservacion{" + "id_enc_reserva=" + id_enc_reserva + ", cod_cliente=" + cod_cliente + ", fecha_reserva=" + fecha_reserva + '}';
    }

}
