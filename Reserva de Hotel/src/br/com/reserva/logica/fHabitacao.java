/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reserva.logica;

import br.com.reserva.dados.vHabitacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CARLOS
 */
public class fHabitacao {
    
   private Conexao mysql=new Conexao();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"Código","Número","Andar","Descrição","Caracteristicas","Preço","Estado","Tipo de Habitação"};
       
       String [] registro =new String [8];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from habitacao where piso like '%"+ buscar + "%' order by cod_habitacao";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("cod_habitacao");
               registro [1]=rs.getString("numero");
               registro [2]=rs.getString("piso");
               registro [3]=rs.getString("descricao");
               registro [4]=rs.getString("caracteristicas");
               registro [5]=rs.getString("preco_diaria");
               registro [6]=rs.getString("estado");
               registro [7]=rs.getString("tipo_habitacao");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
     } 
   
   
   public DefaultTableModel mostrarvista(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"Código","Número","Andar","Descrição","Caracteristicas","Preço","Estado","Tipo de Habitação"};
       
       String [] registro =new String [8];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from habitacao where piso like '%"+ buscar + "%' and estado='Disponivel' order by cod_habitacao";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("cod_habitacao");
               registro [1]=rs.getString("numero");
               registro [2]=rs.getString("piso");
               registro [3]=rs.getString("descricao");
               registro [4]=rs.getString("caracteristicas");
               registro [5]=rs.getString("preco_diaria");
               registro [6]=rs.getString("estado");
               registro [7]=rs.getString("tipo_habitacao");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
     } 
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   public boolean insertar (vHabitacao dts){
       sSQL="insert into habitacao (numero,piso,descricao,caracteristicas,preco_diaria,estado,tipo_habitacao)" +
               "values (?,?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNumero());
           pst.setString(2, dts.getPiso());
           pst.setString(3, dts.getDescricao());
           pst.setString(4, dts.getCaracteristicas());
           pst.setDouble(5, dts.getPreco_diaria());
           pst.setString(6, dts.getEstado());
           pst.setString(7, dts.getTipo_habitacao());
           
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
   
   public boolean editar (vHabitacao dts){
       sSQL="update habitacao set numero=?,piso=?,descricao=?,caracteristicas=?,preco_diaria=?,estado=?,tipo_habitacao=?"+
               " where cod_habitacao=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNumero());
           pst.setString(2, dts.getPiso());
           pst.setString(3, dts.getDescricao());
           pst.setString(4, dts.getCaracteristicas());
           pst.setDouble(5, dts.getPreco_diaria());
           pst.setString(6, dts.getEstado());
           pst.setString(7, dts.getTipo_habitacao());
           pst.setInt(8, dts.getCod_habitacao());
           
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
  
   public boolean desocupar (vHabitacao dts){
       sSQL="update habitacao set estado='Disponivel'"+
               " where cod_habitacao=?";
           //alt + 39
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
          
           pst.setInt(1, dts.getCod_habitacao());
           
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
  
   
   public boolean ocupar (vHabitacao dts){
       sSQL="update habitacao set estado='Ocupado'"+
               " where cod_habitacao=?";
           //alt + 39
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
          
           pst.setInt(1, dts.getCod_habitacao());
           
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
  
   
   
   
   public boolean eliminar (vHabitacao dts){
       sSQL="delete from habitacao where cod_habitacao=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getCod_habitacao());
           
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
