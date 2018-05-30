package controller;

/**
 *
 * @author Ivens
 */
public interface ObservadorMapa {
   
    void receberNotificacaoErroAoCarregarMapa(String erro);
    void receberNotificacaoMapaCarregado(boolean temRegistros);
    void receberNotificacaoMapaLimpo();
    void receberNotificacaoPontoEncontroDefinido(double x, double y);
    void receberNotificacaoPontoEncontroNaoDefinido();
}
