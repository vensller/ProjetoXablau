package utilitarios;

import model.Mapa;

public class OperadorGrafo {
	
	private Mapa mapa;
	
	public OperadorGrafo( Mapa m ) {
		this.mapa = m;
	}
	
	public boolean verificarGrafo() {
		
		return false;
	}

	public void calcularFloydWarshall( double matriz[][] ) {
		final int n = matriz.length;
		double aux;
		for( int i = 0; i < n; i++) {
			for( int j = 0; j < n; j++) {
				for( int k = 0; k < n; k++ ) {
					aux = matriz[ j ][ i ] + matriz[ i ][ k ];
					if( matriz[ j ][ k ] > aux ) {
						matriz[ j ][ k ] = aux;
					}
				}
			}
		}
//		return matriz;
	}
	
	public long retornarMenorCaminho( double matriz[][] ) {
		final int n = matriz.length;
		double menorValor = Double.MAX_VALUE, soma;
		long indiceMenorCaminho = -1;
		
		for( int i = 0; i < n; i++ ) {
			soma = 0.0;
			for( int j = 0; j < n; j++ ) {
				soma += matriz[ i ][ j ];
			}
			if( menorValor > soma ) {
				menorValor = soma;
				indiceMenorCaminho = i;
			}
		}
		
		return indiceMenorCaminho;
	}
	
	public boolean verificarAdjacencia() {
		
		return false;
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
