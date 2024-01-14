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
public class Contrato {
    
    private String codigo_contrato;
    private Date Fecha_ini;
    private Date Fecha_fin; 
    private String TerminosCondiciones;

    public Contrato(String codigo_contrato, Date Fecha_ini, Date Fecha_fin, String TerminosCondiciones) {
        this.codigo_contrato = codigo_contrato;
        this.Fecha_ini = Fecha_ini;
        this.Fecha_fin = Fecha_fin;
        this.TerminosCondiciones = TerminosCondiciones;
    }

    public Contrato() {
    }

    public String getCodigo_contrato() {
        return codigo_contrato;
    }

    public void setCodigo_contrato(String codigo_contrato) {
        this.codigo_contrato = codigo_contrato;
    }

    public Date getFecha_ini() {
        return Fecha_ini;
    }

    public void setFecha_ini(Date Fecha_ini) {
        this.Fecha_ini = Fecha_ini;
    }

    public Date getFecha_fin() {
        return Fecha_fin;
    }

    public void setFecha_fin(Date Fecha_fin) {
        this.Fecha_fin = Fecha_fin;
    }

    public String getTerminosCondiciones() {
        return TerminosCondiciones;
    }

    public void setTerminosCondiciones(String TerminosCondiciones) {
        this.TerminosCondiciones = TerminosCondiciones;
    }

    @Override
    public String toString() {
        return "Contrato{" + "codigo_contrato=" + codigo_contrato + ", Fecha_ini=" + Fecha_ini + ", Fecha_fin=" + Fecha_fin + ", TerminosCondiciones=" + TerminosCondiciones + '}';
    }
    
    
    
}
