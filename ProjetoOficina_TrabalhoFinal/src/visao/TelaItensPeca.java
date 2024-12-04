/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package visao;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ICrud;
import modelos.ItensPeca;
import modelos.OrdemDeServico;
import modelos.Pecas;
import persistencia.ItensPecaDAO;
import persistencia.OrdemDeServicoDAO;
import persistencia.PecaDAO;

/**
 *
 * @author misuka
 */
public class TelaItensPeca extends javax.swing.JInternalFrame {

    private ICrud<Pecas> pecaDB = null;
    private ICrud<OrdemDeServico> ordemDB = null;
    private ICrud<ItensPeca> itensDB = null;
    
    public TelaItensPeca() {
        initComponents();
        try {
            ordemDB = new OrdemDeServicoDAO();
            pecaDB = new PecaDAO();
            itensDB = new ItensPecaDAO();
          
            List<Pecas> listaDePeca = pecaDB.listar();
            jComboBox_Peca.removeAllItems();
            for(int pos = 0; pos < listaDePeca.size(); pos++){
                jComboBox_Peca.addItem(listaDePeca.get(pos).toString());
            }
            
            List<OrdemDeServico> listaDeOrdem = ordemDB.listar();
            jComboBox_Ordem.removeAllItems();
            for(int pos = 0; pos < listaDeOrdem.size(); pos++){
                jComboBox_Ordem.addItem(listaDeOrdem.get(pos).toString());
            }
            
            jTextField_Quantidade.setText("0");
            jTextField_PrecoTotal.setEditable(false);
            jTextField_PrecoUnitario.setEditable(false);
            atualizarPrecos();
            mostrarNaGrid();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Construtor Tela: "+erro.getMessage());
        }
    }
    private void limparTela(){
        jTextField_ID.setText("");
        jComboBox_Peca.setSelectedIndex(0);
        jComboBox_Ordem.setSelectedIndex(0);
        jTextField_Quantidade.setText("");
        jTextField_PrecoUnitario.setText("");
        jTextField_PrecoTotal.setText("");
    }
    
    private void mostrarNaGrid(){
        try {
            List<ItensPeca> listaDeItens = null;
            listaDeItens = itensDB.listar();
            DefaultTableModel model =  (DefaultTableModel) jTable_Saida.getModel();
            model.setNumRows(0); 
            if(listaDeItens.isEmpty()) throw new Exception("Lista de Oficina BD Vazia");

            jTable_Saida.setRowHeight(75);
            for(int j = 0; j<6;j++){
                jTable_Saida.getColumnModel().getColumn(j).setCellRenderer(new MultiLineTableCellRenderer());
            }
            for(int pos = 0; pos < listaDeItens.size(); pos++){
                ItensPeca objOrdem = listaDeItens.get(pos);
                String[] saida = new String[6];
                saida[0] = objOrdem.getIdItensPeca()+"";
                saida[1] = objOrdem.getPeca().toString();
                saida[2] = objOrdem.getOrdem().toString();
                saida[3] = objOrdem.getQuantidade()+"";
                saida[4] = objOrdem.getValorUnitario();
                saida[5] = objOrdem.getValorTotal();
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
        jComboBox_Peca = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_Ordem = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextField_Quantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_PrecoUnitario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_PrecoTotal = new javax.swing.JTextField();
        jButton_Incluir = new javax.swing.JButton();
        jButton_Alterar = new javax.swing.JButton();
        jButton_Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Saida = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setText("Peça");

        jComboBox_Peca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_PecaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setText("Ordem de Serviço");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setText("Quantidade");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setText("Preço Unitário");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setText("Preço Total");

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
                "ID", "Peça", "Ordem de Serviço", "Quantidade", "Preço Unitário", "Preço Total"
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
            jTable_Saida.getColumnModel().getColumn(3).setMinWidth(80);
            jTable_Saida.getColumnModel().getColumn(3).setMaxWidth(80);
            jTable_Saida.getColumnModel().getColumn(4).setMinWidth(90);
            jTable_Saida.getColumnModel().getColumn(4).setMaxWidth(90);
            jTable_Saida.getColumnModel().getColumn(5).setMinWidth(90);
            jTable_Saida.getColumnModel().getColumn(5).setMaxWidth(90);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_Ordem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox_Peca, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_PrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_PrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(135, 135, 135))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(390, 390, 390)
                                .addComponent(jButton_Incluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Alterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Buscar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox_Peca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_PrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox_Ordem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_PrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Incluir)
                    .addComponent(jButton_Alterar)
                    .addComponent(jButton_Buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_SaidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_SaidaMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable_Saida.getModel();
        int selectedRowIndex = jTable_Saida.getSelectedRow();
        
        jTextField_ID.setText(model.getValueAt(selectedRowIndex, 0).toString());
        jComboBox_Peca.setSelectedItem(model.getValueAt(selectedRowIndex, 1).toString());
        jComboBox_Ordem.setSelectedItem(model.getValueAt(selectedRowIndex, 2).toString());
        jTextField_Quantidade.setText(model.getValueAt(selectedRowIndex, 3).toString());
        jTextField_PrecoUnitario.setText(model.getValueAt(selectedRowIndex, 4).toString().replace("R$", "").trim());
        jTextField_PrecoTotal.setText(model.getValueAt(selectedRowIndex, 5).toString().replace("R$", "").trim());
    }//GEN-LAST:event_jTable_SaidaMouseClicked

    private void jButton_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IncluirActionPerformed
        // TODO add your handling code here:
        try {
            atualizarPrecos();
            ItensPeca objeto = new ItensPeca();
            
            objeto.setIdItensPeca(Integer.parseInt(jTextField_ID.getText()));
            
            objeto.setPeca(new Pecas(Integer.parseInt(jComboBox_Peca.getSelectedItem().toString().split("-")[0])));
            objeto.setOrdem(new OrdemDeServico(Integer.parseInt(jComboBox_Ordem.getSelectedItem().toString().split("-")[0])));
            
            objeto.setQuantidade(Integer.parseInt(jTextField_Quantidade.getText()));
            objeto.setValorUnitario(jTextField_PrecoUnitario.getText().replace(",", "."));       
            objeto.setValorTotal(jTextField_PrecoTotal.getText().replace(",", "."));
            
            itensDB.incluir(objeto);
            limparTela();
            mostrarNaGrid();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao incluir Itens de Peça: " + erro.getMessage());
        }
    }//GEN-LAST:event_jButton_IncluirActionPerformed

    private void jButton_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AlterarActionPerformed
        // TODO add your handling code here:
        try {
            atualizarPrecos();
            ItensPeca objeto = new ItensPeca();
            
            objeto.setIdItensPeca(Integer.parseInt(jTextField_ID.getText()));
            
            objeto.setPeca(new Pecas(Integer.parseInt(jComboBox_Peca.getSelectedItem().toString().split("-")[0])));
            objeto.setOrdem(new OrdemDeServico(Integer.parseInt(jComboBox_Ordem.getSelectedItem().toString().split("-")[0])));
            
            objeto.setQuantidade(Integer.parseInt(jTextField_Quantidade.getText()));
            objeto.setValorUnitario(jTextField_PrecoUnitario.getText().replace(",", "."));       
            objeto.setValorTotal(jTextField_PrecoTotal.getText().replace(",", "."));
            
            itensDB.alterar(objeto);
            limparTela();
            mostrarNaGrid();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao alterar Itens de Peça: " + erro.getMessage());
        }
    }//GEN-LAST:event_jButton_AlterarActionPerformed

