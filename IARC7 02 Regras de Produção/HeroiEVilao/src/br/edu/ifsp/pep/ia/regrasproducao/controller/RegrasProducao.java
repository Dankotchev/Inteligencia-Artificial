package br.edu.ifsp.pep.ia.regrasproducao.controller;

import br.edu.ifsp.pep.ia.regrasproducao.model.Bonus;
import br.edu.ifsp.pep.ia.regrasproducao.model.Heroi;
import br.edu.ifsp.pep.ia.regrasproducao.model.Vilao;

public class RegrasProducao {

    private Heroi heroi;
    private Vilao vilao;
    private Bonus bonus;

    /**
     * Valores menores de retorno são de menores prioridades
     *
     * @return regra de produção a ser executada
     */
    public int obterProximaJogada() {
        int retorno = 999;

        if (this.heroi.getEixoX() < this.vilao.getEixoX())
            retorno = 1;

        if (this.heroi.getEixoX() > this.vilao.getEixoX())
            retorno = 2;

        if (this.heroi.getEixoY() < this.vilao.getEixoY())
            retorno = 3;

        if (this.heroi.getEixoY() > this.vilao.getEixoY())
            retorno = 4;

        if (this.heroi.comparePosicao(this.vilao))
            retorno = 5;

        if (this.heroi.isBonus2x() && this.heroi.comparePosicao(this.vilao))
            retorno = 6;

        if (this.heroi.comparePosicao(this.bonus) && !this.bonus.isUtilizado())
            retorno = 7;

        return retorno;
    }

    public RegrasProducao(Heroi heroi, Vilao vilao, Bonus bonus) {
        this.heroi = heroi;
        this.vilao = vilao;
        this.bonus = bonus;
    }

}
