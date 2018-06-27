package utilitarios;

import java.util.ArrayList;
import java.util.List;
import model.Aresta;
import model.Desenhavel;
import model.Mapa;
import model.Vertice;

/**
 *
 * @author Ivens
 */
public class FloydWarshall {
    
    private Mapa mapa;
    
    public FloydWarshall(Mapa mapa){
        this.mapa = mapa;
    }
    
    public Vertice calcularSolucao() {
        long res;
        double aux;
        double[][] matriz;
        List< Aresta> listasArestas = new ArrayList<>();
        List< Vertice> listasVertices = new ArrayList<>();

        {
            Aresta a;
            Vertice v;
            for (Desenhavel des : mapa.getListaDesenhaveis()) {
                if (des instanceof Aresta) {
                    a = (Aresta) des;
                    listasArestas.add( a );
                    
                    v = a.getOrigem();
                    if( !listasVertices.contains(v) ){
                        listasVertices.add( v );
                    }
                    
                    v = a.getDestino();
                    if( !listasVertices.contains( v ) ){
                        listasVertices.add( v );
                    }
                }
            }
        }
        
        matriz = new double[ listasVertices.size() ][ listasVertices.size() ];
        
        for( int i = 0; i < listasVertices.size(); i++ ){
            for( int j = 0; j < listasVertices.size(); j++ ){
                if( i == j ){
                    matriz[ i ][ j ] = 0.0;
                }else{
                    aux = verificarAdjacencia(
                            listasVertices.get( i ),
                            listasVertices.get( j ),
                            listasArestas
                        );
                    if( aux != -1 ){
                        matriz[ i ][ j ] = aux;
                    }else{
                        matriz[ i ][ j ] = Double.MIN_VALUE;
                    }
                }
            }
        }
        
        res = retornarMenorCaminho( calcularFloydWarshall( matriz ) );
        return listasVertices.get( (int) res);
    }

    private double[][] calcularFloydWarshall(double matriz[][]) {
        final int n = matriz.length;
        double aux;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    aux = matriz[j][i] + matriz[i][k];
                    if (matriz[j][k] > aux) {
                        matriz[j][k] = aux;
                    }
                }
            }
        }
        return matriz;
    }

    private int retornarMenorCaminho(double matriz[][]) {
        final int n = matriz.length;
        double menorValor = Double.MAX_VALUE, soma;
        int indiceMenorCaminho = -1;

        for (int i = 0; i < n; i++) {
            soma = 0.0;
            for (int j = 0; j < n; j++) {
                soma += matriz[i][j];
            }
            if (menorValor > soma) {
                menorValor = soma;
                indiceMenorCaminho = i;
            }
        }

        return indiceMenorCaminho;
    }

    public double verificarAdjacencia( Vertice v1, Vertice v2, List< Aresta > listaArestas ) {
        for( Aresta a : listaArestas ){
            if( ( a.getOrigem().equals( v1 ) && a.getDestino().equals( v2 ) )
                || ( a.getDestino().equals( v1 ) && a.getOrigem().equals( v2 ) ) ){
                return a.getComprimento();
            }
        }
        return -1;
    }
}
