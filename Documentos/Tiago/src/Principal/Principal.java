package Principal;

import model.Aresta;
import model.Mapa;
import model.Vertice;
import utilitarios.OperadorGrafo;
import view.TelaInicial;

/**
 *
 * @author Ivens
 */
public class Principal {
    
    public static void main(String args[]){
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setVisible(true);
        
        teste();
    }
    
    private static void teste(){
        Vertice va = new Vertice( "A", 0, 0);
        Vertice vb = new Vertice( "B", 5, 0);
        Vertice vc = new Vertice( "C", 0, 5);
        Vertice vd = new Vertice( "D", 5, 5);
        
        Aresta a1 = new Aresta("AB", va, vb, 5);
        Aresta a2 = new Aresta("BC", vb, vc, 5);
        Aresta a3 = new Aresta("CD", vc, vd, 5);
        Aresta a4 = new Aresta("DA", vd, va, 5);
        
        Mapa m = new Mapa( 10, 10 );
        
        m.addDesenhavel( va );
        m.addDesenhavel( vb );
        m.addDesenhavel( vc );
        m.addDesenhavel( vd );
        
        m.addDesenhavel( a1 );
        m.addDesenhavel( a2 );
        m.addDesenhavel( a3 );
        m.addDesenhavel( a4 );
        
        OperadorGrafo og = new OperadorGrafo( m );
        int i = og.calcularSolucao();
        System.out.println( "solução: " + i );
    }
}