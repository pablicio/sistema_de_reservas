/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reserva.dados;

/**
 *
 * @author pablicio
 */
public class vHabitacao {
    private int cod_habitacao;
    private String numero;
    private String piso;
    private String descricao;
    private String caracteristicas;
    private Double preco_diaria;
    private String estado;
    private String tipo_habitacao;

    public vHabitacao(int cod_habitacao, String numero, String piso, String descricao, String caracteristicas, Double preco_diaria, String estado, String tipo_habitacao) {
        this.cod_habitacao = cod_habitacao;
        this.numero = numero;
        this.piso = piso;
        this.descricao = descricao;
        this.caracteristicas = caracteristicas;
        this.preco_diaria = preco_diaria;
        this.estado = estado;
        this.tipo_habitacao = tipo_habitacao;
    }

    public vHabitacao() {
    }

    public int getCod_habitacao() {
        return cod_habitacao;
    }

    public void setCod_habitacao(int cod_habitacao) {
        this.cod_habitacao = cod_habitacao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Double getPreco_diaria() {
        return preco_diaria;
    }

    public void setPreco_diaria(Double preco_diaria) {
        this.preco_diaria = preco_diaria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_habitacao() {
        return tipo_habitacao;
    }

    public void setTipo_habitacao(String tipo_habitacao) {
        this.tipo_habitacao = tipo_habitacao;
    }

    

   
    
    
    
    
    
}
