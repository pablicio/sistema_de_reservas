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
public class vPessoa {

    private int cod_pessoa;
    private String nome;
    private String pai;
    private String mae;
    private String tipo_documento;
    private String num_documento;
    private String endereco;
    private String telefone;
    private String email;

    public vPessoa() {
    }

    public vPessoa(int cod_pessoa, String nome, String pai, String mae, String tipo_documento, String num_documento, String endereco, String telefone, String email) {
        this.cod_pessoa = cod_pessoa;
        this.nome = nome;
        this.pai = pai;
        this.mae = mae;
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public int getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(int cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }


    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

}
