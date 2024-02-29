package br.edu.ifsp.pep.bucas;

import java.util.Map;

public class Principal {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java -jar arquivo.jar arquivo.txt");
            System.exit(1);
        }

        // Abertura de arquivo e criação do Grafo
        String nomeArquivo = args[0];
        Grafo grafo = new Grafo();

        // Controller responsável por ler todos os nós e suas adjacências
        GrafoController controller = new GrafoController(grafo);
        grafo = controller.lerNos(nomeArquivo);

        System.out.println("Lista de Nós e seus adjacentes:");
        //controller.mostrarNos();

        // Definindo cidade inicial e de destino
        grafo.setCidadeDestino(controller.retornarNode("Bucarest"));
        grafo.setCidadeInicial(controller.retornarNode("Arad"));
        
        // Obtendo a "lista" de distâncias até Bucarest
        Map<Node, Integer> distanciaParaBucarest = controller.getDistanciaParaBucarest();
        
        
        grafo.buscaGulosa(distanciaParaBucarest);
        grafo.apresentarPercurso();
        
        grafo.buscaAEstrela(distanciaParaBucarest);
        grafo.apresentarPercurso();


    }
}
