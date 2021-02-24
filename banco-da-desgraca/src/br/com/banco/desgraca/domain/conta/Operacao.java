package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.Transacao;

public class Operacao {
     private ContaBancaria contaBancaria;
     private Transacao transacao;

    public Operacao(ContaBancaria contaBancaria, Transacao transacao) {
        this.contaBancaria = contaBancaria;
        this.transacao = transacao;
    }
}
