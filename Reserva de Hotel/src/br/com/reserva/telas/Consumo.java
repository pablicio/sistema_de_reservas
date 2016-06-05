/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reserva.telas;

import br.com.reserva.dados.vConsumo;
import br.com.reserva.logica.fConsumo;
import br.com.reserva.logica.fProduto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CARLOS
 */
public class Consumo extends javax.swing.JInternalFrame {

    public static String idreserva;
    public static String cliente;

    /**
     * Creates new form frmConsumo
     */
    public Consumo() {
        initComponents();
        mostrar(idreserva);
        tCliente.setText(cliente);
        tCodReserva.setText(idreserva);
        inhabilitar();

    }
    private String accion = "guardar";

    void ocultar_columnas() {
        tabela.getColumnModel().getColumn(0).setMaxWidth(0);
        tabela.getColumnModel().getColumn(0).setMinWidth(0);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(0);

        tabela.getColumnModel().getColumn(1).setMaxWidth(0);
        tabela.getColumnModel().getColumn(1).setMinWidth(0);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(0);

        tabela.getColumnModel().getColumn(2).setMaxWidth(0);
        tabela.getColumnModel().getColumn(2).setMinWidth(0);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(0);
    }

    void inhabilitar() {
        tConsumo.setVisible(false);

        tCodReserva.setVisible(false);
        tCliente.setEnabled(false);
        tCodProduto.setVisible(false);
        tProduto.setEnabled(false);
        tQuantidade.setEnabled(false);

        tPrecoVenda.setEnabled(false);
        cbEstado.setEnabled(false);

        btSalvar.setEnabled(false);
        btCancelar.setEnabled(false);
        btExcluir.setEnabled(false);

        tConsumo.setText("");
        tPrecoVenda.setText("");
        tCodProduto.setText("");
        tProduto.setText("");
        tQuantidade.setText("");

    }

    void habilitar() {
        tConsumo.setVisible(true);

        tCodReserva.setVisible(false);
        tCliente.setEnabled(false);
        tCodProduto.setVisible(false);
        tProduto.setEnabled(true);
        tQuantidade.setEnabled(true);

        tPrecoVenda.setEnabled(true);
        cbEstado.setEnabled(true);

        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);
        btExcluir.setEnabled(true);

        tConsumo.setText("");
        tPrecoVenda.setText("");
        tCodProduto.setText("");
        tProduto.setText("");
        tQuantidade.setText("");

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fConsumo func = new fConsumo();
            modelo = func.mostrar(buscar);

