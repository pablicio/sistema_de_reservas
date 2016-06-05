
package br.com.reserva.logica;

import br.com.reserva.dados.vConsumo;
import br.com.reserva.dados.vHabitacao;
import br.com.reserva.dados.vProduto;
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
public class fConsumo {
    
   private Conexao mysql=new Conexao();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   public Double totalconsumo;
   
   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"Código","Código Reserva","Código Produto","Produto","Quantidade","Preço Venda","Estado"};
       
       String [] registro =new String [7];
       
       totalregistros=0;
       totalconsumo=0.0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select c.cod_consumo,c.cod_reserva,c.cod_produto,p.nome,c.quantidade,c.preco_venda "
               + ",c.estado from consumo c inner join produto p on c.cod_produto=p.cod_produto"
               + " where c.cod_reserva ="+ buscar + " order by c.cod_consumo desc";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("cod_consumo");
               registro [1]=rs.getString("cod_reserva");
               registro [2]=rs.getString("cod_produto");
               registro [3]=rs.getString("nome");
               registro [4]=rs.getString("quantidade");
               registro [5]=rs.getString("preco_venda");
               registro [6]=rs.getString("estado");
               
               totalregistros=totalregistros+1;
               totalconsumo=totalconsumo + (rs.getDouble("quantidade") * rs.getDouble("preco_venda") );
               
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
       
       
       
   } 
   
   public boolean insertar (vConsumo dts){
       sSQL="insert into consumo (cod_reserva,cod_produto,quantidade,preco_venda,estado)" +
               "values (?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getCod_reserva());
           pst.setInt(2, dts.getCod_produto());
           pst.setDouble(3, dts.getQuantidade());
           pst.setDouble(4, dts.getPreco_venda());
           pst.setString(5, dts.getEstado());
           
           
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
   
   public boolean editar (vConsumo dts){
       sSQL="update consumo set cod_reserva=?,cod_produto=?,quantidade=?,preco_venda=?,estado=?"+
               " where idconsumo=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getCod_reserva());
           pst.setInt(2, dts.getCod_produto());
           pst.setDouble(3, dts.getQuantidade());
           pst.setDouble(4, dts.getPreco_venda());
           pst.setString(5, dts.getEstado());
           
           pst.setInt(6, dts.getCod_consumo());
           
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
  
   public boolean eliminar (vConsumo dts){
       sSQL="delete from consumo where cod_consumo=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getCod_consumo());
           
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
