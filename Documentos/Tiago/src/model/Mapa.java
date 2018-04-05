package model;

import java.util.ArrayList;
import java.util.List;

public class Mapa {

	private List<Desenhavel> listaDesenhaveis = new ArrayList<>();
	private double tamanhoHorizontal;
	private double tamanhoVertical;
	
	public Mapa(double tamanhoHorizontal, double tamanhoVertical) {
		this.tamanhoHorizontal = tamanhoHorizontal;
		this.tamanhoVertical = tamanhoVertical;
	}

	public List<Desenhavel> getListaDesenhaveis() {
		return listaDesenhaveis;
	}

	public void setListaDesenaveis(List<Desenhavel> listaDesenhaveis) {
		this.listaDesenhaveis = listaDesenhaveis;
	}

	public void addDesenhavel( Desenhavel d ) {
		listaDesenhaveis.add( d );
	}
	
	public void removeDesenhavel( Desenhavel d ) {
		listaDesenhaveis.remove( d );
	}
}