    private void jButton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarActionPerformed
        // TODO add your handling code here:
        try {
            ItensPeca objeto = itensDB.consultar(new ItensPeca(Integer.parseInt(jTextField_ID.getText())));
            
            jTextField_ID.setText(objeto.getIdItensPeca()+"");
            jComboBox_Peca.setSelectedItem(objeto.getPeca().toString());
            jComboBox_Ordem.setSelectedItem(objeto.getOrdem().toString());
            jTextField_Quantidade.setText(objeto.getQuantidade()+"");
            jTextField_PrecoUnitario.setText(objeto.getValorUnitario().replace("R$", "").trim());
            jTextField_PrecoTotal.setText(objeto.getValorTotal().replace("R$", "").trim());
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao buscar Itens de Peça: " + erro.getMessage());
        }
    }//GEN-LAST:event_jButton_BuscarActionPerformed

    private void jComboBox_PecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_PecaActionPerformed
        // TODO add your handling code here:
        atualizarPrecos();
    }//GEN-LAST:event_jComboBox_PecaActionPerformed

    private void atualizarPrecos(){
        try{
            ItensPeca objeto = new ItensPeca();
            objeto.setPeca(new Pecas(Integer.parseInt(jComboBox_Peca.getSelectedItem().toString().split("-")[0])));
            int quantidade = 0;
            if(!jTextField_Quantidade.getText().isEmpty()){
                quantidade = Integer.parseInt(jTextField_Quantidade.getText());
            }
            jTextField_PrecoUnitario.setText(pecaDB.consultar(objeto.getPeca()).getValorUnitarioPeca().replace("R$", "").trim());
            float precoUnitario = Float.parseFloat(jTextField_PrecoUnitario.getText().replace(",", "."));
            float precoFinal = precoUnitario*quantidade;
            jTextField_PrecoTotal.setText(precoFinal+"");
        } catch(Exception erro){
            JOptionPane.showMessageDialog(rootPane, "Erro: " + erro.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Alterar;
    private javax.swing.JButton jButton_Buscar;
    private javax.swing.JButton jButton_Incluir;
    private javax.swing.JComboBox<String> jComboBox_Ordem;
    private javax.swing.JComboBox<String> jComboBox_Peca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Saida;
    private javax.swing.JTextField jTextField_ID;
    private javax.swing.JTextField jTextField_PrecoTotal;
    private javax.swing.JTextField jTextField_PrecoUnitario;
    private javax.swing.JTextField jTextField_Quantidade;
    // End of variables declaration//GEN-END:variables
}
