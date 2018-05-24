package view;

import controller.ControladorTelaPrincipal;
import java.awt.Color;
import controller.ObservadorTelaPrincipal;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Ivens
 */
public class TelaInicial extends javax.swing.JFrame implements ObservadorTelaPrincipal{

    private ControladorTelaPrincipal controle;
    private TelaSobre sobre;
    private Dimension tam = Toolkit.getDefaultToolkit().getScreenSize();
    
    public TelaInicial() {              
        initComponents();
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(this);
        
        sobre = new TelaSobre();     
        sobre.setVisible(true);
        controle = new ControladorTelaPrincipal();
        controle.addObservador(this);
        
        this.setSize(tam);        
        this.setTitle("Projeto Xablau!"); 
        DesktopPane.add(sobre);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnNovoMapa = new javax.swing.JMenuItem();
        btnTutorial = new javax.swing.JMenuItem();
        btnSobre = new javax.swing.JMenuItem();
        btnSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        DesktopPane.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        jMenu1.setText("Arquivo");

        btnNovoMapa.setText("Novo mapa");
        btnNovoMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoMapaActionPerformed(evt);
            }
        });
        jMenu1.add(btnNovoMapa);

        btnTutorial.setText("Tutorial");
        btnTutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutorialActionPerformed(evt);
            }
        });
        jMenu1.add(btnTutorial);

        btnSobre.setText("Sobre");
        btnSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSobreActionPerformed(evt);
            }
        });
        jMenu1.add(btnSobre);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jMenu1.add(btnSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(DesktopPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoMapaActionPerformed
        
        TelaMapa mapa = new TelaMapa();
        mapa.setSize(tam.width, tam.height - 100);
        mapa.setVisible(true); 
        DesktopPane.add(mapa, 0);
        
        controle.novoMapa();        
    }//GEN-LAST:event_btnNovoMapaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    private void btnSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSobreActionPerformed
        DesktopPane.removeAll();
        this.sobre = new TelaSobre();     
        this.sobre.setVisible(true);
        DesktopPane.add(sobre);
    }//GEN-LAST:event_btnSobreActionPerformed

    private void btnTutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutorialActionPerformed
        DesktopPane.removeAll();
        TelaTutorial tutorial = new TelaTutorial();
        tutorial.setSize(tam.width, tam.height - 100);
        tutorial.setVisible(true);
        DesktopPane.add(tutorial);
    }//GEN-LAST:event_btnTutorialActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JMenuItem btnNovoMapa;
    private javax.swing.JMenuItem btnSair;
    private javax.swing.JMenuItem btnSobre;
    private javax.swing.JMenuItem btnTutorial;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

}
