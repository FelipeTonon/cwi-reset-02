package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.ContaDigitalException;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContaDigital implements ContaBancaria{

    private Integer numeroContaCorrente;
    private InstituicaoBancaria instituicaoBancaria;
    private Double saldo;

    public ContaDigital(Integer numeroContaCorrente, InstituicaoBancaria instituicaoBancaria) {
        this.numeroContaCorrente = numeroContaCorrente;
        instituicoesBancariasPermitidas(instituicaoBancaria);
        this.saldo = 0.0;
    }

    List<Transacao> transacoesConta = new ArrayList<>();

    private void instituicoesBancariasPermitidas(InstituicaoBancaria instituicaoBancaria){
        if(InstituicaoBancaria.ITAU.equals(instituicaoBancaria) || instituicaoBancaria.NUBANK.equals(instituicaoBancaria)){
            this.instituicaoBancaria = instituicaoBancaria;
        } else {
            throw new ContaDigitalException("Não é possível abrir uma Conta Digital no banco solicitado.");
        }
    }

    @Override
    public String toString() {
        return "Conta Digital " + instituicaoBancaria + " " + numeroContaCorrente;
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

        Transacao a = new Transacao(TipoTransacao.DEPOSITAR, valor);
        transacoesConta.add(a);
    }

    @Override
    public void sacar(Double valor) {

       if(valor > this.saldo){
           throw new SaldoInsuficienteException("Você não possui saldo suficiente para realizar essa transação.");
       } else {
           if (valor >= 10) {
               this.saldo -= valor;

               System.out.println("Sacando valor de " + DecimalFormat.getCurrencyInstance().format(valor) + " da " + toString());

               Transacao a = new Transacao(TipoTransacao.SACAR, valor);
               transacoesConta.add(a);
           } else {
               throw new ContaDigitalException("Saque permitido apenas acima de R$ 9.99 em Conta Digital.");
           }
       }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        if(valor > this.saldo){
            throw new SaldoInsuficienteException("Você não possui saldo suficiente para realizar essa transação.");
        } else {
            this.saldo -= valor;

            System.out.println("Transferindo valor de " + DecimalFormat.getCurrencyInstance().format(valor) + " da "
                    + toString() + " para " + contaDestino.toString());

            Transacao a = new Transacao(TipoTransacao.TRANSFERIR, valor);
            transacoesConta.add(a);

            contaDestino.depositar(valor);
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
