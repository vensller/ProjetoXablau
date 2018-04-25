package view;

import java.awt.Color;
import java.awt.Graphics;

public class TestePanel extends javax.swing.JPanel {

    public TestePanel() {
        initComponents();
        setBackground( Color.WHITE );
    }
    
    private void desenharAlgo( Graphics g ){
        g.drawLine( 10, 10, 20, 20);
    }
    
    @Override
    public void paintComponent( Graphics g ){
        super.paintComponent( g );
        desenharAlgo( g );
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
