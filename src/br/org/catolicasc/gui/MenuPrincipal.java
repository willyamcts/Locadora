package br.org.catolicasc.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        inserirMenuPrincipal = new javax.swing.JMenu();
        inserirLocacaoMenuPrincipal = new javax.swing.JMenuItem();
        inserirClienteMenuPrincipal = new javax.swing.JMenuItem();
        inserirDvdMenuPrincipal = new javax.swing.JMenuItem();
        listarMenuPrincipal = new javax.swing.JMenu();
        listarLocacaoMenuPrincipal = new javax.swing.JMenuItem();
        listarClienteMenuPrincipal = new javax.swing.JMenuItem();
        listarDvdMenuPrincipal = new javax.swing.JMenuItem();
        removerMenuPrincipal = new javax.swing.JMenu();
        removerLocacaoMenuPrincipal = new javax.swing.JMenuItem();
        removerClienteMenuPrincipal = new javax.swing.JMenuItem();
        removerDvdMenuPrincipal = new javax.swing.JMenuItem();
        sairMenuPrincipal = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inserirMenuPrincipal.setText("Inserir");

        inserirLocacaoMenuPrincipal.setText("Loca��o");
        inserirLocacaoMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirLocacaoMenuPrincipalActionPerformed(evt);
            }
        });
        inserirMenuPrincipal.add(inserirLocacaoMenuPrincipal);

        inserirClienteMenuPrincipal.setText("Cliente");
        inserirClienteMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirClienteMenuPrincipalActionPerformed(evt);
            }
        });
        inserirMenuPrincipal.add(inserirClienteMenuPrincipal);

        inserirDvdMenuPrincipal.setText("DVD");
        inserirDvdMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirDvdMenuPrincipalActionPerformed(evt);
            }
        });
        inserirMenuPrincipal.add(inserirDvdMenuPrincipal);

        jMenuBar1.add(inserirMenuPrincipal);

        listarMenuPrincipal.setText("Listar");

        listarLocacaoMenuPrincipal.setText("Loca��o");
        listarLocacaoMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarLocacaoMenuPrincipalActionPerformed(evt);
            }
        });
        listarMenuPrincipal.add(listarLocacaoMenuPrincipal);

        listarClienteMenuPrincipal.setText("Cliente");
        listarMenuPrincipal.add(listarClienteMenuPrincipal);

        listarDvdMenuPrincipal.setText("DVD");
        listarDvdMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarDvdMenuPrincipalActionPerformed(evt);
            }
        });
        listarMenuPrincipal.add(listarDvdMenuPrincipal);

        jMenuBar1.add(listarMenuPrincipal);

        removerMenuPrincipal.setText("Remover");

        removerLocacaoMenuPrincipal.setText("Loca��o");
        removerMenuPrincipal.add(removerLocacaoMenuPrincipal);

        removerClienteMenuPrincipal.setText("Cliente");
        removerClienteMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerClienteMenuPrincipalActionPerformed(evt);
            }
        });
        removerMenuPrincipal.add(removerClienteMenuPrincipal);

        removerDvdMenuPrincipal.setText("DVD");
        removerDvdMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerDvdMenuPrincipalActionPerformed(evt);
            }
        });
        removerMenuPrincipal.add(removerDvdMenuPrincipal);

        jMenuBar1.add(removerMenuPrincipal);

        sairMenuPrincipal.setText("Sair");
        jMenuBar1.add(sairMenuPrincipal);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirClienteMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirClienteMenuPrincipalActionPerformed
        InserirCliente Cliente = new InserirCliente();
        Cliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_inserirClienteMenuPrincipalActionPerformed

    private void inserirDvdMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirDvdMenuPrincipalActionPerformed
        InserirDvd Dvd = new InserirDvd();
        Dvd.setVisible(true);
        dispose();
    }//GEN-LAST:event_inserirDvdMenuPrincipalActionPerformed

    private void listarLocacaoMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarLocacaoMenuPrincipalActionPerformed
        ListarLocacao Listar = new ListarLocacao();
        Listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_listarLocacaoMenuPrincipalActionPerformed

    private void listarDvdMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarDvdMenuPrincipalActionPerformed
        ListarDvd Dvd = new ListarDvd();
        Dvd.setVisible(true);
        dispose();
    }//GEN-LAST:event_listarDvdMenuPrincipalActionPerformed

    private void removerClienteMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerClienteMenuPrincipalActionPerformed
        RemoverCliente Cliente = new RemoverCliente();
        Cliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_removerClienteMenuPrincipalActionPerformed

    private void inserirLocacaoMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirLocacaoMenuPrincipalActionPerformed
        InserirLocacao Locacao = new InserirLocacao();
        Locacao.setVisible(true);
        dispose();
    }//GEN-LAST:event_inserirLocacaoMenuPrincipalActionPerformed

    private void removerDvdMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerDvdMenuPrincipalActionPerformed
        RemoverDvd Dvd = new RemoverDvd();
        Dvd.setVisible(true);
        dispose();
    }//GEN-LAST:event_removerDvdMenuPrincipalActionPerformed
    
    private void removerLocacaoMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        RemoverLocacao Locacao = new RemoverLocacao();
        Locacao.setVisible(true);
        dispose();
    }
    
    private void listarClienteMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        ListarCliente Cliente = new ListarCliente();
        Cliente.setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem inserirClienteMenuPrincipal;
    private javax.swing.JMenuItem inserirDvdMenuPrincipal;
    private javax.swing.JMenuItem inserirLocacaoMenuPrincipal;
    private javax.swing.JMenu inserirMenuPrincipal;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem listarClienteMenuPrincipal;
    private javax.swing.JMenuItem listarDvdMenuPrincipal;
    private javax.swing.JMenuItem listarLocacaoMenuPrincipal;
    private javax.swing.JMenu listarMenuPrincipal;
    private javax.swing.JMenuItem removerClienteMenuPrincipal;
    private javax.swing.JMenuItem removerDvdMenuPrincipal;
    private javax.swing.JMenuItem removerLocacaoMenuPrincipal;
    private javax.swing.JMenu removerMenuPrincipal;
    private javax.swing.JMenu sairMenuPrincipal;
    // End of variables declaration//GEN-END:variables
}
