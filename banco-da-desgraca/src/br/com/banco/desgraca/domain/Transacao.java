package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.Data;

public class Transacao {

    private TipoTransacao tipoTransacao;
    private Data dataTransacao;
    private Double valorTransacao;

    public Transacao(TipoTransacao tipoTransacao, Data dataTransacao, Double valorTransacao) {
        this.tipoTransacao = tipoTransacao;
        getDataTransacao(dataTransacao);
        this.valorTransacao = valorTransacao;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public Data getDataTransacao(Data dataTransacao) {
        return this.dataTransacao;
    }

    public Double getValorTransacao() {
        return valorTransacao;
    }
}