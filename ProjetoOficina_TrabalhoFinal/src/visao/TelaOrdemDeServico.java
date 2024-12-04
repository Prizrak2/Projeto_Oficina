/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package visao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.OrdemDeServico;
import modelos.ICrud;
import modelos.Veiculo;
import modelos.enums.StatusEnum;
import persistencia.OrdemDeServicoDAO;
import persistencia.VeiculoDAO;

/**
 *
 * @author misuka
 */
public class TelaOrdemDeServico extends javax.swing.JInternalFrame {

    private Date dataAtual = null;
    private ICrud<Veiculo> veiculoDB = null;
    private ICrud<OrdemDeServico> ordemDB = null;
    
    public TelaOrdemDeServico() {
        initComponents();
        try {
            dataAtual = jCalendar_DataInicio.getDate();
            veiculoDB = new VeiculoDAO();
            ordemDB = new OrdemDeServicoDAO();
          
            List<Veiculo> listaDeVeiculo = veiculoDB.listar();
            jComboBox_Veiculo.removeAllItems();
            for(int pos = 0; pos < listaDeVeiculo.size(); pos++){
                jComboBox_Veiculo.addItem(listaDeVeiculo.get(pos).toString());
            }
            
            jComboBox_Status.removeAll();
            for(StatusEnum status : StatusEnum.values()){
                jComboBox_Status.addItem(status.getDescricao());
            }
            jTextField_Diferenca.setEditable(false);
            mostrarNaGrid();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Construtor Tela: "+erro.getMessage());
        }
    }
    
    private void limparTela(){
        jCalendar_DataInicio.setDate(dataAtual);
        jCalendar_DataFim.setDate(dataAtual);
        jComboBox_Veiculo.setSelectedIndex(0);
        jComboBox_Status.setSelectedIndex(0);
        jTextField_ValorTotal.setText("");
        jTextField_ID.setText("");
        jTextField_ValorPago.setText("");
        jTextField_Diferenca.setText("");
    }
    
