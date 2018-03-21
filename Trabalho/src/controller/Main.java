package controller;

import view.Tela;

public class Main {

	public static void main( String[] args ) {
		
		Tela t = new Tela();
		t.setVisible(true);
		/*double matriz[][] =
		{
				{ 0, 1, 3, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
				{ 1, 0, 1, 3, 2, Double.MAX_VALUE},
				{ 3, 1, 0, 2, Double.MAX_VALUE, Double.MAX_VALUE},
				{ Double.MAX_VALUE, 3, 2, 0, 3, 2 },
				{ Double.MAX_VALUE, 2, Double.MAX_VALUE, 3, 0, 3 },
				{ Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 2, 3, 0}
		};
		
		OperadorGrafo.floydWarshall( matriz );
		
		System.out.println("Matriz:");
		for( int i = 0; i < matriz.length; i++) {
			System.out.printf("%2d: ", i);
			for( int j = 0; j < matriz.length; j++ ) {
				System.out.printf("%6f", matriz[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		
		long valor1 = OperadorGrafo.retornarMenorCaminho( matriz );
		long valor2 = OperadorGrafo.retornaMenorCaminhoMediano( matriz );
		
		if( valor1 == valor2 ) {
			System.out.println("Sim");
		}else {
			System.out.println("Não");
		}
*/
	}
}
