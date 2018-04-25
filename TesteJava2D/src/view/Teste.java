package view;

import java.awt.Dimension;
import javax.swing.JPanel;

public class Teste extends javax.swing.JFrame {

    public Teste() {
        initComponents();
        this.setLocationRelativeTo( null );
        this.setPreferredSize( new Dimension(600, 600) );
        
        final TestePanel desenhar = new TestePanel();
        final JPanel painel = new JPanel();
        painel.add(desenhar);
        painel.setPreferredSize( new Dimension(400, 300) );
        
        this.add( painel );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        Teste t = new Teste();
        t.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
