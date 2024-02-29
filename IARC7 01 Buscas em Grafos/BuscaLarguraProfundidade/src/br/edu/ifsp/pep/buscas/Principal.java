package br.edu.ifsp.pep.buscas;

public class Principal {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Main arquivo.txt");
            System.exit(1);
        }

        // Abertura de arquivo e criação do Grafo
        String nomeArquivo = args[0];
        Grafo grafo = new Grafo();

        // Controller responsável por ler todos os nós e suas adjacências
        GrafoController controller = new GrafoController(grafo);
        grafo = controller.lerNos(nomeArquivo);

        System.out.println("Lista de Nós e seus adjacentes:");
        controller.mostrarNos();

        // Busca por Largura, a partir da raiz (I)
        System.out.println("\nBusca em Largura, Raiz: I - Destino B");
        grafo.buscaLargura("B");
        grafo.apresentarPercursoDireto();
        grafo.apresentarPercursoTotal();

        System.out.println("\nMudança da raiz do grafo para H");
        Node novaRaiz = controller.retornarNode("H");
        grafo.setRaiz(novaRaiz);

        // Busca em profundidade
        System.out.println("Busca em Largura, Raiz: H - Destino R");
        grafo.buscaProfundidade("H");
        grafo.apresentarPercursoDireto();
        grafo.apresentarPercursoTotal();
    }
}
