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
public class vFuncionario extends vPessoa{
     Double salario;
     String acesso;
     String login;
     String senha;
     String estado;

    public vFuncionario() {
    }

    public vFuncionario(Double salario, String acesso, String login, String senha, String estado) {
        this.salario = salario;
        this.acesso = acesso;
        this.login = login;
        this.senha = senha;
        this.estado = estado;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     
     
}
