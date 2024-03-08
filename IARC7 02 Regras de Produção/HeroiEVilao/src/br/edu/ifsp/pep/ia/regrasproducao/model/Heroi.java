package br.edu.ifsp.pep.ia.regrasproducao.model;

public class Heroi extends Personagen {

    private boolean bonus2x;

    public void moverBaixo() {
        super.setEixoX(super.getEixoX() + 1);
    }

    public void moverCima() {
        super.setEixoX(super.getEixoX() - 1);
    }

    public void moverDireita() {
        super.setEixoY(super.getEixoY() + 1);
    }

    public void moverEsquerda() {
        super.setEixoY(super.getEixoY() - 1);
    }

    public Heroi(int tamanhoTabulieroX, int tamanhoTabulieroY) {
        super(tamanhoTabulieroX, tamanhoTabulieroY);
        this.bonus2x = false;
    }

    public boolean isBonus2x() {
        return bonus2x;
    }

    public void setBonus2x(boolean bonus2x) {
        this.bonus2x = bonus2x;
    }

}
