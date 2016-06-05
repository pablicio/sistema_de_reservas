/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reserva.logica;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pablicio
 */
public class Conexao {

    public String db = "basereserva";
      public String url="jdbc:mysql://127.0.0.1/" +db;
    public String user = "root";
    public String senha = "123";

    public Conexao() {
    }

    public Connection conectar() {
        Connection link = null;
        try {
               Class.forName("org.gjt.mm.mysql.Driver");
            link=(Connection) DriverManager.getConnection(this.url, this.user, this.senha);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return link;
    }

}
