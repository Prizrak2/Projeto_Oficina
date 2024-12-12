/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import conexao.ConexaoBD;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ejmcc
 */
public class TelaPrincipal extends javax.swing.JFrame {

  /**
   * Creates new form TelaPrincipal
   */
    
    private Connection conexao = null;
    private boolean usuarioValidado = false;
    
    public TelaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        jMenu_Oficina.setPopupMenuVisible(false);
        jMenu_OrdemDeServico.setPopupMenuVisible(false);
        try {
            conexao = ConexaoBD.getConexao();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, "Erro na Conexão(TelaPrincipal): " + erro.getMessage());
        }
        WindowClosingEventHandler();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        jDesktopPane_InputDeTela.removeAll();
        TelaLogin telaLogin = new TelaLogin(this);
        jDesktopPane_InputDeTela.add(telaLogin);
        try {
            telaLogin.setVisible(true);
            telaLogin.setSelected(true);
            telaLogin.setMaximum(true);
            telaLogin.setMaximizable(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void WindowClosingEventHandler(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int resposta = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja fechar?","Confirmação", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION){
                    try {
                        conexao.close();
                    } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(rootPane, "Erro no fim da Conexão(TelaPrincipal): " + erro.getMessage());
                    }
                    dispose();
                }
            }
        });
    }
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane_InputDeTela = new javax.swing.JDesktopPane();
        jMenuBar_Opcoes = new javax.swing.JMenuBar();
        jMenu_Oficina = new javax.swing.JMenu();
        jMenu_ClientesVeiculos = new javax.swing.JMenu();
        jMenuItem_Cliente = new javax.swing.JMenuItem();
        jMenu_OpcoesVeiculo = new javax.swing.JMenu();
        jMenuItem_Marca = new javax.swing.JMenuItem();
        jMenuItem_Modelo = new javax.swing.JMenuItem();
        jMenuItem_Acessorio = new javax.swing.JMenuItem();
        jMenuItem_Veiculo = new javax.swing.JMenuItem();
        jMenuItem_VeiculoAcessorio = new javax.swing.JMenuItem();
        jMenuItem_Proprietario = new javax.swing.JMenuItem();
        jMenu_PecasServicos = new javax.swing.JMenu();
        jMenu_OpcoesPeca = new javax.swing.JMenu();
        jMenuItem_Peca = new javax.swing.JMenuItem();
        jMenu_OpcoesServico = new javax.swing.JMenu();
        jMenuItem_Servico = new javax.swing.JMenuItem();
        jMenu_OrdemDeServico = new javax.swing.JMenu();
        jMenuFuncionario = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane_InputDeTela.setPreferredSize(new java.awt.Dimension(957, 466));
        jDesktopPane_InputDeTela.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jDesktopPane_InputDeTelaLayout = new javax.swing.GroupLayout(jDesktopPane_InputDeTela);
        jDesktopPane_InputDeTela.setLayout(jDesktopPane_InputDeTelaLayout);
        jDesktopPane_InputDeTelaLayout.setHorizontalGroup(
            jDesktopPane_InputDeTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1229, Short.MAX_VALUE)
        );
        jDesktopPane_InputDeTelaLayout.setVerticalGroup(
            jDesktopPane_InputDeTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );

        jMenuBar_Opcoes.setBackground(new java.awt.Color(0, 0, 0));

        jMenu_Oficina.setText("Oficina");
        jMenu_Oficina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_OficinaMouseClicked(evt);
            }
        });
        jMenuBar_Opcoes.add(jMenu_Oficina);

        jMenu_ClientesVeiculos.setText("Clientes e Veículos");

        jMenuItem_Cliente.setText("Cliente");
        jMenuItem_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ClienteActionPerformed(evt);
            }
        });
        jMenu_ClientesVeiculos.add(jMenuItem_Cliente);

        jMenu_OpcoesVeiculo.setText("Opções Veículo");

        jMenuItem_Marca.setText("Marca");
        jMenuItem_Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_MarcaActionPerformed(evt);
            }
        });
        jMenu_OpcoesVeiculo.add(jMenuItem_Marca);

        jMenuItem_Modelo.setText("Modelo");
        jMenuItem_Modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ModeloActionPerformed(evt);
            }
        });
        jMenu_OpcoesVeiculo.add(jMenuItem_Modelo);

        jMenuItem_Acessorio.setText("Acessório");
        jMenuItem_Acessorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AcessorioActionPerformed(evt);
            }
        });
        jMenu_OpcoesVeiculo.add(jMenuItem_Acessorio);

        jMenuItem_Veiculo.setText("Veículo");
        jMenuItem_Veiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_VeiculoActionPerformed(evt);
            }
        });
        jMenu_OpcoesVeiculo.add(jMenuItem_Veiculo);

        jMenuItem_VeiculoAcessorio.setText("Acessórios do Veículo");
        jMenuItem_VeiculoAcessorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_VeiculoAcessorioActionPerformed(evt);
            }
        });
        jMenu_OpcoesVeiculo.add(jMenuItem_VeiculoAcessorio);

        jMenu_ClientesVeiculos.add(jMenu_OpcoesVeiculo);

        jMenuItem_Proprietario.setText("Proprietário");
        jMenuItem_Proprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ProprietarioActionPerformed(evt);
            }
        });
        jMenu_ClientesVeiculos.add(jMenuItem_Proprietario);

        jMenuBar_Opcoes.add(jMenu_ClientesVeiculos);

        jMenu_PecasServicos.setText("Peças e Serviços");

        jMenu_OpcoesPeca.setText("Opções de Peça");

        jMenuItem_Peca.setText("Peça");
        jMenuItem_Peca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_PecaActionPerformed(evt);
            }
        });
        jMenu_OpcoesPeca.add(jMenuItem_Peca);

        jMenu_PecasServicos.add(jMenu_OpcoesPeca);

        jMenu_OpcoesServico.setText("Opções de Serviço");

        jMenuItem_Servico.setText("Serviço");
        jMenuItem_Servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ServicoActionPerformed(evt);
            }
        });
        jMenu_OpcoesServico.add(jMenuItem_Servico);

        jMenu_PecasServicos.add(jMenu_OpcoesServico);

        jMenuBar_Opcoes.add(jMenu_PecasServicos);

        jMenu_OrdemDeServico.setBackground(new java.awt.Color(255, 102, 102));
        jMenu_OrdemDeServico.setText("Ordem de Serviço");
        jMenu_OrdemDeServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_OrdemDeServicoMouseClicked(evt);
            }
        });
        jMenuBar_Opcoes.add(jMenu_OrdemDeServico);

        jMenuFuncionario.setText("Funcionario");
        jMenuFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuFuncionarioMouseClicked(evt);
            }
        });
        jMenuBar_Opcoes.add(jMenuFuncionario);

        setJMenuBar(jMenuBar_Opcoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane_InputDeTela, javax.swing.GroupLayout.DEFAULT_SIZE, 1229, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane_InputDeTela, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ClienteActionPerformed
        // Abrir a parte do cliente
        if(usuarioValidado){
            jDesktopPane_InputDeTela.removeAll();
            TelaCliente telaCliente = new TelaCliente();
            jDesktopPane_InputDeTela.add(telaCliente);
            try {
                telaCliente.setVisible(true);
                telaCliente.setSelected(true);
                telaCliente.setMaximum(true);
                telaCliente.setMaximizable(false);
                telaCliente.getContentPane().setBackground(new Color(153, 255, 153));
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Login Necessário");
        }
    }//GEN-LAST:event_jMenuItem_ClienteActionPerformed

    private void jMenuItem_ProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ProprietarioActionPerformed
        // Abrir parte do Proprietário
        if(usuarioValidado){
            jDesktopPane_InputDeTela.removeAll();
            TelaProprietario telaProprietario = new TelaProprietario();
            jDesktopPane_InputDeTela.add(telaProprietario);
            try {
                telaProprietario.setVisible(true);
                telaProprietario.setSelected(true);
                telaProprietario.setMaximum(true);
                telaProprietario.setMaximizable(false);
                telaProprietario.getContentPane().setBackground(new Color(153, 255, 153));
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Login Necessário");
        }
    }//GEN-LAST:event_jMenuItem_ProprietarioActionPerformed

    private void jMenuItem_MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_MarcaActionPerformed
        // Abrir parte da Marca
        if(usuarioValidado){
            jDesktopPane_InputDeTela.removeAll();
            TelaMarca telaMarca = new TelaMarca();
            jDesktopPane_InputDeTela.add(telaMarca);
            try {
                telaMarca.setVisible(true);
                telaMarca.setSelected(true);
                telaMarca.setMaximum(true);
                telaMarca.setMaximizable(false);
                telaMarca.getContentPane().setBackground(new Color(153, 255, 153));
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Login Necessário");
        }
    }//GEN-LAST:event_jMenuItem_MarcaActionPerformed

    private void jMenuItem_ModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ModeloActionPerformed
        // Abrir parte do Modelo
        if(usuarioValidado){
            jDesktopPane_InputDeTela.removeAll();
            TelaModelo telaModelo = new TelaModelo();
            jDesktopPane_InputDeTela.add(telaModelo);
            try {
                telaModelo.setVisible(true);
                telaModelo.setSelected(true);
                telaModelo.setMaximum(true);
                telaModelo.setMaximizable(false);
                telaModelo.getContentPane().setBackground(new Color(153, 255, 153));
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Login Necessário");
        }
    }//GEN-LAST:event_jMenuItem_ModeloActionPerformed

    private void jMenuItem_AcessorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AcessorioActionPerformed
        // Abrir parte do Acessório
        if(usuarioValidado){
            jDesktopPane_InputDeTela.removeAll();
            TelaAcessorio telaAcessorio = new TelaAcessorio();
            jDesktopPane_InputDeTela.add(telaAcessorio);
            try {
                telaAcessorio.setVisible(true);
                telaAcessorio.setSelected(true);
                telaAcessorio.setMaximum(true);
                telaAcessorio.setMaximizable(false);
                telaAcessorio.getContentPane().setBackground(new Color(153, 255, 153));
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Login Necessário");
        }
    }//GEN-LAST:event_jMenuItem_AcessorioActionPerformed

    private void jMenuItem_VeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_VeiculoActionPerformed
        // Abrir parte do Veículo
        if(usuarioValidado){
            jDesktopPane_InputDeTela.removeAll();
            TelaVeiculo telaVeiculo = new TelaVeiculo();
            jDesktopPane_InputDeTela.add(telaVeiculo);
            try {
                telaVeiculo.setVisible(true);
                telaVeiculo.setSelected(true);
                telaVeiculo.setMaximum(true);
                telaVeiculo.setMaximizable(false);
                telaVeiculo.getContentPane().setBackground(new Color(153, 255, 153));
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Login Necessário");
        }
    }//GEN-LAST:event_jMenuItem_VeiculoActionPerformed

    private void jMenuItem_VeiculoAcessorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_VeiculoAcessorioActionPerformed
        // Abrir parte dos Acessíos do Veículo(tabela VeiculoAcessorio)
        if(usuarioValidado){
            jDesktopPane_InputDeTela.removeAll();
            TelaVeiculoAcessorio telaVeiculoAcessorio = new TelaVeiculoAcessorio();
            jDesktopPane_InputDeTela.add(telaVeiculoAcessorio);
            try {
                telaVeiculoAcessorio.setVisible(true);
                telaVeiculoAcessorio.setSelected(true);
                telaVeiculoAcessorio.setMaximum(true);
                telaVeiculoAcessorio.setMaximizable(false);
                telaVeiculoAcessorio.getContentPane().setBackground(new Color(153, 255, 153));
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Login Necessário");
        }
    }//GEN-LAST:event_jMenuItem_VeiculoAcessorioActionPerformed

    private void jMenuItem_PecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_PecaActionPerformed
        // Abrir parte da Peça
        if(usuarioValidado){
            jDesktopPane_InputDeTela.removeAll();
            TelaPeca telaPeca = new TelaPeca();
            jDesktopPane_InputDeTela.add(telaPeca);
            try {
                telaPeca.setVisible(true);
                telaPeca.setSelected(true);
                telaPeca.setMaximum(true);
                telaPeca.setMaximizable(false);
                telaPeca.getContentPane().setBackground(new Color(153, 255, 153));
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Login Necessário");
        }
    }//GEN-LAST:event_jMenuItem_PecaActionPerformed

    private void jMenuItem_ServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ServicoActionPerformed
        // Abrir parte do Serviço
        if(usuarioValidado){
            jDesktopPane_InputDeTela.removeAll();
            TelaCadastroServicos telaServico = new TelaCadastroServicos();
            jDesktopPane_InputDeTela.add(telaServico);
            try {
                telaServico.setVisible(true);
                telaServico.setSelected(true);
                telaServico.setMaximum(true);
                telaServico.setMaximizable(false);
                telaServico.getContentPane().setBackground(new Color(153, 255, 153));
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Login Necessário");
        }
    }//GEN-LAST:event_jMenuItem_ServicoActionPerformed

    private void jMenu_OficinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_OficinaMouseClicked
        // Abrir a parte da oficina
        if(usuarioValidado){
            jDesktopPane_InputDeTela.removeAll();
            TelaOficinas telaOficina = new TelaOficinas();
            jDesktopPane_InputDeTela.add(telaOficina);
            try {
                telaOficina.setVisible(true);
                telaOficina.setSelected(true);
                telaOficina.setMaximum(true);
                telaOficina.setMaximizable(false);
                telaOficina.getContentPane().setBackground(new Color(153, 255, 153));
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Login Necessário");
        }
    }//GEN-LAST:event_jMenu_OficinaMouseClicked

    private void jMenu_OrdemDeServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_OrdemDeServicoMouseClicked
        // Abrir a parte da ordem de serviço
        if(usuarioValidado){
            jDesktopPane_InputDeTela.removeAll();
            TelaOrdemDeServico telaOrdemDeServico = new TelaOrdemDeServico();
            jDesktopPane_InputDeTela.add(telaOrdemDeServico);
            try {
                telaOrdemDeServico.setVisible(true);
                telaOrdemDeServico.setSelected(true);
                telaOrdemDeServico.setMaximum(true);
                telaOrdemDeServico.setMaximizable(false);
                telaOrdemDeServico.getContentPane().setBackground(new Color(153, 255, 153));
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Login Necessário");
        }
    }//GEN-LAST:event_jMenu_OrdemDeServicoMouseClicked

    private void jMenuFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuFuncionarioMouseClicked
        // Abrir parte do Funcionário
        if(usuarioValidado){
            jDesktopPane_InputDeTela.removeAll();
            TelaFuncionario telaFuncionario = new TelaFuncionario();
            jDesktopPane_InputDeTela.add(telaFuncionario);
            try {
                telaFuncionario.setVisible(true);
                telaFuncionario.setSelected(true);
                telaFuncionario.setMaximum(true);
                telaFuncionario.setMaximizable(false);
                telaFuncionario.getContentPane().setBackground(new Color(153, 255, 153));
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Login Necessário");
        }
    }//GEN-LAST:event_jMenuFuncionarioMouseClicked
    
    public void usuarioVerificado(){
        usuarioValidado = true;
    }
    
    public void chamarTelaBemVindo(){
        // Como inserir uma tela na tela principal
        jDesktopPane_InputDeTela.removeAll();
        TelaBemVindo telaBemVindo = new TelaBemVindo();
        jDesktopPane_InputDeTela.add(telaBemVindo);
        try {
            telaBemVindo.setVisible(true);
            telaBemVindo.setSelected(true);
            telaBemVindo.setMaximum(true);
            telaBemVindo.setMaximizable(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
          java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
          java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
          java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane_InputDeTela;
    private javax.swing.JMenuBar jMenuBar_Opcoes;
    private javax.swing.JMenu jMenuFuncionario;
    private javax.swing.JMenuItem jMenuItem_Acessorio;
    private javax.swing.JMenuItem jMenuItem_Cliente;
    private javax.swing.JMenuItem jMenuItem_Marca;
    private javax.swing.JMenuItem jMenuItem_Modelo;
    private javax.swing.JMenuItem jMenuItem_Peca;
    private javax.swing.JMenuItem jMenuItem_Proprietario;
    private javax.swing.JMenuItem jMenuItem_Servico;
    private javax.swing.JMenuItem jMenuItem_Veiculo;
    private javax.swing.JMenuItem jMenuItem_VeiculoAcessorio;
    private javax.swing.JMenu jMenu_ClientesVeiculos;
    private javax.swing.JMenu jMenu_Oficina;
    private javax.swing.JMenu jMenu_OpcoesPeca;
    private javax.swing.JMenu jMenu_OpcoesServico;
    private javax.swing.JMenu jMenu_OpcoesVeiculo;
    private javax.swing.JMenu jMenu_OrdemDeServico;
    private javax.swing.JMenu jMenu_PecasServicos;
    // End of variables declaration//GEN-END:variables
}
