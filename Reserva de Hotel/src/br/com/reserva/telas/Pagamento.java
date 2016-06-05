/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reserva.telas;

import br.com.reserva.dados.vHabitacao;
import br.com.reserva.dados.vPagamento;
import br.com.reserva.dados.vReserva;
import br.com.reserva.logica.Conexao;
import br.com.reserva.logica.fConsumo;
import br.com.reserva.logica.fHabitacao;
import br.com.reserva.logica.fPagamento;
import br.com.reserva.logica.fProduto;
import br.com.reserva.logica.fReserva;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author CARLOS
 */
public class Pagamento extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmPago
     */
    public Pagamento() {
        initComponents();
        mostrar(idreserva);
        inhabilitar();
        tCodReserva.setText(idreserva);
        tCliente.setText(cliente);
        tHabitacao.setText(habitacion);
        tCodHabitacao.setText(idhabitacion);
        tTotalReserva.setText(Double.toString(totalreserva));

        fConsumo func = new fConsumo();
        func.mostrar(idreserva);

        tTotalPagamento.setText(Double.toString(totalreserva + func.totalconsumo));

    }

    private String accion = "guardar";
    public static String idreserva;
    public static String cliente;
    public static String idhabitacion;
    public static String habitacion;
    public static Double totalreserva;

    void ocultar_columnas() {
        tabela.getColumnModel().getColumn(0).setMaxWidth(0);
        tabela.getColumnModel().getColumn(0).setMinWidth(0);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(0);

        tabela.getColumnModel().getColumn(1).setMaxWidth(0);
        tabela.getColumnModel().getColumn(1).setMinWidth(0);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    void ocultar_columnasconsumo() {
        tabelaConsumo.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelaConsumo.getColumnModel().getColumn(0).setMinWidth(0);
        tabelaConsumo.getColumnModel().getColumn(0).setPreferredWidth(0);

        tabelaConsumo.getColumnModel().getColumn(1).setMaxWidth(0);
        tabelaConsumo.getColumnModel().getColumn(1).setMinWidth(0);
        tabelaConsumo.getColumnModel().getColumn(1).setPreferredWidth(0);

        tabelaConsumo.getColumnModel().getColumn(2).setMaxWidth(0);
        tabelaConsumo.getColumnModel().getColumn(2).setMinWidth(0);
        tabelaConsumo.getColumnModel().getColumn(2).setPreferredWidth(0);
    }

    void inhabilitar() {
        tPagamento.setVisible(false);

        tCodReserva.setVisible(false);
        tCliente.setEnabled(false);
        tNumComprovante.setEnabled(false);
        cbTipoPagamento.setEnabled(false);
        tIgv.setEnabled(false);
        tTotalPagamento.setEnabled(false);
        tTotalReserva.setEnabled(false);
        dcDataEmissao.setEnabled(false);
        dcDataPagamento.setEnabled(false);

        tCodHabitacao.setVisible(false);
        tHabitacao.setEnabled(false);

        btSalvar.setEnabled(false);
        btCancelar.setEnabled(false);
        btExcluir.setEnabled(false);
        tPagamento.setText("");
        tNumComprovante.setText("");
        tIgv.setText("");
        tTotalPagamento.setText("");

    }

    void habilitar() {
        tPagamento.setVisible(false);

        tCodReserva.setVisible(true);
        tCliente.setEnabled(true);
        tNumComprovante.setEnabled(true);
        cbTipoPagamento.setEnabled(true);
        tIgv.setEnabled(true);
        tTotalPagamento.setEnabled(true);
        tTotalReserva.setEnabled(true);
        dcDataEmissao.setEnabled(true);
        dcDataPagamento.setEnabled(true);

        tCodHabitacao.setVisible(true);
        tHabitacao.setEnabled(true);

        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);
        btExcluir.setEnabled(true);
        tPagamento.setText("");
        tNumComprovante.setText("");
        tIgv.setText("");
        //txttotal_pago.setText("");

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fPagamento func = new fPagamento();
            modelo = func.mostrar(buscar);

            tabela.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Pagos " + Integer.toString(func.totalregistros));

            //Mostrar los datos de los consumos
            fConsumo func2 = new fConsumo();
            modelo = func2.mostrar(buscar);
            tabelaConsumo.setModel(modelo);
            ocultar_columnasconsumo();

            lbltotalregistrosconsumo.setText("Total Consumos " + func2.totalregistros);
            lbltotalconsumo.setText("Consumo Total: $." + func2.totalconsumo);

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

        txttotal_reserva = new javax.swing.JPanel();
        tPagamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tCodReserva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tNumComprovante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbTipoPagamento = new javax.swing.JComboBox();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        tCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tTotalReserva = new javax.swing.JTextField();
        tCodHabitacao = new javax.swing.JTextField();
        tHabitacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tIgv = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tTotalPagamento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dcDataEmissao = new com.toedter.calendar.JDateChooser();
        dcDataPagamento = new com.toedter.calendar.JDateChooser();
        btImprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btExcluir = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaConsumo = new javax.swing.JTable();
        lbltotalregistrosconsumo = new javax.swing.JLabel();
        lbltotalconsumo = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        txttotal_reserva.setBackground(new java.awt.Color(194, 206, 241));
        txttotal_reserva.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Pagamentos"));

        jLabel2.setText("Reserva:");

        tCodReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCodReservaActionPerformed(evt);
            }
        });

        jLabel4.setText("Habitação:");

        jLabel6.setText("N° do Comprovante:");

        tNumComprovante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNumComprovanteActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo de Comprovante:");

        cbTipoPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Boleto", "Fatura", "Ticket", "Outro" }));
        cbTipoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoPagamentoActionPerformed(evt);
            }
        });

        btNovo.setBackground(new java.awt.Color(51, 51, 51));
        btNovo.setForeground(new java.awt.Color(255, 255, 255));
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/reserva/imagens/novo.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setBackground(new java.awt.Color(51, 51, 51));
        btSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/reserva/imagens/salvar.png"))); // NOI18N
        btSalvar.setText("Salvar");
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

        jLabel3.setText("Total Reserva:");

        tCodHabitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCodHabitacaoActionPerformed(evt);
            }
        });

        jLabel8.setText("Igv:");

        tIgv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIgvActionPerformed(evt);
            }
        });

        jLabel10.setText("Total Pago:");

        tTotalPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tTotalPagamentoActionPerformed(evt);
            }
        });

        jLabel5.setText("Data de Emissão:");

        jLabel11.setText("Data de Pagamento:");

        btImprimir.setBackground(new java.awt.Color(51, 51, 51));
        btImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/reserva/imagens/print.png"))); // NOI18N
        btImprimir.setText("Imprimir");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txttotal_reservaLayout = new javax.swing.GroupLayout(txttotal_reserva);
        txttotal_reserva.setLayout(txttotal_reservaLayout);
        txttotal_reservaLayout.setHorizontalGroup(
            txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txttotal_reservaLayout.createSequentialGroup()
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txttotal_reservaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addGap(0, 417, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txttotal_reservaLayout.createSequentialGroup()
                        .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)))
                            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                .addComponent(tNumComprovante, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tIgv))
                            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                .addComponent(tCodReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tCliente))
                            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                .addComponent(tCodHabitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tHabitacao))
                            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tTotalReserva, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTipoPagamento, 0, 120, Short.MAX_VALUE)
                                    .addComponent(tTotalPagamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dcDataEmissao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dcDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(58, 58, 58))
        );
        txttotal_reservaLayout.setVerticalGroup(
            txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                .addComponent(tPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCodReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tTotalReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tCodHabitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tHabitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNumComprovante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(tIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tTotalPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(14, 14, 14)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dcDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar)
                    .addComponent(btImprimir))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pagamentos");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Pagamentos"));

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
        btExcluir.setText("Excluir");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btExcluir)
                                .addGap(54, 54, 54)
                                .addComponent(btSair)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btSair))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(lbltotalregistros))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Consumos"));

        tabelaConsumo.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaConsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaConsumoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelaConsumo);

        lbltotalregistrosconsumo.setText("Registros");

        lbltotalconsumo.setText("jLabel12");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbltotalconsumo)
                        .addGap(48, 48, 48)
                        .addComponent(lbltotalregistrosconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotalregistrosconsumo)
                    .addComponent(lbltotalconsumo)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txttotal_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txttotal_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tCodReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCodReservaActionPerformed
        // TODO add your handling code here:
        tCodReserva.transferFocus();
    }//GEN-LAST:event_tCodReservaActionPerformed

    private void tNumComprovanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNumComprovanteActionPerformed
        // TODO add your handling code here:
        tNumComprovante.transferFocus();
    }//GEN-LAST:event_tNumComprovanteActionPerformed

    private void cbTipoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoPagamentoActionPerformed
        // TODO add your handling code here:
        cbTipoPagamento.transferFocus();
    }//GEN-LAST:event_cbTipoPagamentoActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btSalvar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:
        if (tIgv.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el igv del Comprobante de pago a generar");
            tIgv.requestFocus();
            return;
        }
        if (tTotalPagamento.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el total de pago del comprobante");
            tTotalPagamento.requestFocus();
            return;
        }

        if (tNumComprovante.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Número de Comprobante del Pago");
            tNumComprovante.requestFocus();
            return;
        }

        vPagamento dts = new vPagamento();
        fPagamento func = new fPagamento();

        dts.setCod_reserva(Integer.parseInt(tCodReserva.getText()));

        int seleccionado = cbTipoPagamento.getSelectedIndex();
        dts.setTipo_comprovante((String) cbTipoPagamento.getItemAt(seleccionado));

        dts.setNum_comprovante(tNumComprovante.getText());
        dts.setIgv(Double.parseDouble(tIgv.getText()));
        dts.setTotal_pagamento(Double.parseDouble(tTotalPagamento.getText()));

        Calendar cal;
        int d, m, a;

        cal = dcDataPagamento.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;

        dts.setData_pagamento(new Date(a, m, d));

        cal = dcDataEmissao.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;

        dts.setData_emissao(new Date(a, m, d));

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, " El pago por $. " + tTotalPagamento.getText()
                        + " del Sr. " + tCliente.getText() + " Ha sido realizado con Éxito");
                mostrar(idreserva);
                inhabilitar();

                //Desocupar la Habitación
                fHabitacao func2 = new fHabitacao();
                vHabitacao dts2 = new vHabitacao();

                dts2.setCod_habitacao(Integer.parseInt(tCodHabitacao.getText()));
                func2.desocupar(dts2);

                //Cancelar o pagar la reserva
                fReserva func3 = new fReserva();
                vReserva dts3 = new vReserva();

                dts3.setCod_reserva(Integer.parseInt(tCodReserva.getText()));
                func3.pagar(dts3);

            }

        } else if (accion.equals("editar")) {
            dts.setCod_pagamento(Integer.parseInt(tPagamento.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El pago del Sr. "
                        + tCliente.getText() + " Ha sido Modificado Correctamente");
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

        tPagamento.setText(tabela.getValueAt(fila, 0).toString());
        //txtidreserva.setText(tablalistado.getValueAt(fila, 1).toString());

        cbTipoPagamento.setSelectedItem(tabela.getValueAt(fila, 2).toString());
        tNumComprovante.setText(tabela.getValueAt(fila, 3).toString());
        tIgv.setText(tabela.getValueAt(fila, 4).toString());
        tTotalPagamento.setText(tabela.getValueAt(fila, 5).toString());

        dcDataEmissao.setDate(Date.valueOf(tabela.getValueAt(fila, 6).toString()));
        dcDataPagamento.setDate(Date.valueOf(tabela.getValueAt(fila, 7).toString()));


    }//GEN-LAST:event_tabelaMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        if (!tPagamento.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el Pago seleccionado?", "Confirmar", 2);

            if (confirmacion == 0) {
                fPagamento func = new fPagamento();
                vPagamento dts = new vPagamento();

                dts.setCod_pagamento(Integer.parseInt(tPagamento.getText()));
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

    private void tCodHabitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCodHabitacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCodHabitacaoActionPerformed

    private void tIgvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIgvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIgvActionPerformed

    private void tTotalPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tTotalPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tTotalPagamentoActionPerformed

    private void tabelaConsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaConsumoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaConsumoMouseClicked
    private Connection connection = new Conexao().conectar();

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed

        if (!tPagamento.getText().equals("")) {
            Map p = new HashMap();
            p.put("cod_pagamento", tPagamento.getText());
            try {
                System.out.println(new File("").getAbsolutePath());
                JasperReport report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        + "\\src\\br\\com\\reserva\\relatorios\\rpComprovante.jrxml");
                JasperPrint print = JasperFillManager.fillReport(report, p, connection);
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Comprovante");
                view.setVisible(true);
                view.toFront();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbTipoPagamento;
    private com.toedter.calendar.JDateChooser dcDataEmissao;
    private com.toedter.calendar.JDateChooser dcDataPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbltotalconsumo;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JLabel lbltotalregistrosconsumo;
    private javax.swing.JTextField tCliente;
    private javax.swing.JTextField tCodHabitacao;
    private javax.swing.JTextField tCodReserva;
    private javax.swing.JTextField tHabitacao;
    private javax.swing.JTextField tIgv;
    private javax.swing.JTextField tNumComprovante;
    private javax.swing.JTextField tPagamento;
    private javax.swing.JTextField tTotalPagamento;
    private javax.swing.JTextField tTotalReserva;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabelaConsumo;
    private javax.swing.JPanel txttotal_reserva;
    // End of variables declaration//GEN-END:variables
}
