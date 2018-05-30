package model;

public interface Desenhavel {

    public void desenhar(java.awt.Graphics g);

    public String getStringParaDocumento();

    public void andar();

    public boolean existemPontos();
}
