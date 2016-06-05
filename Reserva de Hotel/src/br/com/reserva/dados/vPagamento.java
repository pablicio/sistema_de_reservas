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
public class vPagamento {
        private int cod_pagamento;
    private int cod_reserva;
    private String tipo_comprovante;
    private String num_comprovante;
    private Double igv;
    private Double total_pagamento;
    private Date data_emissao;
    private Date data_pagamento;

    public vPagamento() {
    }

    public vPagamento(int cod_pagamento, int cod_reserva, String tipo_comprovante, String num_comprovante, Double igv, Double total_pagamento, Date data_emissao, Date data_pagamento) {
        this.cod_pagamento = cod_pagamento;
        this.cod_reserva = cod_reserva;
        this.tipo_comprovante = tipo_comprovante;
        this.num_comprovante = num_comprovante;
        this.igv = igv;
        this.total_pagamento = total_pagamento;
        this.data_emissao = data_emissao;
        this.data_pagamento = data_pagamento;
    }

    public int getCod_pagamento() {
        return cod_pagamento;
    }

    public void setCod_pagamento(int cod_pagamento) {
        this.cod_pagamento = cod_pagamento;
    }

    public int getCod_reserva() {
        return cod_reserva;
    }

    public void setCod_reserva(int cod_reserva) {
        this.cod_reserva = cod_reserva;
    }

    public String getTipo_comprovante() {
        return tipo_comprovante;
    }

    public void setTipo_comprovante(String tipo_comprovante) {
        this.tipo_comprovante = tipo_comprovante;
    }

    public String getNum_comprovante() {
        return num_comprovante;
    }

    public void setNum_comprovante(String num_comprovante) {
        this.num_comprovante = num_comprovante;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotal_pagamento() {
        return total_pagamento;
    }

    public void setTotal_pagamento(Double total_pagamento) {
        this.total_pagamento = total_pagamento;
    }

    public Date getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }
    
    

}
