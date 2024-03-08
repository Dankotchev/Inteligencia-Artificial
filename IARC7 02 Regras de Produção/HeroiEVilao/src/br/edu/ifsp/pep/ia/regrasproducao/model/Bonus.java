package br.edu.ifsp.pep.ia.regrasproducao.model;

public class Bonus extends Personagen {

    private boolean utilizado;

    public Bonus(int tamanhoTabulieroX, int tamanhoTabulieroY) {
        super(tamanhoTabulieroX, tamanhoTabulieroY);
        this.utilizado = false;
    }

    public boolean isUtilizado() {
        return utilizado;
    }

    public void setUtilizado() {
        this.utilizado = true;
    }
}
