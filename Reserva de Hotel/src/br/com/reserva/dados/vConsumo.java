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
public class vConsumo {
     private int cod_consumo;
    private int cod_reserva;
    private int cod_produto;
    private Double quantidade;
    private Double preco_venda;
    private String estado;

    public vConsumo() {
    }

    public vConsumo(int cod_consumo, int cod_reserva, int cod_produto, Double quantidade, Double preco_venda, String estado) {
        this.cod_consumo = cod_consumo;
        this.cod_reserva = cod_reserva;
        this.cod_produto = cod_produto;
        this.quantidade = quantidade;
        this.preco_venda = preco_venda;
        this.estado = estado;
    }

    public int getCod_consumo() {
        return cod_consumo;
    }

    public void setCod_consumo(int cod_consumo) {
        this.cod_consumo = cod_consumo;
    }

    public int getCod_reserva() {
        return cod_reserva;
    }

    public void setCod_reserva(int cod_reserva) {
        this.cod_reserva = cod_reserva;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
