
package br.edu.ifsp.pep.ia.regrasproducao.model;

import java.util.Random;

public class Personagen {
private int eixoX;
    private int eixoY;
    Random random = new Random();
    
    public int getEixoX() {
        return eixoX;
    }

    public int getEixoY() {
        return eixoY;
    }

    public void setEixoX(int eixoX) {
        this.eixoX = eixoX;
    }

    public void setEixoY(int eixoY) {
        this.eixoY = eixoY;
    }
    

    public Personagen(int tamanhoTabulieroX, int tamanhoTabulieroY) {
        this.eixoX = random.nextInt(tamanhoTabulieroX);
        this.eixoY = random.nextInt(tamanhoTabulieroY);
    }
    
    public boolean comparePosicao(Object obj){
        final Personagen other = (Personagen) obj;
        if (this.eixoX != other.eixoX)
            return false;
        return this.eixoY == other.eixoY;
    }

}
