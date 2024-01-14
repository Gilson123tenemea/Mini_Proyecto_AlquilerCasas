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
public class Servicio_Adicional extends Servicio {

    private String codigo_servicio_adi;
    private String codigo_servicioi;
    private Date fecha;
    private String nombre;
    private String costos;

    public Servicio_Adicional() {
        super();
    }

    public Servicio_Adicional(String codigo_servicio_adi, String codigo_servicioi, Date fecha, String nombre, String costos, String codigo_servicio, String cod_cliente, String nombre_ser, String descripcionSer, String CostoAdicional) {
        super(codigo_servicio, cod_cliente, nombre_ser, descripcionSer, CostoAdicional);
        this.codigo_servicio_adi = codigo_servicio_adi;
        this.codigo_servicioi = codigo_servicioi;
        this.fecha = fecha;
        this.nombre = nombre;
        this.costos = costos;
    }

    public String getCodigo_servicio_adi() {
        return codigo_servicio_adi;
    }

    public void setCodigo_servicio_adi(String codigo_servicio_adi) {
        this.codigo_servicio_adi = codigo_servicio_adi;
    }

    public String getCodigo_servicioi() {
        return codigo_servicioi;
    }

    public void setCodigo_servicioi(String codigo_servicioi) {
        this.codigo_servicioi = codigo_servicioi;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCostos() {
        return costos;
    }

    public void setCostos(String costos) {
        this.costos = costos;
    }

    @Override
    public String toString() {
        return "Servicio_Adicional{" + "codigo_servicio_adi=" + codigo_servicio_adi + ", codigo_servicioi=" + codigo_servicioi + ", fecha=" + fecha + ", nombre=" + nombre + '}';
    }
    

    

}
