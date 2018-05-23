package view;

import controller.ControllerMapa;
import controller.ObservadorMapa;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivens
 */
public class TelaMapa extends javax.swing.JInternalFrame implements ObservadorMapa{

    ControllerMapa controller;
    
    public TelaMapa() {
        initComponents();
        controller = new ControllerMapa();
        controller.observar(this);       
        setTitle("Mapa");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        painelMapa = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        btnCarregarMapa = new javax.swing.JMenuItem();
        btnCalcularSolucao = new javax.swing.JMenuItem();
        btnLimparMapa = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        painelMapa.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout painelMapaLayout = new javax.swing.GroupLayout(painelMapa);
        painelMapa.setLayout(painelMapaLayout);
        painelMapaLayout.setHorizontalGroup(
            painelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );
        painelMapaLayout.setVerticalGroup(
            painelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        jMenu2.setText("Opções");

        btnCarregarMapa.setText("Carregar");
        btnCarregarMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarMapaActionPerformed(evt);
            }
        });
        jMenu2.add(btnCarregarMapa);

        btnCalcularSolucao.setText("Calcular Ponto de Encontro");
        btnCalcularSolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularSolucaoActionPerformed(evt);
            }
        });
        jMenu2.add(btnCalcularSolucao);

        btnLimparMapa.setText("Limpar Mapa");
        btnLimparMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparMapaActionPerformed(evt);
            }
        });
        jMenu2.add(btnLimparMapa);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarregarMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarMapaActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int retorno = fileChooser.showOpenDialog(this);
        
        if (retorno == JFileChooser.APPROVE_OPTION){            
            controller.carregarMapa(fileChooser.getSelectedFile().getAbsolutePath());
        }
        
    }//GEN-LAST:event_btnCarregarMapaActionPerformed

    private void btnLimparMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparMapaActionPerformed
        controller.limparMapa();
    }//GEN-LAST:event_btnLimparMapaActionPerformed

    private void btnCalcularSolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularSolucaoActionPerformed
        controller.calcularPontoEncontro();
    }//GEN-LAST:event_btnCalcularSolucaoActionPerformed

    @Override
    public void receberNotificacaoErroAoCarregarMapa(String erro) {
        JOptionPane.showMessageDialog(this, erro);
    }
    
    @Override
    public void receberNotificacaoMapaLimpo() {
        JOptionPane.showMessageDialog(this, "Mapa resetado!");
    }

    @Override
    public void receberNotificacaoMapaCarregado(boolean temRegistros) {
        if (!temRegistros) JOptionPane.showMessageDialog(this, "Não foram encontrados registros no arquivo escolhido!");
        else {
           PainelTeste teste = new PainelTeste(controller.getMapa().getListaDesenhaveis());           
           teste.setSize(600, 400);
           this.add(teste);           
        }
    }
    
    @Override
    public void receberNotificacaoPontoEncontroDefinido(double x, double y) {
        JOptionPane.showMessageDialog(this, "O ponto de encontro fica no Vértice com x = " + x + " e y = " + y);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCalcularSolucao;
    private javax.swing.JMenuItem btnCarregarMapa;
    private javax.swing.JMenuItem btnLimparMapa;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel painelMapa;
    // End of variables declaration//GEN-END:variables
  
}
