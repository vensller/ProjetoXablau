package model;

import java.util.ArrayList;
import java.util.List;

public class Mapa {

    private List<Desenhavel> listaDesenhaveis;
    private List<Individuo> listaIndividuos;
    private List<Vertice> listaVertices;
    private List<Aresta> listaArestas;
    private double tamanhoHorizontal;
    private double tamanhoVertical;

    public Mapa(double tamanhoHorizontal, double tamanhoVertical) {
        this.tamanhoHorizontal = tamanhoHorizontal;
        this.tamanhoVertical = tamanhoVertical;
        this.listaDesenhaveis = new ArrayList();
        this.listaIndividuos = null;
        this.listaVertices = null;
        this.listaArestas = null;
    }

    public List<Vertice> getVertices() {
        if (listaVertices == null){        
            listaVertices = new ArrayList<>();
            for (Desenhavel d : listaDesenhaveis) {
                if (d instanceof Vertice) {
                    listaVertices.add((Vertice) d);
                }
            }
        }
        
        return listaVertices;
    }

    public List<Aresta> getArestas() {
        if (listaArestas == null){
            listaArestas = new ArrayList<>();
            for (Desenhavel d : listaDesenhaveis) {
                if (d instanceof Aresta) {
                    listaArestas.add((Aresta) d);
                }
            }
        }
        return listaArestas;
    }

    public List<Individuo> getIndividuos() {
        if (listaIndividuos == null){
            listaIndividuos = new ArrayList<>();
            for (Desenhavel d : listaDesenhaveis) {
                if (d instanceof Individuo) {
                    listaIndividuos.add((Individuo) d);
                }
            }
        }
        
        return listaIndividuos;
    }

    public List<Desenhavel> getListaDesenhaveis() {
        return listaDesenhaveis;
    }

    public void setListaDesenhaveis(List<Desenhavel> listaDesenhaveis) {
        this.listaDesenhaveis = listaDesenhaveis;
    }
    
    public void addDesenhavel(Individuo i){
        listaIndividuos.add(i);
        listaDesenhaveis.add(i);
    }
    
    public void addDesenhavel(Vertice v){
        listaVertices.add(v);
        listaDesenhaveis.add(v);
    }
    
    public void addDesenhavel(Aresta a){
        listaArestas.add(a);
        listaDesenhaveis.add(a);
    }
    
    public void removeDesenhavel(Individuo i){
        listaIndividuos.remove(i);
        listaDesenhaveis.remove(i);
    }
    
    public void removeDesenhavel(Vertice v){
        listaVertices.remove(v);
        listaDesenhaveis.remove(v);
    }    
    
    public void removeDesenhavel(Aresta a){
        listaArestas.remove(a);
        listaDesenhaveis.remove(a);
    }

    public void imprimirListaDesenhaveis() {

        for (Desenhavel d : listaDesenhaveis) {
            System.out.println(d.getStringParaDocumento());
        }

    }
    
    public void limpaDesenhaveis(){
        listaDesenhaveis.clear();
        listaIndividuos = null;
        listaArestas = null;
        listaVertices = null;
    }
    
}
