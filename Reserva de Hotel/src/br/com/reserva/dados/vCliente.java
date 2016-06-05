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
public class vCliente extends vPessoa{
    private String cod_cliente;

    public vCliente() {
    }

    public vCliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }
    
    
}
