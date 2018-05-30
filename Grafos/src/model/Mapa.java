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

    public List< Vertice> getVertices() {
        List< Vertice> listaVertices = new ArrayList<>();
        for (Desenhavel d : listaDesenhaveis) {
            if (d instanceof Vertice) {
                listaVertices.add((Vertice) d);
            }
        }
        return listaVertices;
    }

    public List<Aresta> getArestas() {
        List< Aresta> listaArestas = new ArrayList<>();
        for (Desenhavel d : listaDesenhaveis) {
            if (d instanceof Aresta) {
                listaArestas.add((Aresta) d);
            }
        }
        return listaArestas;
    }

    public List<Individuo> getIndividuos() {
        List<Individuo> listaIndividuos = new ArrayList<>();
        for (Desenhavel d : listaDesenhaveis) {
            if (d instanceof Individuo) {
                listaIndividuos.add((Individuo) d);
            }
        }
        return listaIndividuos;
    }

    public List<Desenhavel> getListaDesenhaveis() {
        return listaDesenhaveis;
    }

    public void setListaDesenaveis(List<Desenhavel> listaDesenhaveis) {
        this.listaDesenhaveis = listaDesenhaveis;
    }

    public void addDesenhavel(Desenhavel d) {
        listaDesenhaveis.add(d);
    }

    public void removeDesenhavel(Desenhavel d) {
        listaDesenhaveis.remove(d);
    }

    public void imprimirListaDesenhaveis() {

        for (Desenhavel d : listaDesenhaveis) {
            System.out.println(d.getStringParaDocumento());
        }

    }
}
