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
import model.Vertice;

public class OperadorArquivos {

    private String nomeArquivo;

    public OperadorArquivos(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public boolean escrever(List<Gravavel> listaGravaveis) {

        return false;
    }

    public List<Gravavel> ler() {

        List<Gravavel> listaGravaveis = new ArrayList<>();

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
                            
                            break;
                            
                        case "a":
                            
                            String[] separadorAresta1 = str.split(":");
                            String[] separadorAresta2 = separadorAresta1[1].split(",");

//                            Aresta a = new Aresta(separadorAresta2[0], separadorAresta2[1]);
                            
//                            listaGravaveis.add(a);
                            
                            break;
                    }

                }

            }

            reader.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperadorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OperadorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaGravaveis;
    }
}
