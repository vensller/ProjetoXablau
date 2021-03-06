package utilitarios;

import model.ListaCaminho;
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
        limpaListasControle();
        this.adicionaVerticesNoGrafo(origem);
        
        while(!naoVisitados.isEmpty()){
            int verticeMenorCusto = retornaVerticeMenorCustoNaoVisitado();
            naoVisitados.remove(naoVisitados.indexOf(verticeMenorCusto));
            
            for (int vizinho : retornaVizinhos(verticeMenorCusto)){                
                double custoTotal = custos[verticeMenorCusto] + grafo.getCusto(verticeMenorCusto, vizinho);
                if (custoTotal < custos[vizinho]){
                    custos[vizinho] = custoTotal;
                    antecessores[vizinho] = verticeMenorCusto;
                }
            }
            if (mapa.getVertices().get(verticeMenorCusto) == destino){
                menorCaminho = new ListaCaminho();
                criaListaMenorCaminho(menorCaminho, destino, origem);
                return menorCaminho;
            }
        }
        
        return null;
    }
    
    private void limpaListasControle(){
        this.custos = new Double[mapa.getVertices().size()];
        this.naoVisitados = new ArrayList<>();
        this.antecessores = new int[mapa.getVertices().size()];    
        
        for (int i = 0; i < antecessores.length; i++){
            antecessores[i] = -1;
        }
    }
    
    private void criaListaMenorCaminho(ListaCaminho caminho, Vertice destino, Vertice origem){         
        List<Integer> caminhoVert = new ArrayList<>();
        int verticeDestino = mapa.getVertices().indexOf(destino);        
        caminhoVert.add(verticeDestino);        
        adicionaCaminhoRecursivo(caminhoVert, verticeDestino, mapa.getVertices().indexOf(origem));
        Vertice origemAtual = origem;
        for (int i = caminhoVert.size() - 1; i > 0; i --){
            Aresta a = retornaAresta(mapa.getVertices().get(caminhoVert.get(i)), mapa.getVertices().get(caminhoVert.get(i - 1)));
            
            if (a != null){
                boolean invertido = false;       
                boolean origemPosicaoCorreta = true;
                
                if (a.getPontos().size() > 0){
                    if ((a.getPontos().get(0).getValorX() != a.getOrigem().getValorX()) || (a.getPontos().get(0).getValorY() != a.getOrigem().getValorY())){
                        origemPosicaoCorreta = false;
                    }
                }
                
                if ((a.getOrigem() != origemAtual)&&(origemPosicaoCorreta)){
                    invertido = true;
                }
                
                if (a.getOrigem() == origemAtual) origemAtual = a.getDestino();
                else origemAtual = a.getOrigem();                 

                No novoNo = new No(a, null, invertido);            
                caminho.Adicionar(novoNo);
            }
        }        
    }    
    
    private void adicionaCaminhoRecursivo(List<Integer> caminho, int vertice, int verticeParada){
        int antecessor = antecessores[vertice];
        if (antecessor > -1){
            caminho.add(antecessor);
            if (antecessor != verticeParada)
            adicionaCaminhoRecursivo(caminho, antecessor, verticeParada);
        }
    }
    
    public int retornaVerticeMenorCustoNaoVisitado(){
        int verticeMenorCusto = -1;
        Double menorCusto = Double.MAX_VALUE;
        for (int i : naoVisitados){
            if (custos[i] < menorCusto) {
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
                Aresta aresta = retornaAresta(mapa.getVertices().get(i), mapa.getVertices().get(j));
                Double comprimento = -1.0;
                Boolean bidirecional = true;
                
                if (aresta != null){
                    comprimento = aresta.getComprimento();
                    bidirecional = aresta.isBidirecional();
                }
                
                grafo.adicionaVerticesGrafo(i, j, comprimento, bidirecional);                                
            }
        }
    }    
    
    private Aresta retornaAresta(Vertice origem, Vertice destino){
        for (Aresta aresta : mapa.getArestas()){
            if ((aresta.getOrigem().equals(origem) && aresta.getDestino().equals(destino))
             || (aresta.getDestino().equals(origem) && aresta.getOrigem().equals(destino))){               
                return aresta;                
            }
        }
        return null;
    }
    
    private List<Integer> retornaVizinhos(int vertice){
        List<Integer> vizinhos = new ArrayList<>();
        for (int i = 0; i < grafo.getVertices()[vertice].length; i++){
            if (grafo.getVertices()[vertice][i] > 0){
                vizinhos.add(i);
            }
        }
        return vizinhos;
    }
    
}
