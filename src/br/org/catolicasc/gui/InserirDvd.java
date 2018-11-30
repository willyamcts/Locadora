package br.org.catolicasc.gui;

import br.org.catolicasc.dao.DvdDao;
import br.org.catolicasc.dao.FilmeDao;
import br.org.catolicasc.main.MenuPrincipal;
import br.org.catolicasc.model.Dvd;
import br.org.catolicasc.model.Filme;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */

public class InserirDvd extends javax.swing.JFrame {
	
	private DvdDao dvdDao = new DvdDao();
	private FilmeDao filmeDao = new FilmeDao(); 
	
	Filme filme = new Filme();
	Dvd dvd = new Dvd();

    /**
     * Creates new form CadastroFilme
     */
    public InserirDvd() {
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

        jLabel1 = new javax.swing.JLabel();
        tituloInserirDvd = new javax.swing.JTextField();
        generoInserirDvd = new javax.swing.JTextField();
        dataInserirDvd = new javax.swing.JTextField();
        duracaoInserirDvd = new javax.swing.JTextField();
        botaoCadastroInserirDvd = new javax.swing.JButton();
        botaoVoltarInserirDvd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cadastro DVD");

        tituloInserirDvd.setText("T�tulo");
        tituloInserirDvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloInserirDvdActionPerformed(evt);
            }
        });

        generoInserirDvd.setText("G�nero");
        generoInserirDvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generoInserirDvdActionPerformed(evt);
            }
        });

        dataInserirDvd.setText("Data de Lan�amento");
        dataInserirDvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataInserirDvdActionPerformed(evt);
            }
        });

        duracaoInserirDvd.setText("Dura��o");
        duracaoInserirDvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracaoInserirDvdActionPerformed(evt);
            }
        });

        botaoCadastroInserirDvd.setText("Cadastrar");
        botaoCadastroInserirDvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastroInserirDvdActionPerformed(evt);
            }
        });

        botaoVoltarInserirDvd.setText("Voltar");
        botaoVoltarInserirDvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarInserirDvdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jLabel1)
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloInserirDvd)
                    .addComponent(generoInserirDvd, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataInserirDvd)
                    .addComponent(duracaoInserirDvd)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoCadastroInserirDvd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVoltarInserirDvd)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(64, 64, 64)
                .addComponent(tituloInserirDvd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generoInserirDvd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataInserirDvd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(duracaoInserirDvd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastroInserirDvd)
                    .addComponent(botaoVoltarInserirDvd))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tituloInserirDvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloInserirDvdActionPerformed
    	filme.setTitulo(tituloInserirDvd.getText());
    	System.out.println(filme.getTitulo());
    }//GEN-LAST:event_tituloInserirDvdActionPerformed

    private void generoInserirDvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generoInserirDvdActionPerformed
    	filme.setGenero(generoInserirDvd.getText());
    	System.out.println(filme.getGenero());
    }//GEN-LAST:event_generoInserirDvdActionPerformed

    private void dataInserirDvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataInserirDvdActionPerformed
    	filme.setDataLancamento(dataInserirDvd.getText());
    	System.out.println(filme.getDataLancamento());
    }//GEN-LAST:event_dataInserirDvdActionPerformed

    private void duracaoInserirDvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracaoInserirDvdActionPerformed
    	filme.setDuracao(Integer.parseInt(duracaoInserirDvd.getText()));
    	System.out.println(filme.getDuracao());
    }//GEN-LAST:event_duracaoInserirDvdActionPerformed

    private void botaoCadastroInserirDvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastroInserirDvdActionPerformed
    	filmeDao.insert(filme);
    	dvdDao.insert(dvd);
    	
    	MenuPrincipal Confirmar = new MenuPrincipal();
        Confirmar.setVisible(true);
        dispose();
    }//GEN-LAST:event_botaoCadastroInserirDvdActionPerformed

    private void botaoVoltarInserirDvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarInserirDvdActionPerformed
        MenuPrincipal Voltar = new MenuPrincipal();
        Voltar.setVisible(true);
        dispose();
    }//GEN-LAST:event_botaoVoltarInserirDvdActionPerformed

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
            java.util.logging.Logger.getLogger(InserirDvd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirDvd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirDvd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirDvd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InserirDvd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastroInserirDvd;
    private javax.swing.JButton botaoVoltarInserirDvd;
    private javax.swing.JTextField dataInserirDvd;
    private javax.swing.JTextField duracaoInserirDvd;
    private javax.swing.JTextField generoInserirDvd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField tituloInserirDvd;
    // End of variables declaration//GEN-END:variables
}

