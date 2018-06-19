package controller;

import java.util.ArrayList;
import java.util.List;
import model.Mapa;
import utilitarios.OperadorArquivos;

/**
 *
 * @author Ivens
 */
public class ControllerMapa {
    
    Mapa mapa;
    OperadorArquivos operadorArquivo;
    List<ObservadorMapa> observadores;
    Boolean mapaCarregado;
    OperadorGrafo operador;
    
    public ControllerMapa(){
        mapa = new Mapa(600, 400);    
        observadores = new ArrayList<>();
        mapaCarregado = false;        
    }
    
    public void observar(ObservadorMapa obs){
        observadores.add(obs);
    }
    
    public void pararObservacao(ObservadorMapa obs){
        observadores.remove(obs);
    }
    
    public void carregarMapa(String nomeArquivo){
        operadorArquivo = new OperadorArquivos(nomeArquivo);     
        operador = new OperadorGrafo(mapa);
        try{
            this.mapa.setListaDesenhaveis(operadorArquivo.ler());
            this.mapaCarregado = !mapa.getListaDesenhaveis().isEmpty();
            this.notificarCarregamentoMapa();
        }catch (Exception e){
            this.notificarErroAoCarregarMapa(e.getMessage());
        }
    }
    
    public void limparMapa(){
        this.mapa.limpaDesenhaveis();
        this.mapaCarregado = false;
        this.operador = null;
        this.notificarLimpezaMapa();
    }
    
    public void calcularPontoEncontro(){
        if (!mapa.getVertices().isEmpty()){
            try{
                operador.definirPontoEncontro();
                if (operador.getPontoEncontro() != null){
                    operador.getPontoEncontro().setPontoEncontro(true);
                    this.notificarPontoEncontroDefinido(operador.getPontoEncontro().getValorX(), operador.getPontoEncontro().getValorY());
                }
            }catch(Exception e){
                this.notificarErroAoDefinirPontoEncontro();
            }            
        }
    }
    
    public void iniciarEncontro(){
        if (operador.getPontoEncontro() != null){
            operador.definirCaminhosIndividuosDestino(operador.getPontoEncontro());
            notificarCaminhosDefinidos();
        }else {
            this.notificarPontoEncontroNaoDefinido();
        }
    }
    
    private void notificarErroAoDefinirPontoEncontro(){
        for (ObservadorMapa obs: observadores){
            obs.receberNotificacaoErroCalcularPontoEncontro();
        }
    }
    
    private void notificarCaminhosDefinidos(){
        for (ObservadorMapa obs : observadores){
            obs.receberNotificacaoCaminhosDefinidos();
        }
    }
    
    private void notificarPontoEncontroNaoDefinido(){
        for (ObservadorMapa obs : observadores){
            obs.receberNotificacaoPontoEncontroNaoDefinido();
        }
    }
    
    private void notificarPontoEncontroDefinido(double x, double y){
        for (ObservadorMapa obs : observadores){
            obs.receberNotificacaoPontoEncontroDefinido(x, y);
        }
    }
    
    private void notificarCarregamentoMapa(){
        for (ObservadorMapa obs : observadores){
            obs.receberNotificacaoMapaCarregado(mapaCarregado);
        }
    }
    
    private void notificarErroAoCarregarMapa(String erro){
        for (ObservadorMapa obs : observadores){
            obs.receberNotificacaoErroAoCarregarMapa(erro);
        }
    }
    
    private void notificarLimpezaMapa(){
        for (ObservadorMapa obs : observadores){
            obs.receberNotificacaoMapaLimpo();
        }
    }
    
    public Mapa getMapa(){ //RETIRAR
        return this.mapa;
    }
    
}
