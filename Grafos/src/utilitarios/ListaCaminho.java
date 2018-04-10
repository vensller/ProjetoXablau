package utilitarios;

import model.No;

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
}
