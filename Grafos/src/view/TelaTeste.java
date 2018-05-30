package view;

import java.util.ArrayList;
import java.util.List;
import model.Aresta;
import model.Desenhavel;
import model.Individuo;
import model.Mapa;
import model.Vertice;
import utilitarios.Dijkstra;
import utilitarios.FloydWarshall;

/**
 *
 * @author tiago
 */
public class TelaTeste extends javax.swing.JFrame {
    
    private List<Desenhavel> listaDesenhaveis;

    public TelaTeste( List<Desenhavel> listaDesenhaveis ) {
        initComponents();
        this.setLocationRelativeTo( null );
        this.setSize(600, 600);
        
        this.listaDesenhaveis = listaDesenhaveis;
        
//        JButton botao = new JButton();
        
        PainelTeste desenhar = new PainelTeste( this.listaDesenhaveis );
        desenhar.setSize( 500, 500 );
        
        this.add( desenhar );
        
    }

    public void setListaDesenhaveis( List<Desenhavel> listaDesenhaveis ){
        this.listaDesenhaveis = listaDesenhaveis;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        final int mul = 100;
        Individuo i1, i2, i3;
        List<Desenhavel> listaDesenhaveis = new ArrayList<>();
        
        listaDesenhaveis.add( 
            new Aresta( new Vertice("", 2*mul, 1*mul),
            new Vertice("", 2*mul, 2*mul), 1*mul, false, "") );
        
        listaDesenhaveis.add( 
            new Aresta( new Vertice("", 1*mul, 2*mul), 
            new Vertice("", 2*mul, 2*mul), 1*mul, false, "") );
        
        listaDesenhaveis.add(
            new Aresta( new Vertice("", 2*mul, 3*mul),
            new Vertice("", 2*mul, 2*mul), 1*mul, false, "") );
        
        listaDesenhaveis.add(
            new Aresta( new Vertice("", 3*mul, 2*mul),
            new Vertice("", 2*mul, 2*mul), 1*mul, false, "") );
        
        i1 = new Individuo(new Vertice("", 1*mul, 2*mul), "");
        listaDesenhaveis.add( i1 );
        
        i2 = new Individuo(new Vertice("", 2*mul, 3*mul), "");
        listaDesenhaveis.add( i2 );
        
        Mapa mp = new Mapa(200, 200);
        mp.setListaDesenaveis(listaDesenhaveis);
        
        FloydWarshall fw = new FloydWarshall(mp);
        Vertice solucao = fw.calcularSolucao();
        
        Dijkstra d = new Dijkstra(mp);
        i1.setCaminho( d.retornaMenorCaminho( i1.getLocalizacao(), solucao) );
        i2.setCaminho( d.retornaMenorCaminho( i2.getLocalizacao(), solucao) );
        
        TelaTeste tt = new TelaTeste( listaDesenhaveis );
        tt.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
