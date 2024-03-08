package br.edu.ifsp.pep.ia.regrasproducao.model;

import java.util.Random;

public class Vilao extends Personagen {

    private int vidasRestantes;
    private int tamTambuleiroX;
    private int tamTambuleiroY;
    Random random = new Random();

    public Vilao(int tamanhoTabulieroX, int tamanhoTabulieroY, int vidasTotais) {
        super(tamanhoTabulieroX, tamanhoTabulieroY);
        this.vidasRestantes = vidasTotais;
        this.tamTambuleiroX = tamanhoTabulieroX;
        this.tamTambuleiroY = tamanhoTabulieroY;
    }

    public void receberDano(boolean danoAmpliado) {
        if (danoAmpliado)
            this.vidasRestantes = this.vidasRestantes - 2;
        else
            this.vidasRestantes--;

        this.reposicionarVilao();
    }

    private void reposicionarVilao() {
        super.setEixoX(random.nextInt(this.tamTambuleiroX));
        super.setEixoY(random.nextInt(this.tamTambuleiroY));
    }

    public int getVidasRestantes() {
        return vidasRestantes;
    }
}
