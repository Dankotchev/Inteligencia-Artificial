package br.edu.ifsp.pep.bucas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Grafo {

    private Node cidadeInicial;
    private Map<Node, Boolean> visitado; // Marcação dos Nós visitados durante a busca
    private ArrayList<Node> caminhoPercorrido; // O caminho completo da busca da Raiz até o procurado
    private Node cidadeDestino;

    public Grafo(Node raiz) {
        this.cidadeInicial = raiz;
    }

    public Grafo() {
    }

    public void adcionarNo(Node inserir, Node adjacente, Integer distancia) {
        inserir.adcionarAdjacente(adjacente, distancia);
        adjacente.adcionarAdjacente(inserir, distancia);
    }

    public void buscaGulosa(Map<Node, Integer> distanciaBucarest) {
        this.caminhoPercorrido = new ArrayList<>();
        this.visitado = new HashMap<>();
        Node noAtual = this.cidadeInicial;
        visitado.put(cidadeInicial, true);
        this.caminhoPercorrido.add(noAtual);

        while (!noAtual.equals(cidadeDestino)) {
            // Vizinho com a menor distância para Bucarest
            ArrayList<Node> adjacentes = noAtual.getAdjacentes();
            Node vizinhoMaisProximo = null;
            int distancia = Integer.MAX_VALUE;
            for (Node adjacente : adjacentes) {

                if (distanciaBucarest.get(adjacente) <= distancia
                        && !visitado.containsKey(adjacente)) {
                    distancia = distanciaBucarest.get(adjacente);
                    vizinhoMaisProximo = adjacente;
                }
                visitado.put(adjacente, true);
            }
            noAtual = vizinhoMaisProximo;
            this.caminhoPercorrido.add(noAtual);
        }

    }

    public void buscaAEstrela(Map<Node, Integer> distanciaBucarest) {
        this.caminhoPercorrido = new ArrayList<>();
        this.visitado = new HashMap<>();
        Node noAtual = this.cidadeInicial;
        visitado.put(cidadeInicial, true);
        this.caminhoPercorrido.add(noAtual);

        while (!noAtual.equals(this.cidadeDestino)) {
            // Vizinho com a menor distância para Bucarest
            ArrayList<Node> adjacentes = noAtual.getAdjacentes();
            Node vizinhoMaisProximo = null;
            int distancia = Integer.MAX_VALUE;

            for (int i = 0; i < adjacentes.size(); i++) {
                // Obtendo a distância entre o nó atual e o adjacente
                //somando com distância em linha reta até cidade de destino
                Node adjacente = noAtual.getAdjacentes().get(i);
                Integer distanciaAdjacente = noAtual.getDistancias().get(i);
                int distanciaTotal = distanciaBucarest.get(adjacente) + distanciaAdjacente;

                if ((distanciaTotal <= distancia)
                        && (!visitado.containsKey(adjacente))) {
                    distancia = distanciaTotal;
                    vizinhoMaisProximo = adjacente;
                }
                visitado.put(adjacente, true);

                // Se o nó tiver um unico vizinho, chega em um caminho sem saída
                //então remove dos visitados seu único vizinho.
                if (adjacentes.size() != 1) 
                    visitado.remove(adjacente);
            }
            noAtual = vizinhoMaisProximo;
            this.caminhoPercorrido.add(noAtual);
        }
    }

    public void apresentarPercurso() {
        if (!this.caminhoPercorrido.isEmpty()) {
            System.out.println("\nCaminho da busca:");
            for (Iterator<Node> iterator = caminhoPercorrido.iterator(); iterator.hasNext();) {
                Node next = iterator.next();
                System.out.print(next);
                if (iterator.hasNext()) 
                    System.out.print("==>");
            }
            System.out.println("");
        }
    }

    public void setCidadeInicial(Node cidadeInicial) {
        this.cidadeInicial = cidadeInicial;
    }

    public void setCidadeDestino(Node cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

}
