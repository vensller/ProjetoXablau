package utilitarios;

import java.util.ArrayList;
import java.util.List;
import model.Aresta;
import model.Grafo;
import model.Mapa;
import model.No;
import model.Vertice;

/**
 *
 * @author Ivens
 */
public class Dijkstra {

    private Mapa mapa;
    private Grafo grafo;    
    private List<Integer> naoVisitados;
    private Double custos[];
    private int antecessores[];
    
    public Dijkstra(Mapa mapa){
        this.mapa = mapa;
        this.grafo = new Grafo(mapa.getVertices().size());        
        this.custos = new Double[mapa.getVertices().size()];
        this.naoVisitados = new ArrayList<>();
        this.antecessores = new int[mapa.getVertices().size()];
    }
    
    public ListaCaminho retornaMenorCaminho(Vertice origem, Vertice destino){
        ListaCaminho menorCaminho = null;
        this.adicionaVerticesNoGrafo(origem);
        
        while(!naoVisitados.isEmpty()){
            int verticeMenorCusto = retornaVerticeMenorCustoNaoVisitado();
            naoVisitados.remove(verticeMenorCusto);
            
            for (int vizinho : retornaVizinhos(verticeMenorCusto)){
                Double custoTotal = custos[verticeMenorCusto] + grafo.getCusto(verticeMenorCusto, vizinho);
                if (custoTotal < custos[vizinho]){
                    custos[vizinho] = custoTotal;
                    antecessores[vizinho] = verticeMenorCusto;
                }
            }
            if (mapa.getVertices().get(verticeMenorCusto) == destino){
                criaListaMenorCaminho(menorCaminho, destino, origem);
                return menorCaminho;
            }
        }
        
        return null;
    }
    
    private void criaListaMenorCaminho(ListaCaminho caminho, Vertice destino, Vertice origem){
        caminho = new ListaCaminho();
        List<Integer> caminhoVert = new ArrayList<>();
        int verticeDestino = mapa.getVertices().indexOf(destino);        
        caminhoVert.add(verticeDestino);        
        adicionaCaminhoRecursivo(caminhoVert, verticeDestino, mapa.getVertices().indexOf(origem));
        for (int i = caminhoVert.size() - 1; i >= 0; i --){
            No novoNo = new No(mapa.getVertices().get(i), null);
            caminho.Adicionar(novoNo);
        }
    }
    
    private void adicionaCaminhoRecursivo(List<Integer> caminho, int vertice, int verticeParada){
        int antecessor = antecessores[vertice];
        if (antecessor > 0){
            caminho.add(antecessor);
            if (antecessor != verticeParada)
            adicionaCaminhoRecursivo(caminho, antecessor, verticeParada);
        }
    }
    
    public int retornaVerticeMenorCustoNaoVisitado(){
        int verticeMenorCusto = -1;
        Double menorCusto = Double.MAX_VALUE;
        for (int i : naoVisitados){
            if (custos[i] < menorCusto){
                verticeMenorCusto = i;
                menorCusto = custos[i];
            }
        }
        return verticeMenorCusto;
    }
    
    private void adicionaVerticesNoGrafo(Vertice origem){
        for (int i = 0; i < mapa.getVertices().size(); i++){                        
            naoVisitados.add(i);                        
            
            if (mapa.getVertices().get(i).equals(origem)) custos[i] = 0.0;
            else custos[i] = Double.MAX_VALUE;
            
            for (int j = 0; j < mapa.getVertices().size(); j++){                
                grafo.adicionaVerticesGrafo(i, j, retornaCustoVertice(mapa.getVertices().get(i), mapa.getVertices().get(j)));                                
            }
        }
    }
    
    private Double retornaCustoVertice(Vertice vertice1, Vertice vertice2){
        for (Aresta aresta : mapa.getArestas()){
            if ((aresta.getVertice01().equals(vertice1) && aresta.getVertice02().equals(vertice2))
             || (aresta.getVertice02().equals(vertice1) && aresta.getVertice01().equals(vertice2))){
                return aresta.getComprimento();
            }
        }
        return -1.0;
    }
    
    private List<Integer> retornaVizinhos(int vertice){
        List<Integer> vizinhos = new ArrayList<>();
        for (int i = 0; i < grafo.getVertices()[vertice].length; i++){
            if (grafo.getVertices()[vertice][i] > 0){
                vizinhos.add(0);
            }
        }
        return vizinhos;
    }
    
}
