/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Ivens
 */
public class TelaMapa extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form TelaMapa
     */
    public TelaMapa() {
        initComponents();
        setVisible(true);
        setBackground(new java.awt.Color(255, 0, 0));;
        
        MeuPainel meu = new MeuPainel();
        meu.setSize(400, 200);
        this.add(meu);

//        JButton btn = new JButton();
//        btn.setText("botao");
//        btn.setSize(100,40);
//        
//        this.add(btn);
            
repaint();

    }

    @Override
    public void paintComponent(Graphics g) {
//        Graphics2D G2D = (Graphics2D) g;
//        G2D.setStroke(new BasicStroke(3.0f));
//        Point2D P2D = new Point2D.Float(10.5f, 15.9f);
//        Point2D P2D2 = new Point2D.Float(80.0f, 50.0f);
//        Line2D L2D = new Line2D.Float(P2D, P2D2);
//        G2D.draw(L2D);
        g.drawLine(10, 15, 20, 20);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private class MeuPainel extends JPanel {

        public MeuPainel() {
            
        }
        
        @Override
        public void paintComponent( Graphics g ){
            super.paintComponent(g);
            g.drawLine(10, 15, 100, 120);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
