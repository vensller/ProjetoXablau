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
    
    private PainelTeste desenhar;

    public TelaTeste( List<Desenhavel> listaDesenhaveis ) {
        initComponents();
        this.setLocationRelativeTo( null );
        this.setSize(600, 600);
        
        this.listaDesenhaveis = listaDesenhaveis;
        
//        JButton botao = new JButton();
        
        desenhar = new PainelTeste( this.listaDesenhaveis );
        desenhar.setSize( 500, 500 );
        
        this.add( desenhar );
        
    }

    public void setListaDesenhaveis( List<Desenhavel> listaDesenhaveis ){
        this.listaDesenhaveis = listaDesenhaveis;
    }
    
    public void iniciarDesenhos(){
        desenhar.iniciarDesenhos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoCaminhar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botaoCaminhar.setText("Caminhar");
        botaoCaminhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCaminharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(514, Short.MAX_VALUE)
                .addComponent(botaoCaminhar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(botaoCaminhar)
                .addContainerGap(247, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCaminharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCaminharActionPerformed
        iniciarDesenhos();
    }//GEN-LAST:event_botaoCaminharActionPerformed


    public static void main(String args[]) {
        final int mul = 100;
        Individuo i1, i2;
        Aresta a1, a2, a3, a4, a5;
        Vertice v1, v2, v3, v4, v5, v6;
        List<Desenhavel> listaDesenhaveis = new ArrayList<>();
        
        v1 = new Vertice("v1", 2*mul, 1*mul);
        v2 = new Vertice("v2", 2*mul, 2*mul);
        v3 = new Vertice("v3", 1*mul, 1.5*mul);
        v4 = new Vertice("v4", 2*mul, 3*mul);
        v5 = new Vertice("v5", 3*mul, 2*mul);
        v6 = new Vertice("v6", 3*mul, 1*mul);
        
        a1 = new Aresta( v1, v2, 1*mul, true, "a1");
        listaDesenhaveis.add( a1 );
        
        a2 = new Aresta( v3, v2, 2*mul, true, "a2");
        listaDesenhaveis.add( a2 );
        
        a3 = new Aresta( v4, v2, 1*mul, true, "a3");
        listaDesenhaveis.add( a3 );
        
        a4 = new Aresta( v5, v2, 1*mul, true, "a4");
        listaDesenhaveis.add( a4 );
        
        a5 = new Aresta( v5, v6, 1*mul, true, "a5");
        listaDesenhaveis.add( a5 );
        
        i1 = new Individuo( v3, "i1");
        listaDesenhaveis.add( i1 );
        
        i2 = new Individuo( v6, "i2");
        listaDesenhaveis.add( i2 );
        
        listaDesenhaveis.add( v1 );
        listaDesenhaveis.add( v2 );
        listaDesenhaveis.add( v3 );
        listaDesenhaveis.add( v4 );
        listaDesenhaveis.add( v5 );
        listaDesenhaveis.add( v6 );
        
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
    private javax.swing.JButton botaoCaminhar;
    // End of variables declaration//GEN-END:variables
}
