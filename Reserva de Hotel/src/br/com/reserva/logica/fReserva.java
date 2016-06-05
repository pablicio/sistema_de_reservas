/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reserva.logica;

import br.com.reserva.dados.vHabitacao;
import br.com.reserva.dados.vProduto;
import br.com.reserva.dados.vReserva;
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
public class fReserva {
    
   private Conexao mysql=new Conexao();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"Código","Código Quarto","Numero","Código Cliente","Cliente","Código Funcionário","Funcionário","Tipo Reserva","Data Reserva","Data Entrada","Data Saída","Custo","Estado"};
       
       String [] registro =new String [13];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select r.cod_reserva,r.cod_habitacao,h.numero,r.cod_cliente,"+
               "(select nome from pessoa where cod_pessoa=r.cod_cliente)as clienten,"+
               "(select pai from pessoa where cod_pessoa=r.cod_cliente)as clienteap,"+
               "r.cod_funcionario,(select nome from pessoa where cod_pessoa=r.cod_funcionario)as funcionarion,"+
               "(select pai from pessoa where cod_pessoa=r.cod_funcionario)as funcionarioap,"+
               "r.tipo_reserva,r.data_reserva,r.da"
               + "ta_entrada,r.data_saida,"+
               "r.custo_hospedagem,r.estado from reserva r inner join habitacao h on r.cod_habitacao=h.cod_habitacao where r.data_reserva like '%"+ buscar + "%' order by cod_reserva desc";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("cod_reserva");
               registro [1]=rs.getString("cod_habitacao");
               registro [2]=rs.getString("numero");
               registro [3]=rs.getString("cod_cliente");
               registro [4]=rs.getString("clienten") + " " + rs.getString("clienteap") ;
               registro [5]=rs.getString("cod_funcionario");
               registro [6]=rs.getString("funcionarion") + " " + rs.getString("funcionarioap");
               registro [7]=rs.getString("tipo_reserva");
               registro [8]=rs.getString("data_reserva");
               registro [9]=rs.getString("data_entrada");
               registro [10]=rs.getString("data_saida");
               registro [11]=rs.getString("custo_hospedagem");
               registro [12]=rs.getString("estado");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
       
       
       
   } 
   
   public boolean insertar (vReserva dts){
       sSQL="insert into reserva (cod_habitacao,cod_cliente,cod_funcionario,tipo_reserva,data_reserva,data_entrada,data_saida,custo_hospedagem,estado)" +
               "values (?,?,?,?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getCod_habitacao());
           pst.setInt(2, dts.getCod_cliente());
           pst.setInt(3, dts.getCod_funcionario());
           pst.setString(4, dts.getTipo_reserva());
           pst.setDate(5, dts.getData_reserva());
           pst.setDate(6, dts.getData_entrada());
           pst.setDate(7, dts.getData_saida());
           pst.setDouble(8, dts.getCusto_hospedagem());
           pst.setString(9, dts.getEstado());
           
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
   
   public boolean editar (vReserva dts){
       sSQL="update reserva set cod_habitacao=?,cod_cliente=?,cod_funcionario=?,tipo_reserva=?,data_reserva=?,data_entrada=?,data_saida=?,custo_hospedagem=?,estado=?"+
               " where cod_reserva=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
             pst.setInt(1, dts.getCod_habitacao());
           pst.setInt(2, dts.getCod_cliente());
           pst.setInt(3, dts.getCod_funcionario());
           pst.setString(4, dts.getTipo_reserva());
           pst.setDate(5, dts.getData_reserva());
           pst.setDate(6, dts.getData_entrada());
           pst.setDate(7, dts.getData_saida());
           pst.setDouble(8, dts.getCusto_hospedagem());
           pst.setString(9, dts.getEstado());
           
           pst.setInt(10, dts.getCod_reserva());
           
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
   
   public boolean pagar (vReserva dts){
       sSQL="update reserva set estado='Paga'"+
               " where cod_reserva=?";
           //alt + 39
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
             
           
           pst.setInt(1, dts.getCod_reserva());
           
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
   
   
   
   
   
  
   public boolean eliminar (vReserva dts){
       sSQL="delete from reserva where cod_reserva=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getCod_reserva());
           
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
