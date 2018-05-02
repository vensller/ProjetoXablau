package Principal;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mapa;
import model.Vertice;
import utilitarios.Dijkstra;
import controller.OperadorGrafo;
import view.TelaInicial;

/**
 *
 * @author Ivens
 */
public class Principal {

    public static void main(String args[]) {
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setVisible(true);

//        teste();
    }

    private static void teste() {
//        Vertice va = new Vertice( "A", 0, 0);
//        Vertice vb = new Vertice( "B", 0, 5);
//        Vertice vc = new Vertice( "C", 5, 5);
//        Vertice vd = new Vertice("D", 10, 5);
//        Vertice ve = new Vertice("E", 10, 10);
//        Vertice vf = new Vertice("F", 10, 15);
//        Vertice vg = new Vertice("G", 15, 15);
////        Vertice vd = new Vertice( "D", 5, 5);
//        
//        Aresta a1 = new Aresta("AB", va, vb, 5);
//        Aresta a2 = new Aresta("BC", vb, vc, 2);
//        Aresta a3 = new Aresta("BE", vb, ve, 5);
//        Aresta a4 = new Aresta("BD", vb, vd, 3);
//        Aresta a5 = new Aresta("CG", vc, vg, 4);
//        Aresta a6 = new Aresta("GF", vg, vf, 6);
//        Aresta a7 = new Aresta("EF", ve, vf, 3);
//        Aresta a8 = new Aresta("DF", vd, vf, 4);
//        Aresta a4 = new Aresta("DA", vd, va, 5);        

        Mapa m = new Mapa(10, 10);
        try {
            //
//        m.addDesenhavel( va );
//        m.addDesenhavel( vb );
//        m.addDesenhavel( vc );
//        m.addDesenhavel(vd);
//        m.addDesenhavel(ve);
//        m.addDesenhavel(vf);
//        m.addDesenhavel(vg);
////        m.addDesenhavel( vd );
//        
//        m.addDesenhavel( a1 );
//        m.addDesenhavel( a2 );
//        m.addDesenhavel( a3 );
//        m.addDesenhavel(a4);
//        m.addDesenhavel(a5);
//        m.addDesenhavel(a6);
//        m.addDesenhavel(a7);
//        m.addDesenhavel(a8);
//        m.addDesenhavel( a4 );
            m.setListaDesenaveis(new utilitarios.OperadorArquivos("teste.txt").ler());
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dijkstra dijkstra = new Dijkstra(m);
        m.imprimirListaDesenhaveis();            

        OperadorGrafo og = new OperadorGrafo(m);
        Vertice v = og.definirPontoEncontro();
        og.definirCaminhosIndividuosDestino(v);
        System.out.println("solução: " + v.toString());
    }
}
