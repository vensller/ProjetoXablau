package view;

import java.awt.Graphics;
import java.util.List;
import model.Desenhavel;

public class PainelTeste extends javax.swing.JPanel {
    
    private List<Desenhavel> listaDesenhaveis;

    public PainelTeste( List<Desenhavel> listaDesenhaveis ) {
        initComponents();
        this.listaDesenhaveis = listaDesenhaveis;
    }
    
    @Override
    public void paintComponent( Graphics g ){
        super.paintComponent( g );
        for( Desenhavel d : listaDesenhaveis ){
            d.desenhar(g);
        }
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

    public void iniciarDesenhos() {
        Thread t = new Thread(){
            @Override
            public void run(){
                while( houverPontos() ){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    repaint();
//                    System.out.println("Contador: " + contador );
                    for( Desenhavel d: listaDesenhaveis){
                        d.andar();
                    }
                }
                System.out.println("ACABOU OS PONTOS");
            }
        };
        t.start();
    }

    private boolean houverPontos() {
        boolean existemPontos = false;
        for( Desenhavel d : listaDesenhaveis ){
            existemPontos = existemPontos || d.existemPontos();
        }
        return existemPontos;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
