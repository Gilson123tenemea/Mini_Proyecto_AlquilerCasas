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
public class Comentario {

    private String cod_comentario;
    private String cod_cliente;
    private String cod_casa;
    private String descrpcion;

    public Comentario() {
    }

    public Comentario(String cod_comentario, String cod_cliente, String cod_casa, String descrpcion) {
        this.cod_comentario = cod_comentario;
        this.cod_cliente = cod_cliente;
        this.cod_casa = cod_casa;
        this.descrpcion = descrpcion;
    }

    public String getCod_comentario() {
        return cod_comentario;
    }

    public void setCod_comentario(String cod_comentario) {
        this.cod_comentario = cod_comentario;
    }

    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getCod_casa() {
        return cod_casa;
    }

    public void setCod_casa(String cod_casa) {
        this.cod_casa = cod_casa;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }

    @Override
    public String toString() {
        return "Comentario{" + "cod_comentario=" + cod_comentario + ", cod_cliente=" + cod_cliente + ", cod_casa=" + cod_casa + ", descrpcion=" + descrpcion + '}';
    }

}
