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

        // Apresentação de Adjacências
        //System.out.println("Lista de Nós e seus adjacentes:");
        //controller.mostrarNos();
        
        // Definindo de destino
        Util util = new Util();
        grafo.setCidadeDestino(controller.retornarNode("Bucarest"));

        // Obtendo a "lista" de distâncias até Bucarest
        Map<Node, Integer> distanciaParaBucarest = controller.getDistanciaParaBucarest();

        int opcao = util.opcaoBusca();
        while (opcao == 1 || opcao == 2) {
            grafo.setCidadeInicial(controller.retornarNode(util.lerCidade()));
            switch (opcao) {
                case 1:
                    grafo.buscaGulosa(distanciaParaBucarest);
                    grafo.apresentarPercurso();
                    break;

                case 2:
                    grafo.buscaAEstrela(distanciaParaBucarest);
                    grafo.apresentarPercurso();
                    break;

                case 0:
                    System.out.println("Encerrando.");
            }
            opcao = util.opcaoBusca();
        }
    }
}