    private void mostrarNaGrid(){
        try {
            List<OrdemDeServico> listaDeOrdem = null;
            listaDeOrdem = ordemDB.listar();
            DefaultTableModel model =  (DefaultTableModel) jTable_Saida.getModel();
            model.setNumRows(0); 
            if(listaDeOrdem.isEmpty()) throw new Exception("Lista de Oficina BD Vazia");

            jTable_Saida.setRowHeight(75);
            for(int j = 0; j<8;j++){
                jTable_Saida.getColumnModel().getColumn(j).setCellRenderer(new MultiLineTableCellRenderer());
            }
            for(int pos = 0; pos < listaDeOrdem.size(); pos++){
                OrdemDeServico objOrdem = listaDeOrdem.get(pos);
                String[] saida = new String[8];
                saida[0] = objOrdem.getIdOrdem()+"";
                saida[1] = objOrdem.getStatus();
                saida[2] = objOrdem.getDataInicio()+"";
                saida[3] = objOrdem.getDataFim()+"";
                saida[4] = objOrdem.getValorTotal();
                saida[5] = objOrdem.getValorPago();
                saida[6] = objOrdem.getDiferenca();
                saida[7] = objOrdem.getVeiculo().toString();
                model.addRow(saida);
            }  
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jTextField_ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_Status = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField_ValorTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_ValorPago = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_Diferenca = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_Veiculo = new javax.swing.JComboBox<>();
        jButton_Incluir = new javax.swing.JButton();
        jButton_Alterar = new javax.swing.JButton();
        jButton_Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Saida = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jCalendar_DataInicio = new com.toedter.calendar.JCalendar();
        jLabel8 = new javax.swing.JLabel();
        jCalendar_DataFim = new com.toedter.calendar.JCalendar();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setText("Valor Total");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setText("Valor Pago");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setText("Diferença");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setText("Veículo");

        jButton_Incluir.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton_Incluir.setText("Incluir");
        jButton_Incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IncluirActionPerformed(evt);
            }
        });

        jButton_Alterar.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton_Alterar.setText("Alterar");
        jButton_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AlterarActionPerformed(evt);
            }
        });

        jButton_Buscar.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton_Buscar.setText("Buscar");
        jButton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarActionPerformed(evt);
            }
        });

        jTable_Saida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Status", "Data Inicio", "Data Fim", "Valor Total", "Valor Pago", "Diferença", "Veiculo"
            }
        ));
        jTable_Saida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_SaidaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Saida);
        if (jTable_Saida.getColumnModel().getColumnCount() > 0) {
            jTable_Saida.getColumnModel().getColumn(0).setMinWidth(50);
            jTable_Saida.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable_Saida.getColumnModel().getColumn(1).setMinWidth(120);
            jTable_Saida.getColumnModel().getColumn(1).setMaxWidth(120);
            jTable_Saida.getColumnModel().getColumn(2).setMinWidth(120);
            jTable_Saida.getColumnModel().getColumn(2).setMaxWidth(120);
            jTable_Saida.getColumnModel().getColumn(3).setMinWidth(120);
            jTable_Saida.getColumnModel().getColumn(3).setMaxWidth(120);
            jTable_Saida.getColumnModel().getColumn(4).setMinWidth(90);
            jTable_Saida.getColumnModel().getColumn(4).setMaxWidth(90);
            jTable_Saida.getColumnModel().getColumn(5).setMinWidth(90);
            jTable_Saida.getColumnModel().getColumn(5).setMaxWidth(90);
            jTable_Saida.getColumnModel().getColumn(6).setMinWidth(90);
            jTable_Saida.getColumnModel().getColumn(6).setMaxWidth(90);
        }

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setText("Data Inicial");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel8.setText("Data Final");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Diferenca))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_ValorPago))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_ValorTotal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_Status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jButton_Incluir))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox_Veiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton_Alterar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton_Buscar)))))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCalendar_DataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jCalendar_DataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_ValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_ValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_Diferenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox_Veiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Incluir)
                            .addComponent(jButton_Alterar)
                            .addComponent(jButton_Buscar)))
                    .addComponent(jCalendar_DataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCalendar_DataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IncluirActionPerformed
        // TODO add your handling code here:
        try {
            OrdemDeServico objeto = new OrdemDeServico();
            objeto.setIdOrdem(Integer.parseInt(jTextField_ID.getText()));
            objeto.setDataInicio(jCalendar_DataInicio.getDate());
            objeto.setDataFim(jCalendar_DataFim.getDate());
            
            objeto.setVeiculo(new Veiculo(jComboBox_Veiculo.getSelectedItem().toString().split("-")[0]));
            
            objeto.setValorTotal(jTextField_ValorTotal.getText().replace(",", "."));
            float valorTotal = Float.parseFloat(jTextField_ValorTotal.getText().replace(",", "."));
            objeto.setValorPago(jTextField_ValorPago.getText().replace(",", "."));
            float valorPago = Float.parseFloat(jTextField_ValorPago.getText().replace(",", "."));
            float diferenca = valorTotal - valorPago;
            if(diferenca < 0.0) throw new Exception("O Valor Pago não pode ser maior que o valor total");
            objeto.setDiferenca(diferenca+"");
            
            objeto.setStatus(jComboBox_Status.getSelectedItem().toString());
            
            ordemDB.incluir(objeto);
            limparTela();
            mostrarNaGrid();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao incluir Ordem de Serviço: " + erro.getMessage());
        }
    }//GEN-LAST:event_jButton_IncluirActionPerformed

    private void jButton_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AlterarActionPerformed
        // TODO add your handling code here:
        try {
            OrdemDeServico objeto = new OrdemDeServico();
            objeto.setIdOrdem(Integer.parseInt(jTextField_ID.getText()));
            objeto.setDataInicio(jCalendar_DataInicio.getDate());
            objeto.setDataFim(jCalendar_DataFim.getDate());
            
            objeto.setVeiculo(new Veiculo(jComboBox_Veiculo.getSelectedItem().toString().split("-")[0]));
            
            objeto.setValorTotal(jTextField_ValorTotal.getText().replace(",", "."));
            float valorTotal = Float.parseFloat(jTextField_ValorTotal.getText().replace(",", "."));
            objeto.setValorPago(jTextField_ValorPago.getText().replace(",", "."));
            float valorPago = Float.parseFloat(jTextField_ValorPago.getText().replace(",", "."));
            float diferenca = valorTotal - valorPago;
            if(diferenca < 0.0) throw new Exception("O Valor Pago não pode ser maior que o valor total");
            objeto.setDiferenca(diferenca+"");
            objeto.setStatus(jComboBox_Status.getSelectedItem().toString());
            ordemDB.alterar(objeto);
            limparTela();
            mostrarNaGrid();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao alterar Ordem de Serviço: " + erro.getMessage());
        }
    }//GEN-LAST:event_jButton_AlterarActionPerformed

    private void jButton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarActionPerformed
        // TODO add your handling code here:
        try {
            OrdemDeServico objeto = ordemDB.consultar(new OrdemDeServico(Integer.parseInt(jTextField_ID.getText())));

            jTextField_ID.setText(objeto.getIdOrdem()+"");

            jCalendar_DataInicio.setDate(objeto.getDataInicio());
            jCalendar_DataFim.setDate(objeto.getDataFim());

            jComboBox_Veiculo.setSelectedItem(objeto.getVeiculo().toString());
            jComboBox_Status.setSelectedItem(objeto.getStatus());
            
            jTextField_ValorTotal.setText(objeto.getValorTotal().replace("R$", "").trim());
            jTextField_ValorPago.setText(objeto.getValorPago().replace("R$", "").trim());
            jTextField_Diferenca.setText(objeto.getDiferenca().replace("R$", "").trim());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao buscar proprietário: " + erro.getMessage());
        }
    }//GEN-LAST:event_jButton_BuscarActionPerformed

    private void jTable_SaidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_SaidaMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable_Saida.getModel();
        int selectedRowIndex = jTable_Saida.getSelectedRow();
        
        jTextField_ID.setText(model.getValueAt(selectedRowIndex, 0).toString());
        jComboBox_Status.setSelectedItem(model.getValueAt(selectedRowIndex, 1).toString());
        
        String strDataInicio = (String) model.getValueAt(selectedRowIndex, 2);
        String[] vetDataInicio = strDataInicio.split("-");
        Calendar dataInicio = Calendar.getInstance();
        dataInicio.set(Calendar.YEAR, Integer.parseInt(vetDataInicio[0]));
        dataInicio.set(Calendar.MONTH, Integer.parseInt(vetDataInicio[1]) - 1);
        dataInicio.set(Calendar.DAY_OF_MONTH, Integer.parseInt(vetDataInicio[2]));
        jCalendar_DataInicio.setDate(dataInicio.getTime());
        
        String strDataFim = (String) model.getValueAt(selectedRowIndex, 3);
        String[] vetDataFim = strDataFim.split("-");
        Calendar dataFim = Calendar.getInstance();
        dataFim.set(Calendar.YEAR, Integer.parseInt(vetDataFim[0]));
        dataFim.set(Calendar.MONTH, Integer.parseInt(vetDataFim[1]) - 1);
        dataFim.set(Calendar.DAY_OF_MONTH, Integer.parseInt(vetDataFim[2]));
        jCalendar_DataFim.setDate(dataFim.getTime());
        
        jTextField_ValorTotal.setText(model.getValueAt(selectedRowIndex, 4).toString().replace("R$", "").trim());
        jTextField_ValorPago.setText(model.getValueAt(selectedRowIndex, 5).toString().replace("R$", "").trim());
        jTextField_Diferenca.setText(model.getValueAt(selectedRowIndex, 6).toString().replace("R$", "").trim());
        jComboBox_Veiculo.setSelectedItem(model.getValueAt(selectedRowIndex, 7).toString());

    }//GEN-LAST:event_jTable_SaidaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Alterar;
    private javax.swing.JButton jButton_Buscar;
    private javax.swing.JButton jButton_Incluir;
    private com.toedter.calendar.JCalendar jCalendar_DataFim;
    private com.toedter.calendar.JCalendar jCalendar_DataInicio;
    private javax.swing.JComboBox<String> jComboBox_Status;
    private javax.swing.JComboBox<String> jComboBox_Veiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Saida;
    private javax.swing.JTextField jTextField_Diferenca;
    private javax.swing.JTextField jTextField_ID;
    private javax.swing.JTextField jTextField_ValorPago;
    private javax.swing.JTextField jTextField_ValorTotal;
    // End of variables declaration//GEN-END:variables
}