package utilitarios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aresta;
import model.Desenhavel;

import model.Individuo;
import model.Vertice;

public class OperadorArquivos {

    private String nomeArquivo;

    public OperadorArquivos(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public boolean escrever(List<Desenhavel> listaDesenhaveis, String nomeArquivo) {

        /* 
        * v:A,1,1;
        * a:A,B,5, nomeA;
        * i:A, nomeA;
         */
        try {
            FileWriter writer = new FileWriter(nomeArquivo, true);
            for (Desenhavel d : listaDesenhaveis) {
                writer.write(d.getStringParaDocumento());
            }
            writer.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(OperadorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public List<Desenhavel> ler() throws Exception {

        List<Desenhavel> listaGravaveis = new ArrayList<>();
        List<Vertice> verticesTemp = new ArrayList<>(); //lista temporária

        try {
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
            String str = "";

            while ((str = reader.readLine()) != null) {

                //primeira condição - verifica se a primeira letra da linha é 'v' ou 'a' ou 'i'
                if (!str.isEmpty() && (String.valueOf(str.charAt(0)).equals("v") || String.valueOf(str.charAt(0)).equals("a") || String.valueOf(str.charAt(0)).equals("i"))) {

                    //Na linha abaixo, somente Deus e eu sabíamos o que ela fazia. Agora só Deus sabe...
                    str = str.substring(0, str.split(";")[0].length());

                    switch (String.valueOf(str.charAt(0))) {

                        case "v":

                            String[] separadorVertice1 = str.split(":");
                            String[] separadorVertice2 = separadorVertice1[1].split(",");

                            for (int i = 0; i < separadorVertice2.length; i++) {
                                separadorVertice2[i] = separadorVertice2[i].trim();
                            }

                            if((Double.parseDouble(separadorVertice2[1]) < 0) || (Double.parseDouble(separadorVertice2[2]) < 0)){
                                throw new Exception("Vertices não podem estar em valores X ou Y negativos!");
                            }
                            
                            Vertice v = new Vertice(separadorVertice2[0], Double.parseDouble(separadorVertice2[1]), Double.parseDouble(separadorVertice2[2]));

                            listaGravaveis.add(v);
                            verticesTemp.add(v);

                            break;

                        case "a":

                            String[] separadorAresta1 = str.split(":");
                            String[] separadorAresta2 = separadorAresta1[1].split(",");

                            for (int i = 0; i < separadorAresta2.length; i++) {
                                separadorAresta2[i] = separadorAresta2[i].trim();
                            }

                            //aresta(vertice01, vetice02, comprimento, nome)
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
                                //verificação de valores negativos
                                if (Double.parseDouble(separadorAresta2[2]) < 0) {
                                    throw new Exception("Valores negativos de comprimento não são permitidos!");
                                } else {
                                    boolean bidirecional = false;
                                    if (separadorAresta2[3].equalsIgnoreCase("true")) {
                                        bidirecional = true;
                                    }
                                    Aresta a = new Aresta(v1, v2, Double.parseDouble(separadorAresta2[2]), bidirecional, separadorAresta2[4]);
                                    listaGravaveis.add(a);
                                }
                            }

                            break;

                        case "i":

                            String[] separadorIndividuo = str.split(":");
                            String[] separadorIndividuo2 = separadorIndividuo[1].split(",");

                            for (int i = 0; i < separadorIndividuo2.length; i++) {
                                separadorIndividuo2[i] = separadorIndividuo2[i].trim();
                            }

                            Vertice vIndividuo = null;

                            for (Vertice verticeI : verticesTemp) {
                                if (verticeI.getNome().equals(separadorIndividuo2[0])) {
                                    vIndividuo = verticeI;
                                }
                            }

                            if (vIndividuo == null) {
                                throw new Exception("Um ou mais vertices não foram encontrado! (Individuo)");
                            } else {
                                Individuo i = new Individuo(vIndividuo, separadorIndividuo2[1]);
                                listaGravaveis.add(i);
                            }

                            break;
                    }

                }

            }

            reader.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(ex.getMessage());
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Alguns problemas foram detectados na leitura dos dados do arquivo!");
        }

        verticesTemp = null;
        return listaGravaveis;
    }
}
