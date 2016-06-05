/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reserva.logica;

import br.com.reserva.dados.vPagamento;
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
public class fPagamento {
    private Conexao mysql=new Conexao();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"Código","Código Reserva","Comprovante","Número","Igv","Total","Data Emissão","Data Pagamento"};
       
       String [] registro =new String [8];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from pagamento where cod_reserva="+ buscar + " order by cod_pagamento desc";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("cod_pagamento");
               registro [1]=rs.getString("cod_reserva");
               registro [2]=rs.getString("tipo_comprovante");
               registro [3]=rs.getString("num_comprovante");
               registro [4]=rs.getString("igv");
               registro [5]=rs.getString("total_pagamento");
               registro [6]=rs.getString("data_emissao");
               registro [7]=rs.getString("data_pagamento");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
       
       
       
   } 
   
   public boolean insertar (vPagamento dts){
       sSQL="insert into pagamento (cod_reserva,tipo_comprovante,num_comprovante,igv,total_pagamento,data_emissao,data_pagamento)" +
               "values (?,?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getCod_reserva());
           pst.setString(2, dts.getTipo_comprovante());
           pst.setString(3, dts.getNum_comprovante());
           pst.setDouble(4, dts.getIgv());
           pst.setDouble(5, dts.getTotal_pagamento());
           pst.setDate(6, dts.getData_emissao());
           pst.setDate(7, dts.getData_pagamento());
           
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
           
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
   
   public boolean editar (vPagamento dts){
       sSQL="update pagamento set cod_reserva=?,tipo_comprovante=?,num_comprovante=?,igv=?,total_pagamento=?,data_emissao=?,data_pagamento=?"+
               " where cod_pagamento=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getCod_reserva());
           pst.setString(2, dts.getTipo_comprovante());
           pst.setString(3, dts.getNum_comprovante());
           pst.setDouble(4, dts.getIgv());
           pst.setDouble(5, dts.getTotal_pagamento());
           pst.setDate(6, dts.getData_emissao());
           pst.setDate(7, dts.getData_pagamento());
           
           pst.setInt(8, dts.getCod_pagamento());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
  
   public boolean eliminar (vPagamento dts){
       sSQL="delete from pagamento where cod_pagamento=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getCod_pagamento());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
    
   
}
