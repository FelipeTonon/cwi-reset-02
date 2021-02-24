package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.ContaCorrenteException;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class ContaCorrente implements ContaBancaria{

    private Integer numeroContaCorrente;
    private InstituicaoBancaria instituicaoBancaria;
    private Double saldo;
    private Transacao transacao;

    public ContaCorrente(Integer numeroContaCorrente, InstituicaoBancaria instituicaoBancaria) {
        this.numeroContaCorrente = numeroContaCorrente;
        this.instituicaoBancaria = instituicaoBancaria;
        this.saldo = 0.0;
    }

    @Override
    public String toString() {
        return "Conta Corrente " + instituicaoBancaria + " " + numeroContaCorrente;
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return this.instituicaoBancaria;
    }

    @Override
    public void consultarSaldo() {
        System.out.println("O saldo da " + toString() + " é de " + DecimalFormat.getCurrencyInstance().format(this.saldo) + ".");
    }

    @Override
    public void depositar(Double valor) {
        this.saldo += valor;
        System.out.println("Depositando valor de " + DecimalFormat.getCurrencyInstance().format(valor) + " na " + toString());
        Transacao
    }

    @Override
    public void sacar(Double valor) {
        if(valor > this.saldo){
            throw new SaldoInsuficienteException("Você não possui saldo suficiente para realizar essa transação.");
        } else {
            if ((valor % 5) == 0) {
                saldo -= valor;
                System.out.println("Sacando valor de " + DecimalFormat.getCurrencyInstance().format(valor) + " da " + toString());
            } else {
                throw new ContaCorrenteException("Não há notas disponíveis para saque no valor solicitado. " +
                        "Favor entrar com um valor multiplo de R$ 5,00.");
            }
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {

        if(contaDestino.getInstituicaoBancaria().equals(instituicaoBancaria)) {
            if(valor <= this.saldo){
                this.saldo -= valor;
                System.out.println("Transferindo valor de " + DecimalFormat.getCurrencyInstance().format(valor) + " da " + toString() + " para " + contaDestino.toString());
                contaDestino.depositar(valor);
            } else {
                throw new SaldoInsuficienteException("Você não possui saldo suficiente para realizar essa transação.");
            }
        } else {
            if((valor * 1.01) <= this.saldo){
                this.saldo = (this.saldo - valor) - (valor * 0.01);
                System.out.println("Transferindo valor de " + DecimalFormat.getCurrencyInstance().format(valor) +
                        " da " + toString() + " para " + contaDestino.toString());
                contaDestino.depositar(valor);
            } else {
                throw new SaldoInsuficienteException("Você não possui saldo suficiente para realizar essa transação.");
            }
        }

    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {


    }
}