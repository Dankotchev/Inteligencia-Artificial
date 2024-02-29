package br.edu.ifsp.pep.bucas;

import java.util.Scanner;

public class Util {

    public String lerCidade() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe uma Cidade Inicial");
        return entrada.nextLine();
    }

    public int opcaoBusca() {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;
        
        while (opcao < 0 || opcao > 2) {
            System.out.println("\nSelecione o algoritimo de busca desejado."
                    + "\n1 - Busca Gulosa."
                    + "\n2 - Busca A*."
                    + "\n0 - Encerrar");
            opcao = entrada.nextInt();
        }
        return opcao;
    }
}
