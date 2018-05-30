package model;

import java.util.ArrayList;
import java.util.List;
import utilitarios.CalculosCurva;

/**
 *
 * @author Ivens
 */
public class ListaCaminho {

    private No inicio;
    private No fim;
    
    public ListaCaminho(){
        this.inicio = null;
        this.fim = null;
    }    
    
    public void Adicionar(No noAdd){
        if (inicio == null){
            inicio = noAdd;
            fim = inicio;
            inicio.setProximo(null);            
        }else{
            if (inicio == fim){
                inicio.setProximo(noAdd);
                fim = noAdd;
            }else{
                fim.setProximo(noAdd);         
                noAdd.setProximo(null);
                fim = noAdd;
            }
        }
    }
    
    public List<Vertice> calcularCaminho(){
        No aux = inicio;
        List<Vertice> listaVertices = new ArrayList<>();
        CalculosCurva cc;
        
        while( aux != null ){
            cc = new CalculosCurva( aux.getAresta() );
            listaVertices.addAll( cc.getPontos() );
            aux = aux.getProximo();
        }
        
        return listaVertices;
    }

    public String listar(){
        No atual = inicio; 
        String retorno = ""; 
        while (atual != null){ 
            retorno += "Aresta: " + atual.getAresta().getStringParaDocumento() + ".\n"; 
            atual = atual.getProximo(); 
        } 
        return retorno; 
    }
       
}
