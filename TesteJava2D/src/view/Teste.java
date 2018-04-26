package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Teste extends JFrame {
    
    JButton btn= new JButton();

    public Teste() {
        initComponents();
        this.setLocationRelativeTo( null );
        this.setPreferredSize( new Dimension(600, 600));
        
        TestePanel desenhar = new TestePanel();
        desenhar.setSize(new Dimension(400, 300));
        desenhar.setBackground(new java.awt.Color(255, 255, 255));
        
//        JLabel label = new JLabel();
//        label.setPreferredSize(new Dimension(200, 80));
//        label.setText("Agora foi...");
//        
        btn = new JButton();
        btn.setSize(new Dimension(100, 40));
        btn.setText("botao");
//        
//        desenhar.add(label);
        desenhar.add(btn);
        
        
//        JPanel painel = new JPanel();
////        painel.add(desenhar);
//        painel.setPreferredSize( new Dimension(400, 300) );
        
        this.add(desenhar);
        
          btn.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    repaint();
                }
            }
        );
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
