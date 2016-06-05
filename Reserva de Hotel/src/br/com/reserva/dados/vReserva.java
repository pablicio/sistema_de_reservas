/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reserva.dados;

import java.sql.Date;

/**
 *
 * @author pablicio
 */
public class vReserva {

    private int cod_reserva;
    private int cod_habitacao;
    private int cod_cliente;
    private int cod_funcionario;
    private String tipo_reserva;
    private Date data_reserva;
    private Date data_entrada;
    private Date data_saida;
    private Double custo_hospedagem;
    private String estado;

    public vReserva() {
    }

    public vReserva(int cod_reserva, int cod_habitacao, int cod_cliente, int cod_funcionario, String tipo_reserva, Date data_reserva, Date data_entrada, Date data_saida, Double custo_hospedagem, String estado) {
        this.cod_reserva = cod_reserva;
        this.cod_habitacao = cod_habitacao;
        this.cod_cliente = cod_cliente;
        this.cod_funcionario = cod_funcionario;
        this.tipo_reserva = tipo_reserva;
        this.data_reserva = data_reserva;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.custo_hospedagem = custo_hospedagem;
        this.estado = estado;
    }

    public int getCod_reserva() {
        return cod_reserva;
    }

    public void setCod_reserva(int cod_reserva) {
        this.cod_reserva = cod_reserva;
    }

    public int getCod_habitacao() {
        return cod_habitacao;
    }

    public void setCod_habitacao(int cod_habitacao) {
        this.cod_habitacao = cod_habitacao;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public String getTipo_reserva() {
        return tipo_reserva;
    }

    public void setTipo_reserva(String tipo_reserva) {
        this.tipo_reserva = tipo_reserva;
    }

    public Date getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(Date data_reserva) {
        this.data_reserva = data_reserva;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public Double getCusto_hospedagem() {
        return custo_hospedagem;
    }

    public void setCusto_hospedagem(Double custo_hospedagem) {
        this.custo_hospedagem = custo_hospedagem;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
