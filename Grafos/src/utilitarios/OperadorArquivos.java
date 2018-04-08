package utilitarios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aresta;

import model.Gravavel;
import model.Individuo;
import model.Vertice;

public class OperadorArquivos {

    private String nomeArquivo;

    public OperadorArquivos(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public boolean escrever(List<Gravavel> listaGravaveis) {

        return false;
    }

    public List<Gravavel> ler() throws Exception {

        List<Gravavel> listaGravaveis = new ArrayList<>();
        List<Vertice> verticesTemp = new ArrayList<>(); //lista temporária

        try {
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
            String str = "";

            while ((str = reader.readLine()) != null) {

                //primeira condição - verifica se a primeira letra da linha é 'v' ou 'a' ou 'i'
                if (String.valueOf(str.charAt(0)).equals("v") || String.valueOf(str.charAt(0)).equals("a") || String.valueOf(str.charAt(0)).equals("i")) {

                    switch (String.valueOf(str.charAt(0))) {

                        case "v":

                            String[] separadorVertice1 = str.split(":");
                            String[] separadorVertice2 = separadorVertice1[1].split(",");

                            Vertice v = new Vertice(separadorVertice2[0], Double.parseDouble(separadorVertice2[1]), Double.parseDouble(separadorVertice2[2]));

                            listaGravaveis.add(v);
                            verticesTemp.add(v);

                            break;

                        case "a":

                            String[] separadorAresta1 = str.split(":");
                            String[] separadorAresta2 = separadorAresta1[1].split(",");

                            //aresta(nome, vertice01, vetice02, comprimento)
                            Vertice v1 = null;
                            Vertice v2 = null;

                            //Obtendo vertice 1 e 2
                            for (Vertice vertice : verticesTemp) {
                                if (vertice.getNome().equals(separadorAresta2[0])) {
                                    v1 = vertice;
                                } else if (vertice.getNome().equals(separadorAresta2[1])) {
                                    v2 = vertice;
                                }
                            }

                            if ((v1 == null) || (v2 == null)) {
                                throw new Exception("Um ou mais vertices não foram encontrado! (Aresta)");
                            } else {
                                Aresta a = new Aresta("nome?", v1, v2, Double.parseDouble(separadorAresta2[2]));
                                listaGravaveis.add(a);
                            }

                            break;

                        case "i":

                            String[] separadorIndividuo = str.split(":");
                            String[] separadorIndividuo2 = separadorIndividuo[1].split(",");
                            Vertice vIndividuo = null;

                            for (Vertice verticeI : verticesTemp) {
                                if (verticeI.getNome().equals(separadorIndividuo2[1])) {
                                    vIndividuo = verticeI;
                                }
                            }

                            if (vIndividuo == null) {
                                throw new Exception("Um ou mais vertices não foram encontrado! (Individuo)");
                            } else {
                                Individuo i = new Individuo(separadorIndividuo2[0], vIndividuo);
                                listaGravaveis.add(i);
                            }

                            break;
                    }

                }

            }

            reader.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ex.getMessage());
//            Logger.getLogger(OperadorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ex.getMessage());
//            Logger.getLogger(OperadorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        verticesTemp = null;
        return listaGravaveis;
    }
}
