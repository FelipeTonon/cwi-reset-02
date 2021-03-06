package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.InstituicaoBancariaInvalidaException;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.exception.ValorSaqueInvalidoException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContaPoupanca implements ContaBancaria{

    private Integer numeroContaCorrente;
    private InstituicaoBancaria instituicaoBancaria;
    private Double saldo;
    private Double taxa;

    public ContaPoupanca(Integer numeroContaCorrente, InstituicaoBancaria instituicaoBancaria) {
        this.numeroContaCorrente = numeroContaCorrente;
        instituicoesBancariasPermitidas(instituicaoBancaria);
        this.saldo = 0.0;
        this.taxa = 0.0;
    }

    List<Transacao> transacoesConta = new ArrayList<>();

    private void instituicoesBancariasPermitidas(InstituicaoBancaria instituicaoBancaria){
        if(InstituicaoBancaria.NUBANK.equals(instituicaoBancaria)){
            throw new InstituicaoBancariaInvalidaException("Não é possível criar uma Conta Poupança no banco solicitado.");
        } else {
            this.instituicaoBancaria = instituicaoBancaria;
        }
    }

    @Override
    public String toString() {
        return "Conta Poupança " + this.instituicaoBancaria + " " + this.numeroContaCorrente;
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return this.instituicaoBancaria;
    }

    @Override
    public double consultarSaldo() {
        System.out.println("O saldo da " + toString() + " é de " + DecimalFormat.getCurrencyInstance().format(this.saldo) + ".");
        return 0;
    }

    @Override
    public void depositar(Double valor) {
        this.saldo += valor;

        System.out.println("Depositando valor de " + DecimalFormat.getCurrencyInstance().format(valor) + " na " + toString());

        Transacao a = new Transacao(TipoTransacao.DEPOSITAR, valor);
        transacoesConta.add(a);
    }

    @Override
    public void sacar(Double valor) {
        if( (valor * 1.02) > this.saldo ) {
            throw new SaldoInsuficienteException("Você não possui saldo suficiente para realizar essa transação.");
        } else {
            if (valor < 50.0) {
                throw new ValorSaqueInvalidoException("Não é possível realizar saque com valor menor que R$ 50,00.");
            } else {
                this.taxa = valor * 0.02;
                this.saldo = (this.saldo - valor) - this.taxa;

                System.out.println("Sacando valor de " + DecimalFormat.getCurrencyInstance().format(valor) + " da " + toString() +
                        " com Taxa de transação no valor de " + DecimalFormat.getCurrencyInstance().format(this.taxa));

                Transacao a = new Transacao(TipoTransacao.SACAR, valor);
                transacoesConta.add(a);
            }
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        if(contaDestino.getInstituicaoBancaria().equals(this.instituicaoBancaria)) {
            if ((valor * 1.005)<= this.saldo) {
                this.taxa = valor * 0.005;
                this.saldo = (this.saldo - valor) - this.taxa;

                System.out.println("Transferindo valor de " + DecimalFormat.getCurrencyInstance().format(valor) +
                        " da " + toString() + " para " + contaDestino.toString() + " com Taxa de transação no valor de "
                + DecimalFormat.getCurrencyInstance().format(this.taxa));

                Transacao a = new Transacao(TipoTransacao.TRANSFERIR, valor);
                transacoesConta.add(a);

                contaDestino.depositar(valor);

            } else {
                throw new SaldoInsuficienteException("Você não possui saldo suficiente para realizar essa transação.");
            }
        } else {
            if ((valor * 1.01) <= this.saldo) {
                this.taxa = valor * 0.01;
                this.saldo = (this.saldo - valor) - this.taxa;

                System.out.println("Transferindo valor de " + DecimalFormat.getCurrencyInstance().format(valor) +
                        " da " + toString() + " para " + contaDestino.toString() + " com Taxa de transação no valor de "
                        + DecimalFormat.getCurrencyInstance().format(this.taxa));

                Transacao a = new Transacao(TipoTransacao.TRANSFERIR, valor);
                transacoesConta.add(a);

                contaDestino.depositar(valor);
            } else {
                throw new SaldoInsuficienteException("Você não possui saldo suficiente para realizar essa transação.");
            }
        }
    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {

        System.out.println("----- Extrato " + toString());

        for (Transacao transacoesConta : transacoesConta) {

            if (inicio != null && transacoesConta.getDataTransacao().isAfter(inicio)) {
                if (transacoesConta.getTipoTransacao() == TipoTransacao.DEPOSITAR) {
                    System.out.println("   + " + DecimalFormat.getCurrencyInstance().format(transacoesConta.getValorTransacao())
                            + "   " + transacoesConta.getDataTransacao());
                } else {
                    System.out.println("   - " + DecimalFormat.getCurrencyInstance().format(transacoesConta.getValorTransacao())
                            + "   " + transacoesConta.getDataTransacao());
                }

            } else if (fim != null && transacoesConta.getDataTransacao().isBefore(fim)) {
                if (transacoesConta.getTipoTransacao() == TipoTransacao.DEPOSITAR) {
                    System.out.println("   + " + DecimalFormat.getCurrencyInstance().format(transacoesConta.getValorTransacao())
                            + "   " + transacoesConta.getDataTransacao());
                } else {
                    System.out.println("   - " + DecimalFormat.getCurrencyInstance().format(transacoesConta.getValorTransacao())
                            + "   " + transacoesConta.getDataTransacao());
                }

            } else if (inicio == null && fim == null) {
                if (transacoesConta.getTipoTransacao() == TipoTransacao.DEPOSITAR) {
                    System.out.println("   + " + DecimalFormat.getCurrencyInstance().format(transacoesConta.getValorTransacao())
                            + "   " + transacoesConta.getDataTransacao());
                } else {
                    System.out.println("   - " + DecimalFormat.getCurrencyInstance().format(transacoesConta.getValorTransacao())
                            + "   " + transacoesConta.getDataTransacao());
                }
            }
        }
    }
}