            tabela.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));
            lblconsumo.setText("Consumo Total $. " + func.totalconsumo);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tConsumo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tCodReserva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tPrecoVenda = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        tCliente = new javax.swing.JTextField();
        tCodProduto = new javax.swing.JTextField();
        tProduto = new javax.swing.JTextField();
        btBuscarProduto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tQuantidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btExcluir = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        lblconsumo = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(194, 206, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Consumos"));

        tConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tConsumoActionPerformed(evt);
            }
        });

        jLabel2.setText("Reserva:");

        tCodReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCodReservaActionPerformed(evt);
            }
        });

        jLabel4.setText("Produto:");

        jLabel6.setText("Preço de Venda:");

        tPrecoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPrecoVendaActionPerformed(evt);
            }
        });

        jLabel7.setText("Estado:");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aceito", "Cancelado" }));
        cbEstado.setToolTipText("");
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        btNovo.setBackground(new java.awt.Color(51, 51, 51));
        btNovo.setForeground(new java.awt.Color(255, 255, 255));
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/reserva/imagens/novo.png"))); // NOI18N
        btNovo.setText("Nuevo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setBackground(new java.awt.Color(51, 51, 51));
        btSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/reserva/imagens/salvar.png"))); // NOI18N
        btSalvar.setText("Guardar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/reserva/imagens/cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        tCodProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCodProdutoActionPerformed(evt);
            }
        });

        tProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tProdutoActionPerformed(evt);
            }
        });

        btBuscarProduto.setText("...");
        btBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarProdutoActionPerformed(evt);
            }
        });

        jLabel5.setText("Quantidade:");

        tQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tQuantidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tCodReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tQuantidade)
                            .addComponent(tPrecoVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(98, 98, 98)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tCodReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btBuscarProduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(116, 116, 116)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCancelar)
                            .addComponent(btSalvar)
                            .addComponent(btNovo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Consumo");
        jLabel1.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Consumos"));
        jPanel2.setToolTipText("");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabela);

        btExcluir.setBackground(new java.awt.Color(51, 51, 51));
        btExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/reserva/imagens/excluir.png"))); // NOI18N
        btExcluir.setText("Eliminar");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btSair.setBackground(new java.awt.Color(51, 51, 51));
        btSair.setForeground(new java.awt.Color(255, 255, 255));
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/reserva/imagens/fim.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        lbltotalregistros.setText("Registros");

        lblconsumo.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addComponent(lblconsumo)
                .addGap(54, 54, 54)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btSair))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btSair))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotalregistros)
                    .addComponent(lblconsumo)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tCodReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCodReservaActionPerformed
        // TODO add your handling code here:
        tCodReserva.transferFocus();
    }//GEN-LAST:event_tCodReservaActionPerformed

    private void tPrecoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPrecoVendaActionPerformed
        // TODO add your handling code here:
        tPrecoVenda.transferFocus();
    }//GEN-LAST:event_tPrecoVendaActionPerformed

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        // TODO add your handling code here:
        cbEstado.transferFocus();
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btSalvar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:
        if (tCodProduto.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes Seleccionar un producto");
            btBuscarProduto.requestFocus();
            return;
        }
        if (tQuantidade.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar una cantidad de consumo");
            tQuantidade.requestFocus();
            return;
        }

        if (tPrecoVenda.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un precio de venta del producto");
            tPrecoVenda.requestFocus();
            return;
        }

        vConsumo dts = new vConsumo();
        fConsumo func = new fConsumo();

        dts.setCod_reserva(Integer.parseInt(tCodReserva.getText()));
        dts.setCod_produto(Integer.parseInt(tCodProduto.getText()));
        dts.setQuantidade(Double.parseDouble(tQuantidade.getText()));
        dts.setPreco_venda(Double.parseDouble(tPrecoVenda.getText()));

        int seleccionado = cbEstado.getSelectedIndex();
        dts.setEstado((String) cbEstado.getItemAt(seleccionado));

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "el consumo " + tProduto.getText() + " del cliente "
                        + tCliente.getText() + " Ha sido registrado correctamente");
                mostrar(idreserva);
                inhabilitar();

            }

        } else if (accion.equals("editar")) {
            dts.setCod_consumo(Integer.parseInt(tConsumo.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El consumo del cliente "
                        + tCliente.getText() + " ha sido modificado correctamente ");
                mostrar(idreserva);
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
        btSalvar.setText("Editar");
        habilitar();
        btExcluir.setEnabled(true);
        accion = "editar";

        int fila = tabela.rowAtPoint(evt.getPoint());

        tConsumo.setText(tabela.getValueAt(fila, 0).toString());
        tCodReserva.setText(tabela.getValueAt(fila, 1).toString());
        tCodProduto.setText(tabela.getValueAt(fila, 2).toString());
        tProduto.setText(tabela.getValueAt(fila, 3).toString());
        tQuantidade.setText(tabela.getValueAt(fila, 4).toString());
        tPrecoVenda.setText(tabela.getValueAt(fila, 5).toString());

        cbEstado.setSelectedItem(tabela.getValueAt(fila, 6).toString());


    }//GEN-LAST:event_tabelaMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        if (!tConsumo.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el Producto?", "Confirmar", 2);

            if (confirmacion == 0) {
                fConsumo func = new fConsumo();
                vConsumo dts = new vConsumo();

                dts.setCod_consumo(Integer.parseInt(tConsumo.getText()));
                func.eliminar(dts);
                mostrar(idreserva);
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void tCodProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCodProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCodProdutoActionPerformed

    private void tQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tQuantidadeActionPerformed

    private void btBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarProdutoActionPerformed
        // TODO add your handling code here:
        ProdutoVista form = new ProdutoVista();
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btBuscarProdutoActionPerformed

    private void tProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tProdutoActionPerformed

    private void tConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tConsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tConsumoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Consumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consumo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarProduto;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblconsumo;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTextField tCliente;
    public static javax.swing.JTextField tCodProduto;
    private javax.swing.JTextField tCodReserva;
    private javax.swing.JTextField tConsumo;
    public static javax.swing.JTextField tPrecoVenda;
    public static javax.swing.JTextField tProduto;
    private javax.swing.JTextField tQuantidade;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
