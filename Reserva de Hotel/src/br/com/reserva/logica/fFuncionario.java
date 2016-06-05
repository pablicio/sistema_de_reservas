/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reserva.logica;

import br.com.reserva.dados.vFuncionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablicio
 */
public class fFuncionario {

    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Código", "Nome", "Pai", "Mãe", "Doc", "Número do Doc", "Endereço", "Telefone", "Email", "Salário", "Acesso", "Login", "Clave", "Estado"};

        String[] registro = new String[14];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.cod_pessoa,p.nome,p.pai,p.mae,p.tipo_documento,p.num_documento,"
                + "p.endereco,p.telefone,p.email,t.salario,t.acesso,t.login,t.senha,t.estado from pessoa p inner join funcionario t "
                + "on p.cod_pessoa=t.cod_pessoa where num_documento like '%"
                + buscar + "%' order by cod_pessoa desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("cod_pessoa");
                registro[1] = rs.getString("nome");
                registro[2] = rs.getString("pai");
                registro[3] = rs.getString("mae");
                registro[4] = rs.getString("tipo_documento");
                registro[5] = rs.getString("num_documento");
                registro[6] = rs.getString("endereco");
                registro[7] = rs.getString("telefone");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("salario");
                registro[10] = rs.getString("acesso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("senha");
                registro[13] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vFuncionario dts) {
        sSQL = "insert into pessoa (nome,pai,mae,tipo_documento,num_documento,endereco,telefone,email)"
                + "values (?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into funcionario (cod_pessoa,salario,acesso,login,senha,estado)"
                + "values ((select cod_pessoa from pessoa order by cod_pessoa desc limit 1),?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getPai());
            pst.setString(3, dts.getMae());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getEndereco());
            pst.setString(7, dts.getTelefone());
            pst.setString(8, dts.getEmail());

            pst2.setDouble(1, dts.getSalario());
            pst2.setString(2, dts.getAcesso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getSenha());
            pst2.setString(5, dts.getEstado());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(vFuncionario dts) {
        sSQL = "update pessoa set nome=?,pai=?,mae=?,tipo_documento=?,num_documento=?,"
                + " endereco=?,telefone=?,email=? where cod_pessoa=?";

        sSQL2 = "update funcionario set salario=?,acesso=?,login=?,senha=?,estado=?"
                + " where cod_pessoa=?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getPai());
            pst.setString(3, dts.getMae());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getEndereco());
            pst.setString(7, dts.getTelefone());
            pst.setString(8, dts.getEmail());
            pst.setInt(9, dts.getCod_pessoa());

            pst2.setDouble(1, dts.getSalario());
            pst2.setString(2, dts.getAcesso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getSenha());
            pst2.setString(5, dts.getEstado());
            pst2.setInt(6, dts.getCod_pessoa());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(vFuncionario dts) {
        sSQL = "delete from funcionario where cod_pessoa=?";
        sSQL2 = "delete from pessoa where cod_pessoa=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setInt(1, dts.getCod_pessoa());

            pst2.setInt(1, dts.getCod_pessoa());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public DefaultTableModel login(String login, String password) {
        DefaultTableModel modelo;

        String[] titulos = {"Código", "Nome", "Pai", "Mãe", "Acesso", "Login", "Clave", "Estado"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.cod_pessoa,p.nome,p.pai,p.mae,"
                + "t.acesso,t.login,t.senha,t.estado from pessoa p inner join funcionario t "
                + "on p.cod_pessoa=t.cod_pessoa where t.login='"
                + login + "' and t.senha='" + password + "' and t.estado='A'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("cod_pessoa");
                registro[1] = rs.getString("nome");
                registro[2] = rs.getString("pai");
                registro[3] = rs.getString("mae");

                registro[4] = rs.getString("acesso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("senha");
                registro[7] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
}
