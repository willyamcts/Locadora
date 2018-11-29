package br.org.catolicasc.gui;

import br.org.catolicasc.dao.ClienteDao;
import br.org.catolicasc.dao.DvdDao;
import br.org.catolicasc.dao.LocacaoDao;
import br.org.catolicasc.model.Cliente;
import br.org.catolicasc.model.Dvd;
import br.org.catolicasc.model.Locacao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class InserirLocacao extends javax.swing.JFrame {
	
	private Dvd dvd = new Dvd();
	private Cliente cliente = new Cliente();
	Locacao l = new Locacao();
	
	private DvdDao dvdDao = new DvdDao();
	private LocacaoDao locacaoDao = new LocacaoDao();
	private ClienteDao clienteDao = new ClienteDao();


    /**
     * Creates new form InserirLoca��o
     */
    public InserirLocacao() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        idDvdInserirLocacao = new javax.swing.JTextField();
        idClienteInserirLocacao = new javax.swing.JTextField();
        botaoConfirmarInserirLocacao = new javax.swing.JButton();
        botaoVoltarInserirLocacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Inserir Loca��o");

        idDvdInserirLocacao.setText("Informe o ID do DVD");
        idDvdInserirLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idDvdInserirLocacaoActionPerformed(evt);
            }
        });

        idClienteInserirLocacao.setText("Informe o ID do Cliente");
        idClienteInserirLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idClienteInserirLocacaoActionPerformed(evt);
            }
        });

        botaoConfirmarInserirLocacao.setText("Confirmar");
        botaoConfirmarInserirLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarInserirLocacaoActionPerformed(evt);
            }
        });

        botaoVoltarInserirLocacao.setText("Voltar");
        botaoVoltarInserirLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarInserirLocacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idDvdInserirLocacao, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idClienteInserirLocacao))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 155, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(162, 162, 162))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoConfirmarInserirLocacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoVoltarInserirLocacao)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(idDvdInserirLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idClienteInserirLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirmarInserirLocacao)
                    .addComponent(botaoVoltarInserirLocacao))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void idDvdInserirLocacaoActionPerformed(java.awt.event.ActionEvent evt) {                                                    
    	dvd.setId(Integer.parseInt(idDvdInserirLocacao.getText()));
    	System.out.println(dvd.getId());
    }                                                   

    private void idClienteInserirLocacaoActionPerformed(java.awt.event.ActionEvent evt) {                                                        
    	cliente.setId(Integer.parseInt(idClienteInserirLocacao.getText()));
    	System.out.println(cliente.getId());
    }                                                       

    private void botaoConfirmarInserirLocacaoActionPerformed(java.awt.event.ActionEvent evt) {                                                             
        
    	
    	MenuPrincipal Confirmar = new MenuPrincipal();
        Confirmar.setVisible(true);
    }                                                            

    private void botaoVoltarInserirLocacaoActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        MenuPrincipal Voltar = new MenuPrincipal();
        Voltar.setVisible(true);
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
            java.util.logging.Logger.getLogger(InserirLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InserirLocacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoConfirmarInserirLocacao;
    private javax.swing.JButton botaoVoltarInserirLocacao;
    private javax.swing.JTextField idClienteInserirLocacao;
    private javax.swing.JTextField idDvdInserirLocacao;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}