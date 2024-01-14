/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Lenovo
 */
public class Ubicacion {

    private String cod_ubicacion, provincia, ciudad, barriocalle, principal;

    public Ubicacion() {
    }
    
    

    public Ubicacion(String cod_ubicacion, String provincia, String ciudad, String barriocalle, String principal) {
        this.cod_ubicacion = cod_ubicacion;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.barriocalle = barriocalle;
        this.principal = principal;
    }

    public String getCod_ubicacion() {
        return cod_ubicacion;
    }

    public void setCod_ubicacion(String cod_ubicacion) {
        this.cod_ubicacion = cod_ubicacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getBarriocalle() {
        return barriocalle;
    }

    public void setBarriocalle(String barriocalle) {
        this.barriocalle = barriocalle;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "cod_ubicacion=" + cod_ubicacion + ", provincia=" + provincia + ", ciudad=" + ciudad + ", barriocalle=" + barriocalle + ", principal=" + principal + '}';
    }

}
