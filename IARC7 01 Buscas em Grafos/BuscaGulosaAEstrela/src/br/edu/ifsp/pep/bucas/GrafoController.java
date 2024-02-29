package br.edu.ifsp.pep.bucas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GrafoController {

    private Map<String, Node> nodes;
    private Map<Node, Integer> distanciaParaBucarest = new HashMap<>();
    private Grafo grafo;

    public GrafoController(Grafo Grafo) {
        this.grafo = grafo;
        this.nodes = new HashMap<>();
    }

    public Grafo lerNos(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {

            String linha;
            while ((linha = br.readLine()) != null) {

                if (linha.equals("-1"))
                    break;

                String[] partes = linha.split(" ");

                // Primeira cidade e distância até Bucarest
                String valorRaiz = partes[0];
                Integer distanciaBucarest = Integer.valueOf(partes[1]);
                Node noRaiz = obterOuCriarNode(valorRaiz);
                distanciaParaBucarest.put(noRaiz, distanciaBucarest);
                

                for (int i = 2; i < partes.length; i++) {
                    // Coletando cidades adjacentes e distâncias entre elas e a primeira cidade da lista
                    String cidadeAdjacente = partes[i];
                    Integer distanciaAdjacente = Integer.valueOf(partes[++i]);
                   
                    // Criando ou obtendo o nó da cidade adjacente e inserindo no grafo
                    Node NodeAdjacente = obterOuCriarNode(cidadeAdjacente);
                    grafo.adcionarNo(noRaiz, NodeAdjacente, distanciaAdjacente);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grafo;
    }

    private Node obterOuCriarNode(String valor) {
        if (nodes.containsKey(valor))
            return nodes.get(valor);
        else {
            Node novoNode = new Node(valor);
            nodes.put(valor, novoNode);
            if (grafo == null)
                grafo = new Grafo(novoNode);
            return novoNode;
        }
    }

    public void mostrarNos() {
        for (Map.Entry<String, Node> entry : nodes.entrySet()) {
            Node node = entry.getValue();
            System.out.print(node + ":");
            for (Node adjacente : node.getAdjacentes()) {
                System.out.print(adjacente);
            }
            System.out.println();
        }
    }
    
    public Node retornarNode(String valor){
        
        return obterOuCriarNode(valor);
    }

    public Map<Node, Integer> getDistanciaParaBucarest() {
        return distanciaParaBucarest;
    }
    
    
}
