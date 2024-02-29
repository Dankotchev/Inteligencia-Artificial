package br.edu.ifsp.pep.buscas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GrafoController {

    private Map<String, Node> nodes;
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

                String valorRaiz = partes[0];
                Node noRaiz = obterOuCriarNode(valorRaiz);

                for (int i = 1; i < partes.length; i++) {
                    String valorAdjacente = partes[i];
                    Node adjacente = obterOuCriarNode(valorAdjacente);
                    grafo.adcionarNo(noRaiz, adjacente);
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
}
