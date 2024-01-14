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
public class Cuerpo_reserva {

    private String cod_reserva;
    private String id_enc_reserva;
    private String cod_casa;
    private String disponibilidad;

    public Cuerpo_reserva() {
    }

    public Cuerpo_reserva(String cod_reserva, String id_enc_reserva, String cod_casa, String disponibilidad) {
        this.cod_reserva = cod_reserva;
        this.id_enc_reserva = id_enc_reserva;
        this.cod_casa = cod_casa;
        this.disponibilidad = disponibilidad;
    }

    public String getCod_reserva() {
        return cod_reserva;
    }

    public void setCod_reserva(String cod_reserva) {
        this.cod_reserva = cod_reserva;
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

    @Override
    public String toString() {
        return "Cuerpo_reserva{" + "cod_reserva=" + cod_reserva + ", id_enc_reserva=" + id_enc_reserva + ", cod_casa=" + cod_casa + ", disponibilidad=" + disponibilidad + '}';
    }

}
