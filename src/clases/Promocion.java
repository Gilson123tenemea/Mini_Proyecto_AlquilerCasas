package clases;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Promocion {

    private String cod_promo;
    private Integer descuento;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String descripcion;

    public Promocion() {
    }

    public Promocion(String cod_promo, Integer Descuento, Date fecha_inicio, Date fecha_fin, String descripcion) {
        this.cod_promo = cod_promo;
        this.descuento = Descuento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.descripcion = descripcion;
    }

    

    public String getCod_promo() {
        return cod_promo;
    }

    public void setCod_promo(String cod_promo) {
        this.cod_promo = cod_promo;
    }


    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer Descuento) {
        this.descuento = Descuento;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



}
