package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.Data;

import java.time.LocalDate;

public class Transacao {

    private TipoTransacao tipoTransacao;
    private LocalDate dataTransacao;
    private Double valorTransacao;

    public Transacao(TipoTransacao tipoTransacao, Double valorTransacao) {
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = Data.getDataTransacao();
        this.valorTransacao = valorTransacao;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public Double getValorTransacao() {
        return valorTransacao;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

}