package utilitarios;

import java.util.ArrayList;
import java.util.List;
import model.Aresta;
import model.Desenhavel;
import model.Mapa;
import model.Vertice;

public class OperadorGrafo {

    private Mapa mapa;

    public OperadorGrafo(Mapa m) {
        this.mapa = m;
    }

    public boolean verificarGrafo() {

        return false;
    }
    
    public double dijkstraSimples( Vertice origem, Vertice destino ){
        int intAux;
        double auxDou;
        Vertice auxVer;
        
        double resultado = 0.0;
        List< Vertice > listaVertices = mapa.getVertices();
        List< Aresta > listaAresta = mapa.getArestas();
        final int NUMERO_VERTICES = listaVertices.size();
        double distancias[][] = new double[ NUMERO_VERTICES ][ NUMERO_VERTICES ];
        boolean adjacentes[][] = new boolean[ NUMERO_VERTICES ][ NUMERO_VERTICES ];
        boolean visitados[] = new boolean[ NUMERO_VERTICES ];
        FilaPrioritaria fp = new FilaPrioritaria();
        
        for( int i = 0; i < NUMERO_VERTICES; i++ ){
            visitados[ i ] = false;
            for( int j = 0; j < NUMERO_VERTICES; j++ ){
                if( i == j ){
                    distancias[ i ][ j ] = 0.0;
                }else{
                    distancias[ i ][ j ] = Double.MAX_VALUE;
                }
                adjacentes[ i ][ j ] =
                    verificarAdjacencia(
                        listaVertices.get( i ), 
                        listaVertices.get( j ),
                        listaAresta
                    ) == -1;
            }
        }
        
        fp.adicionar( origem, 0 );
        
        while( !fp.estaVazio() ){
            auxDou = fp.getDistanciaTopo();
            auxVer = fp.getVerticeTopo();
            fp.removeTopo();
            intAux = listaVertices.indexOf( auxVer );
            
            if( visitados[ intAux ] == false ){
                visitados[ intAux ] = true;
                
                
            }
        }
        
        return resultado;
    }

    public Vertice calcularSolucao() {
        long res;
        double aux;
        double[][] matriz;
        List< Aresta> listasArestas = new ArrayList<>();
        List< Vertice> listasVertices = new ArrayList<>();

        for (Desenhavel des : mapa.getListaDesenhaveis()) {
            if (des instanceof Aresta) {
                listasArestas.add((Aresta) des);
            }
        }

        for (Desenhavel des : mapa.getListaDesenhaveis()) {
            if (des instanceof Vertice) {
                listasVertices.add((Vertice) des);
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
                        matriz[ i ][ j ] = Double.MAX_VALUE;
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
            if( ( a.getVertice01().equals( v1 ) && a.getVertice02().equals( v2 ) )
                || ( a.getVertice02().equals( v1 ) && a.getVertice01().equals( v2 ) ) ){
                return a.getComprimento();
            }
        }
        return -1;
    }

    private class FilaPrioritaria {
        private int tamanho = -1;
        private List< Vertice > listaVer = new ArrayList<>();
        private List< Double > listaDou = new ArrayList<>();
        
        public void adicionar( Vertice v, double distancia ){
            int posicao = 0;
            if( tamanho == 0){
                posicao = 0;
            }else{
                for( int i = 0; i < tamanho; i++ ){
                    if( distancia < listaDou.get( i ) ){
                        posicao = i;
                    }
                }
            }
            
            listaVer.set( posicao, v );
            listaDou.set( posicao, distancia );
            tamanho++;
        }
        
        public boolean estaVazio(){
            return tamanho == 0;
        }
        
        public Vertice getVerticeTopo( ){
            return listaVer.get( tamanho );
        }
        
        public double getDistanciaTopo( ){
            return listaDou.get( tamanho );
        }
        
        public void removeTopo(){
            listaVer.remove( tamanho );
            listaDou.remove( tamanho );
            tamanho--;
        }
        
    }
}