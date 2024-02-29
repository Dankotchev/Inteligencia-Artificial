package br.edu.ifsp.pep.bucas;

import java.util.Scanner;

public class Util {

    public String lerCidade() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe uma Cidade Inicial");
        String cidade = entrada.nextLine();
        return cidade;
    }

    public int opcaoBusca() {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;
        while (opcao < 0 || opcao > 2) {
            System.out.println("""
                               
                               Selecione o algoritimo de busca desejado.
                               1 - Busca Gulosa.
                               2 - Busca A*.
                               0 - Encerrar""");
            opcao = entrada.nextInt();
        }
        return opcao;
    }
}
