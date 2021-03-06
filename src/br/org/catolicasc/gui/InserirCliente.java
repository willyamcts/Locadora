package br.org.catolicasc.gui;

import br.org.catolicasc.dao.ClienteDao;
import br.org.catolicasc.dao.EnderecoDao;
import br.org.catolicasc.dao.PessoaDao;
import br.org.catolicasc.dao.TelefoneDao;
import br.org.catolicasc.main.MenuPrincipal;
import br.org.catolicasc.model.Cliente;
import br.org.catolicasc.model.Endereco;
import br.org.catolicasc.model.Pessoa;
import br.org.catolicasc.model.Telefone;
//import br.org.catolicasc.ui.EnderecoDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class InserirCliente extends javax.swing.JFrame {
	
	private ClienteDao clienteDao = new ClienteDao();
	private TelefoneDao telefoneDao = new TelefoneDao();
	private PessoaDao pessoaDao = new PessoaDao();
	private EnderecoDao enderecoDao = new EnderecoDao();
	
	private Cliente cliente = new Cliente();
	private Pessoa pessoa = new Pessoa();
	private Telefone telefone = new Telefone();
	private Endereco endereco = new Endereco();
	
    /**
     * Creates new form CadastroCliente
     */
    public InserirCliente() {
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

        botaoCadastrarInserirCliente = new javax.swing.JButton();
        botaoVoltarInserirCliente = new javax.swing.JButton();
        nomeInserirCliente = new javax.swing.JTextField();
        cpfInserirCliente = new javax.swing.JTextField();
        cidadeInserirCliente = new javax.swing.JTextField();
        bairroInserirCliente = new javax.swing.JTextField();
        numeroResidenciaInserirCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        numeroInserirCliente = new javax.swing.JTextField();
        logradouroInserirCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botaoCadastrarInserirCliente.setText("Cadastrar");
        botaoCadastrarInserirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarInserirClienteActionPerformed(evt);
            }
        });

        botaoVoltarInserirCliente.setText("Voltar");
        botaoVoltarInserirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarInserirClienteActionPerformed(evt);
            }
        });

        nomeInserirCliente.setText("Nome completo");
        nomeInserirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeInserirClienteActionPerformed(evt);
            }
        });

        cpfInserirCliente.setText("CPF");
        cpfInserirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfInserirClienteActionPerformed(evt);
            }
        });

        cidadeInserirCliente.setText("Cidade de residÍncia");
        cidadeInserirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeInserirClienteActionPerformed(evt);
            }
        });

        bairroInserirCliente.setText("Bairro de residÍncia");
        bairroInserirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bairroInserirClienteActionPerformed(evt);
            }
        });

        numeroResidenciaInserirCliente.setText("Numero residencia/apto");
        numeroResidenciaInserirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroResidenciaInserirClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Cadastro cliente");

        numeroInserirCliente.setText("Telefone");
        numeroInserirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroInserirClienteActionPerformed(evt);
            }
        });

        logradouroInserirCliente.setText("Logradouro");
        logradouroInserirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logradouroInserirClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel1)
                .addContainerGap(163, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeInserirCliente)
                    .addComponent(cpfInserirCliente)
                    .addComponent(cidadeInserirCliente)
                    .addComponent(bairroInserirCliente)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoCadastrarInserirCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVoltarInserirCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numeroInserirCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroResidenciaInserirCliente))
                    .addComponent(logradouroInserirCliente))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(nomeInserirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpfInserirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cidadeInserirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bairroInserirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logradouroInserirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroInserirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroResidenciaInserirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrarInserirCliente)
                    .addComponent(botaoVoltarInserirCliente))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void nomeInserirClienteActionPerformed(java.awt.event.ActionEvent evt) {
    	pessoa.setNome(nomeInserirCliente.getText());
    	System.out.println(pessoa.getNome());
    }                                                  

    private void cpfInserirClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    	pessoa.setCpf(cpfInserirCliente.getText());
    	System.out.println(pessoa.getCpf());
    }                                                 

    private void cidadeInserirClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                     
    	endereco.setCidade(cidadeInserirCliente.getText());
    	System.out.println(endereco.getCidade());
    }                                                    

    private void bairroInserirClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                     
    	endereco.setBairro(bairroInserirCliente.getText());
    	System.out.println(endereco.getBairro());
    }                                                    

    private void numeroResidenciaInserirClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                               
    	endereco.setNumeroResidencia(Integer.parseInt(numeroResidenciaInserirCliente.getText()));
    	System.out.println(endereco.getNumeroResidencia());
    }

    private void botaoVoltarInserirClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        MenuPrincipal Voltar = new MenuPrincipal();
        Voltar.setVisible(true);
        dispose();
    }
    
    private void botaoCadastrarInserirClienteActionPerformed(java.awt.event.ActionEvent evt) {

    	enderecoDao.insert(endereco);
    	telefoneDao.insert(telefone);
    	
    	
    	
    	pessoa.setIdade(20);
    	pessoa.setEndereco(endereco);
    	pessoa.setTelefone(telefone);
    	
    	
    	
    	//enderecoDao.insert(endereco);
    	//telefoneDao.insert(telefone);
    	pessoaDao.insert(pessoa);
    	
    	cliente.setPessoa(pessoa);
    	cliente.setLocacao(false);
    	clienteDao.insert(cliente);
    	
    	MenuPrincipal Confirmar = new MenuPrincipal();
        Confirmar.setVisible(true);
        dispose();
    	
    }
    
    private void numeroInserirClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                       
    	//telefone.setNumero(Integer.parseInt(numeroInserirCliente.getText()));
    	String fone = numeroInserirCliente.getText();
    	telefone.setCodArea(obtemDD(fone));
    	telefone.setNumero(obtemNumero(fone));
    	//telefoneDao.insert(telefone);
    	System.out.println(telefone.getCodArea()+ " " +telefone.getNumero());
    }                                                      

    private void logradouroInserirClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                         
    	endereco.setLogradouro(logradouroInserirCliente.getText());
    	System.out.println(endereco.getLogradouro());
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
            java.util.logging.Logger.getLogger(InserirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InserirCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField bairroInserirCliente;
    private javax.swing.JButton botaoCadastrarInserirCliente;
    private javax.swing.JButton botaoVoltarInserirCliente;
    private javax.swing.JTextField cidadeInserirCliente;
    private javax.swing.JTextField cpfInserirCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField logradouroInserirCliente;
    private javax.swing.JTextField nomeInserirCliente;
    private javax.swing.JTextField numeroResidenciaInserirCliente;
    private javax.swing.JTextField numeroInserirCliente;
    // End of variables declaration          




	private int obtemDD(String fone){
		int ddFone = Integer.parseInt(fone.substring(0,2));
		
		return ddFone;
	}	
	
	
	private String obtemNumero(String numero) {
		String fone = null;
		
		fone = numero.substring(2, numero.length());
		
		return fone;
	}


}