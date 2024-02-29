package br.edu.ifsp.pep.buscas;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Deque;
import java.util.Map;

public class Grafo {

    private Node raiz;
    private Map<Node, Boolean> visitado; // Marcação dos Nós visitados durante a busca
    private Map<Node, Node> caminhoCurtoMap;// Marcação dos Nós "perfeitos" da busca
    private ArrayList<Node> caminhoPercorrido;// Marcação dos Nós "perfeitos" da busca
    private ArrayList<Node> caminhoPercorridoTotal; // O caminho completo da busca da Raiz até o procurado

    public Grafo(Node raiz) {
        this.raiz = raiz;
    }

    public Grafo() {
    }

    public void adcionarNo(Node inserir, Node adjacente) {
        inserir.adcionarAdjacente(adjacente);
        adjacente.adcionarAdjacente(inserir);
    }

    public void buscaLargura(String valor) {
        this.visitado = new HashMap<>();
        this.caminhoCurtoMap = new HashMap<>();
        this.caminhoPercorridoTotal = new ArrayList<>();
        Deque<Node> fila = new ArrayDeque<>();

        fila.offer(this.raiz);
        visitado.put(this.raiz, true);
        caminhoCurtoMap.put(this.raiz, null);

        while (!fila.isEmpty()) {
            Node atual = fila.poll();
            caminhoPercorridoTotal.add(atual);

            if (atual.match(valor)) {
                reconstruirCaminhoCurto(caminhoCurtoMap, atual);
                return;
            }

            for (Node adjacente : atual.getAdjacentes()) {
                if (!visitado.containsKey(adjacente)) {
                    fila.offer(adjacente);
                    visitado.put(adjacente, true);
                    caminhoCurtoMap.put(adjacente, atual);
                }
            }
        }
    }

    public void buscaProfundidade(String valor) {
        this.visitado = new HashMap<>();
        this.caminhoCurtoMap = new HashMap<>();
        Deque<Node> pilha = new ArrayDeque<>();
        this.caminhoPercorridoTotal = new ArrayList<>();

        pilha.push(this.raiz);
        visitado.put(this.raiz, true);

        while (!pilha.isEmpty()) {
            Node atual = pilha.pop();
            caminhoPercorridoTotal.add(atual);

            if (atual.match(valor)) {
                this.reconstruirCaminhoCurto(caminhoCurtoMap, atual);
                return;
            }

            for (Node adjacente : atual.getAdjacentes()) {
                if (!visitado.containsKey(adjacente)) {
                    pilha.push(adjacente);
                    visitado.put(adjacente, true);
                    caminhoCurtoMap.put(adjacente, atual);
                }
            }
        }
    }

    private void reconstruirCaminhoCurto(Map<Node, Node> caminho, Node destino) {
        this.caminhoPercorrido = new ArrayList<>();
        ArrayList<Node> caminhoInvertido = new ArrayList<>();
        Node atual = destino;

        while (atual != null) {
            caminhoInvertido.add(atual);
            atual = caminho.get(atual);
        }

        // Inverte a ordem do caminho para começar do nó inicial
        for (int i = caminhoInvertido.size() - 1; i >= 0; i--) {
            caminhoPercorrido.add(caminhoInvertido.get(i));
        }

    }

    public void apresentarPercursoDireto() {
        if (!this.caminhoPercorrido.isEmpty()) {
            System.out.println("Caminho Direto da busca.");
            for (Node node : caminhoPercorrido) {
                System.out.print(node + "==>");
            }
            System.out.println("");
        }
    }

    public void apresentarPercursoTotal() {
        if (!this.caminhoPercorridoTotal.isEmpty()) {
            System.out.println("Caminho Percorrido da Busca");
            for (Node node : caminhoPercorridoTotal) {
                System.out.print(node + "==>");
            }
            System.out.println("");
        }
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

}
