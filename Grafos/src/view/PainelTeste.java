package view;

import java.awt.Graphics;
import java.util.List;
import model.Aresta;
import model.Individuo;
import model.Mapa;
import model.Vertice;

public class PainelTeste extends javax.swing.JPanel {
    
    private Mapa mapa;
    private List<Individuo> listaIndividuos;
    private List<Aresta> listaArestas;
    private List<Vertice> listaVertices;

    public PainelTeste( Mapa mapa ) {
        initComponents();
        this.mapa = mapa;
        this.listaIndividuos = mapa.getIndividuos();
        this.listaArestas = mapa.getArestas();
        this.listaVertices = mapa.getVertices();
    }
    
    private void verificaListas(){
        listaIndividuos = mapa.getIndividuos();
        listaArestas = mapa.getArestas();
        listaVertices = mapa.getVertices();
    }
    
    @Override
    public void paintComponent( Graphics g ){
        super.paintComponent( g );
        verificaListas();
        for (Aresta a : listaArestas){
            a.desenhar(g);
        }
        for (Vertice v : listaVertices){
            v.desenhar(g);
        }
        for (Individuo i : listaIndividuos){
            i.desenhar(g);
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
                    for( Individuo i: listaIndividuos){
                        i.andar();
                    }
                }
                System.out.println("ACABOU OS PONTOS");
            }
        };
        t.start();
    }

    private boolean houverPontos() {
        boolean existemPontos = false;
        for( Individuo i : listaIndividuos ){
            existemPontos = existemPontos || i.existemPontos();
        }
        return existemPontos;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
