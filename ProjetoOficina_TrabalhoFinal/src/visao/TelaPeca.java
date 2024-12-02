/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package visao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ICrud;
import modelos.Pecas;
import persistencia.PecaDAO;
/**
 *
 * @author Cliente
 */
public class TelaPeca extends javax.swing.JInternalFrame {
 private ICrud<Pecas> PecaBD = null;
    /**
     * Creates new form TelaPeca
     */
    public TelaPeca() {
        initComponents();
    try {
      PecaBD = new PecaDAO();
      mostrarServicosNaGrid();
    } catch (Exception erro) {
      JOptionPane.showMessageDialog(null, "Construtor Tela: "+erro.getMessage());
    }
    }
  private void limparTela(){
    jTextField_IdPeca.setText("");
    jTextField_ValorUnitario.setText("");
    jTextField_codigoFabricantePeca.setText("");
    jTextField_descricaoPeca.setText("");
    jTextField_quantidade.setText("");
  }
  private void mostrarServicosNaGrid(){
  try {
    List<Pecas> listaDePeca = new ArrayList<>();
    listaDePeca = null;
    listaDePeca = PecaBD.listar();
    if(listaDePeca != null){
    DefaultTableModel model =  (DefaultTableModel) jTable_Peca.getModel();
    model.setNumRows(0); 
    if(listaDePeca.isEmpty()) 
      throw new Exception("Lista de Servico BD Vazia");
 
    for(int pos = 0; pos < listaDePeca.size(); pos++){
      Pecas objPeca = listaDePeca.get(pos);
      String[] saida = new String[5];
        saida[0] = objPeca.getIdPeca()+ "";
        saida[1] = objPeca.getDescricaoPeca()+ "";
        saida[2] = objPeca.getCodigoFabricante()+ "";
        saida[3] = objPeca.getValorUnitarioPeca()+ "";
        saida[4] = objPeca.getQuantidadePeca()+ "";
      model.addRow(saida);
    }  
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_IdPeca = new javax.swing.JTextField();
        jTextField_descricaoPeca = new javax.swing.JTextField();
        jTextField_codigoFabricantePeca = new javax.swing.JTextField();
        jTextField_ValorUnitario = new javax.swing.JTextField();
        jTextField_quantidade = new javax.swing.JTextField();
        jButton_Incluir = new javax.swing.JButton();
        jButton_Alterar = new javax.swing.JButton();
        jButton_Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Peca = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1146, 573));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setText("CADASTRO DE PECAS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setText("IdPeca");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setText("Descricao");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setText("Codigo Fabricante");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setText("Valor Unitario");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setText("Quantidade");

        jTextField_IdPeca.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        jTextField_descricaoPeca.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        jTextField_codigoFabricantePeca.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        jTextField_ValorUnitario.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        jTextField_quantidade.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        jButton_Incluir.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton_Incluir.setText("INCLUIR");
        jButton_Incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IncluirActionPerformed(evt);
            }
        });

        jButton_Alterar.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton_Alterar.setText("ALTERAR");
        jButton_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AlterarActionPerformed(evt);
            }
        });

        jButton_Buscar.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton_Buscar.setText("BUSCAR");
        jButton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarActionPerformed(evt);
            }
        });

        jTable_Peca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "IDPeca", "Descricao", "CodigoFabricante", "ValorUnitario", "Quantidade"
            }
        ));
        jScrollPane1.setViewportView(jTable_Peca);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(366, 366, 366)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_ValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_IdPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_descricaoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_codigoFabricantePeca, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_Incluir)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Alterar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Buscar)))
                        .addGap(0, 130, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_IdPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_descricaoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_codigoFabricantePeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_ValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Incluir)
                    .addComponent(jButton_Alterar)
                    .addComponent(jButton_Buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IncluirActionPerformed
        // TODO add your handling code here:
        try {
            String IDpeca = jTextField_IdPeca.getText();
           // Valida o ID
            if (IDpeca.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O ID não pode estar vazio.");
                return;
            }
            if (!IDpeca.matches("\\d+")) {
                JOptionPane.showMessageDialog(rootPane, "O ID deve ser um número inteiro");
                return;
            }
            
            String descricao = jTextField_descricaoPeca.getText().toUpperCase();
            if (descricao.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo de descrição não pode estar vazio.");
                return;
            }
            
            String codigoFabricante = jTextField_codigoFabricantePeca.getText();
            if (codigoFabricante.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo de Codigo Fabricante não pode estar vazio.");
                return;
            }
            // Valida o codigoFabricante
            if (!codigoFabricante.matches("\\d+")) {
                JOptionPane.showMessageDialog(rootPane, "O Codigo Fabricante deve ser um número inteiro");
                return;
            }
            
            String quantidade = jTextField_quantidade.getText();
            // Valida a quantidade
            if (quantidade.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Quantidade não pode estar vazia.");
                return;
            }
            if (!quantidade.matches("\\d+")) {
                JOptionPane.showMessageDialog(rootPane, "A quantidade deve ser um número inteiro");
                return;
            }
            
            String valorUnitario = jTextField_ValorUnitario.getText().trim();
            // Valida se o valor está vazio
            if (valorUnitario.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O Valor Unitário não pode estar vazio.");
                return;
            }

            // Valida o preço com uma expressão regular
            if (!valorUnitario.matches("\\d+(\\.\\d{1,2})?")) {
                JOptionPane.showMessageDialog(rootPane, "O Valor Unitário deve ser um número inteiro ou decimal com até duas casas decimais (ex.: 123 ou 123.45).");
                return;
            }
            
            Pecas objPeca = new Pecas(Integer.parseInt(IDpeca), descricao, Integer.parseInt(codigoFabricante), valorUnitario, Integer.parseInt(quantidade));
            PecaBD.incluir(objPeca);
            limparTela();
            mostrarServicosNaGrid();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, "Incluir Visao: "+erro.getMessage());
        }
    }//GEN-LAST:event_jButton_IncluirActionPerformed

    private void jButton_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AlterarActionPerformed
        // TODO add your handling code here:
        try {
            String IDpeca = jTextField_IdPeca.getText();
            // Valida o ID
            if (IDpeca.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O ID não pode estar vazio.");
                return;
            }
            if (!IDpeca.matches("\\d+")) {
                JOptionPane.showMessageDialog(rootPane, "O ID deve ser um número inteiro");
                return;
            }
            
            String descricao = jTextField_descricaoPeca.getText().toUpperCase();
            if (descricao.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo de descrição não pode estar vazio.");
                return;
            }
            
            String codigoFabricante = jTextField_codigoFabricantePeca.getText();
            if (codigoFabricante.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo de Codigo Fabricante não pode estar vazio.");
                return;
            }
            // Valida o codigoFabricante
            if (!codigoFabricante.matches("\\d+")) {
                JOptionPane.showMessageDialog(rootPane, "O Codigo Fabricante deve ser um número inteiro");
                return;
            }
            
            String quantidade = jTextField_quantidade.getText();
            // Valida a quantidade
            if (quantidade.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Quantidade não pode estar vazia.");
                return;
            }
            if (!quantidade.matches("\\d+")) {
                JOptionPane.showMessageDialog(rootPane, "A quantidade deve ser um número inteiro");
                return;
            }
            
            String valorUnitario = jTextField_ValorUnitario.getText().trim();
            // Valida se o valor está vazio
            if (valorUnitario.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O Valor Unitário não pode estar vazio.");
                return;
            }

            // Valida o preço com uma expressão regular
            if (!valorUnitario.matches("\\d+(\\.\\d{1,2})?")) {
                JOptionPane.showMessageDialog(rootPane, "O Valor Unitário deve ser um número inteiro ou decimal com até duas casas decimais (ex.: 123 ou 123.45).");
                return;
            }
            
            Pecas objPeca = new Pecas(Integer.parseInt(IDpeca), descricao, Integer.parseInt(codigoFabricante), valorUnitario, Integer.parseInt(quantidade));
            PecaBD.alterar(objPeca);
            limparTela();
            mostrarServicosNaGrid();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, "Alterar Visao: "+erro.getMessage());
        }
    }//GEN-LAST:event_jButton_AlterarActionPerformed

    private void jButton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarActionPerformed
        // TODO add your handling code here:
        try {
        if(jTextField_IdPeca.getText().isEmpty()) throw new Exception("Id vazio");
            Pecas objPeca = new Pecas(Integer.parseInt(jTextField_IdPeca.getText()));
            objPeca = (PecaBD.consultar(objPeca));
      
            jTextField_IdPeca.setText(objPeca.getIdPeca()+"");
            jTextField_descricaoPeca.setText(objPeca.getDescricaoPeca());
            jTextField_codigoFabricantePeca.setText(objPeca.getCodigoFabricante()+"");
            jTextField_ValorUnitario.setText(objPeca.getValorUnitarioPeca());
            jTextField_quantidade.setText(objPeca.getQuantidadePeca()+ "");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, "Buscar Visao: "+erro.getMessage());
        }
    }//GEN-LAST:event_jButton_BuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Alterar;
    private javax.swing.JButton jButton_Buscar;
    private javax.swing.JButton jButton_Incluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Peca;
    private javax.swing.JTextField jTextField_IdPeca;
    private javax.swing.JTextField jTextField_ValorUnitario;
    private javax.swing.JTextField jTextField_codigoFabricantePeca;
    private javax.swing.JTextField jTextField_descricaoPeca;
    private javax.swing.JTextField jTextField_quantidade;
    // End of variables declaration//GEN-END:variables
}
