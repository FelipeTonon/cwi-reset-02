package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.ContaDigitalException;
import br.com.banco.desgraca.exception.ContaPoupancaException;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class ContaPoupanca implements ContaBancaria{

    private Integer numeroContaCorrente;
    private InstituicaoBancaria instituicaoBancaria;
    private Double saldo;

    public ContaPoupanca(Integer numeroContaCorrente, InstituicaoBancaria instituicaoBancaria) {
        this.numeroContaCorrente = numeroContaCorrente;
        instituicoesBancariasPermitidas(instituicaoBancaria);
        this.saldo = 0.0;
    }

    private void instituicoesBancariasPermitidas(InstituicaoBancaria instituicaoBancaria){
        if(InstituicaoBancaria.NUBANK.equals(instituicaoBancaria)){
            throw new ContaPoupancaException("Não é possível criar uma Conta Poupança no banco solicitado.");
        } else {
            this.instituicaoBancaria = instituicaoBancaria;
        }
    }

    @Override
    public String toString() {
        return "Conta Poupanca " + instituicaoBancaria + " " + numeroContaCorrente;
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
    }

    @Override
    public void sacar(Double valor) {
        if( (valor * 1.02) > this.saldo ){
            throw new SaldoInsuficienteException("Você não possui saldo suficiente para realizar essa transação.");
        } else {
            if (valor < 50.0) {
                throw new ContaPoupancaException("Não é possível realizar saque com valor de R$ 50,00.");
            } else {
                this.saldo = (this.saldo - valor) - (valor * 0.02);
                System.out.println("Sacando valor de " + DecimalFormat.getCurrencyInstance().format(valor) + " da " + toString());
            }
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        if(contaDestino.getInstituicaoBancaria().equals(this.instituicaoBancaria)) {
            if ((valor * 1.005)<= this.saldo) {
                this.saldo = (this.saldo - valor) - (valor * 0.005);
                System.out.println("Transferindo valor de " + DecimalFormat.getCurrencyInstance().format(valor) +
                        " da " + toString() + " para " + contaDestino.toString());
                contaDestino.depositar(valor);
            } else {
                throw new SaldoInsuficienteException("Você não possui saldo suficiente para realizar essa transação.");
            }
        } else {
            if ((valor * 1.01) <= this.saldo) {
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
