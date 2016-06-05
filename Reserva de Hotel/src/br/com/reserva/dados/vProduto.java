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
public class vProduto {

    private int cod_produto;
    private String nome;
    private String descricao;
    private String unidade_medida;
    private Double preco_venda;

    public vProduto() {
    }

    public vProduto(int cod_produto, String nome, String descricao, String unidade_medida, Double preco_venda) {
        this.cod_produto = cod_produto;
        this.nome = nome;
        this.descricao = descricao;
        this.unidade_medida = unidade_medida;
        this.preco_venda = preco_venda;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }
    
    
}
