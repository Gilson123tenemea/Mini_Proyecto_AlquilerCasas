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
public class Servicio_Adicional {

    private String codigo_servicio_adi;
    private String codigo_servi;
    private String codigo_cli;

    public Servicio_Adicional(String codigo_servicio_adi, String Codigo_servi, String codigo_cli) {
        this.codigo_servicio_adi = codigo_servicio_adi;
        this.codigo_servi = Codigo_servi;
        this.codigo_cli = codigo_cli;
    }

    public String getCodigo_servicio_adi() {
        return codigo_servicio_adi;
    }

    public void setCodigo_servicio_adi(String codigo_servicio_adi) {
        this.codigo_servicio_adi = codigo_servicio_adi;
    }

    public String getCodigo_servi() {
        return codigo_servi;
    }

    public void setCodigo_servi(String Codigo_servi) {
        this.codigo_servi = Codigo_servi;
    }

    public String getCodigo_cli() {
        return codigo_cli;
    }

    public void setCodigo_cli(String codigo_cli) {
        this.codigo_cli = codigo_cli;
    }
    
    

}
