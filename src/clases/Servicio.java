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
public class Servicio {

    private String codigo_servicio;
    private String nombre_ser;
    private String descripcionSer;
    private String CostoAdicional;

    public Servicio() {
    }

    public Servicio(String codigo_servicio, String nombre_ser, String descripcionSer, String CostoAdicional) {
        this.codigo_servicio = codigo_servicio;
        this.nombre_ser = nombre_ser;
        this.descripcionSer = descripcionSer;
        this.CostoAdicional = CostoAdicional;
    }

    public String getCodigo_servicio() {
        return codigo_servicio;
    }

    public void setCodigo_servicio(String codigo_servicio) {
        this.codigo_servicio = codigo_servicio;
    }

    public String getNombre_ser() {
        return nombre_ser;
    }

    public void setNombre_ser(String nombre_ser) {
        this.nombre_ser = nombre_ser;
    }

    public String getDescripcionSer() {
        return descripcionSer;
    }

    public void setDescripcionSer(String descripcionSer) {
        this.descripcionSer = descripcionSer;
    }

    public String getCostoAdicional() {
        return CostoAdicional;
    }

    public void setCostoAdicional(String CostoAdicional) {
        this.CostoAdicional = CostoAdicional;
    }

    

}
