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
public class Cuerpo_reserva {

    
    private String id_enc_reserva;
    private String cod_casa;
    private String disponibilidad;
    
    private Date reserva_cliente,fin_reserva;

    public Cuerpo_reserva() {
    }

    public Cuerpo_reserva(String id_enc_reserva, String cod_casa, String disponibilidad, Date reserva_cliente, Date fin_reserva) {
     
        this.id_enc_reserva = id_enc_reserva;
        this.cod_casa = cod_casa;
        this.disponibilidad = disponibilidad;
        this.reserva_cliente = reserva_cliente;
        this.fin_reserva = fin_reserva;
    }

   
    

    public String getId_enc_reserva() {
        return id_enc_reserva;
    }

    public void setId_enc_reserva(String id_enc_reserva) {
        this.id_enc_reserva = id_enc_reserva;
    }

    public String getCod_casa() {
        return cod_casa;
    }

    public void setCod_casa(String cod_casa) {
        this.cod_casa = cod_casa;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Date getReserva_cliente() {
        return reserva_cliente;
    }

    public void setReserva_cliente(Date reserva_cliente) {
        this.reserva_cliente = reserva_cliente;
    }

    public Date getFin_reserva() {
        return fin_reserva;
    }

    public void setFin_reserva(Date fin_reserva) {
        this.fin_reserva = fin_reserva;
    }

    @Override
    public String toString() {
        return "Cuerpo_reserva{" + "id_enc_reserva=" + id_enc_reserva + ", cod_casa=" + cod_casa + ", disponibilidad=" + disponibilidad + ", reserva_cliente=" + reserva_cliente + ", fin_reserva=" + fin_reserva + '}';
    }

    
    
    

}
