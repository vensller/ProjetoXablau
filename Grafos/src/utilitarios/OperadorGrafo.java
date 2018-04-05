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

//	public long retornaMenorCaminhoMediano( double matriz[][] ) {
//		final int n = matriz.length;
//		long indiceMenorCaminho = -1;
//		double valorAtual, valorMenor = Double.MAX_VALUE;
//		
//		for( int i = 0; i < n; i++ ) {
//			valorAtual = calcDesvioPadrao( matriz[ i ] );
//			if( valorMenor > valorAtual ) {
//				valorMenor = valorAtual;
//				indiceMenorCaminho = i;
//			}
//		}
//		
//		return indiceMenorCaminho;
//	}
//	
//	private double calcDesvioPadrao( double dados[] ) {
//		double media = 0.0, desvioPadrao = 0.0;
//		final int tamanho = dados.length;
//		
//		for( int i = 0; i < tamanho; i++ ) {
//			media += dados[ i ] / (double) tamanho;
//		}
//		
//		for( int i = 0; i < tamanho; i++ ) {
//			desvioPadrao += Math.pow( dados[ i ] - media, 2 ) / ( (double) (tamanho - 1) ) ;
//		}
//		desvioPadrao = Math.sqrt(desvioPadrao);
//		return desvioPadrao;
//	}
//	
}