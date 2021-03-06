//package br.com.banco.desgraca;
//
//import br.com.banco.desgraca.domain.InstituicaoBancaria;
//import br.com.banco.desgraca.domain.TipoTransacao;
//import br.com.banco.desgraca.domain.Transacao;
//import br.com.banco.desgraca.domain.conta.*;
//
//import java.time.LocalDate;
//
//public class BancoDaDesgraca {
//
//    public static void main(String[] args) throws Exception {
//
//        ContaBancaria felipeTonon = new ContaPoupanca(45580,InstituicaoBancaria.BANCO_DO_BRASIL);
//        ContaBancaria airtonTonon = new ContaCorrente(58990,InstituicaoBancaria.BANCO_DO_BRASIL);
//        ContaBancaria camileTonon = new ContaDigital(87415,InstituicaoBancaria.NUBANK);
//
////  TESTES CONTA POUPANÇA
//
////        ContaBancaria fulano = new ContaPoupanca(45580,InstituicaoBancaria.NUBANK); // Verificando conta não permitida no Nubank
//        felipeTonon.depositar(500.0);
//        felipeTonon.sacar(100.0); // Verificando taxa 2%
//        felipeTonon.transferir(100.0,airtonTonon); // Verificando taxa 0,5% para mesma instituição bancária
//        felipeTonon.transferir(100.0,camileTonon); // Verificando taxa 1% para instituição bancária diferente
////        felipeTonon.exibirExtrato(LocalDate.of(2020,07,17),null); // Filtro pela data inicial
////        felipeTonon.exibirExtrato(null,LocalDate.of(2020,07,25)); // Filtro pela data final
//        felipeTonon.exibirExtrato(null,null); // Filtro com as datas vazias
//        felipeTonon.consultarSaldo();
//
//// TESTES CONTA CORRENTE
//
//        airtonTonon.depositar(500.0);
//        airtonTonon.sacar(100.0);
////        airtonTonon.sacar(97.0); // Verificando regra do saque permissível apenas para valores divisíveis por 5
//        airtonTonon.transferir(100.0,felipeTonon); // Sem taxas para mesma instituição bancária
//        airtonTonon.transferir(100.0,camileTonon); // Verificando taxa 1% para instituição bancária diferente
////        airtonTonon.exibirExtrato(LocalDate.of(2020,8,16),null); // Filtro pela data inicial
////        airtonTonon.exibirExtrato(null,LocalDate.of(2020,8,01)); // Filtro pela data final
//        airtonTonon.exibirExtrato(null,null); // Filtro com as datas vazias
//        airtonTonon.consultarSaldo();
//
//// TESTES CONTA DIGITAL
////        ContaBancaria ciclano = new ContaDigital(87415,InstituicaoBancaria.BRADESCO); // regra de conta digital não permitida
////        ContaBancaria beltrano = new ContaDigital(87415,InstituicaoBancaria.BANCO_DO_BRASIL); // regra de conta digital não permitida
////        ContaBancaria fulana = new ContaDigital(87415,InstituicaoBancaria.CAIXA); // regra de conta digital não permitida
//        camileTonon.depositar(500.0);
////        camileTonon.sacar(9.5); // Verificando regra para saque de pelo menos 10 reais
//        camileTonon.sacar(50.0);
//        camileTonon.transferir(80.0,airtonTonon);
////        camileTonon.exibirExtrato(LocalDate.of(2020,9,5),null); // Filtro pela data inicial
////        camileTonon.exibirExtrato(null,LocalDate.of(2020,8,01)); // Filtro pela data final
//        camileTonon.exibirExtrato(null,null); // Filtro com as datas vazias
//        camileTonon.consultarSaldo();
//    }
//}

package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;
import br.com.banco.desgraca.exception.InstituicaoBancariaInvalidaException;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.exception.ValorSaqueInvalidoException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.function.Supplier;

import static br.com.banco.desgraca.domain.InstituicaoBancaria.*;
import static java.text.DecimalFormat.getCurrencyInstance;
import static java.util.Arrays.asList;

public class BancoDaDesgraca {

    private static final Collection<ContaBancaria> CONTAS = new ArrayList();
    private static final Collection<ContaBancaria> CONTAS_CORRENTE = new ArrayList();
    private static final Collection<ContaBancaria> CONTAS_POUPANCA = new ArrayList();
    private static final Collection<ContaBancaria> CONTAS_DIGITAL = new ArrayList();

    public static void main(String[] args) throws Exception {

        System.out.println("\n > Criando contas bancárias...");

        ContaBancaria bbCc = new ContaCorrente(654981, BANCO_DO_BRASIL);
        ContaBancaria bradescoCc = new ContaCorrente(654,BRADESCO);
        ContaBancaria caixaCc = new ContaCorrente(8987,CAIXA);
        ContaBancaria itauCc = new ContaCorrente(98787,ITAU);
        ContaBancaria nubankCc = new ContaCorrente(987987,NUBANK);
        CONTAS_CORRENTE.addAll(asList(bbCc, bradescoCc, caixaCc, itauCc, nubankCc));

        ContaBancaria bbPoupanca = new ContaPoupanca(87897,BANCO_DO_BRASIL);
        ContaBancaria bradescoPoupanca = new ContaPoupanca(987897,BRADESCO);
        ContaBancaria caixaPoupanca = new ContaPoupanca(98787,CAIXA);
        ContaBancaria itauPoupanca = new ContaPoupanca(8778,ITAU);
        CONTAS_POUPANCA.addAll(asList(bbPoupanca, bradescoPoupanca, caixaPoupanca, itauPoupanca));

        ContaBancaria itauDigital = new ContaDigital(8787,ITAU);
        ContaBancaria nubankDigital = new ContaDigital(1535,NUBANK);
        CONTAS_DIGITAL.addAll(asList(itauDigital, nubankDigital));

        CONTAS.addAll(CONTAS_CORRENTE);
        CONTAS.addAll(CONTAS_POUPANCA);
        CONTAS.addAll(CONTAS_DIGITAL);


        ///


        System.out.println("\n > Verificando contas que não podem ser criadas...");
        verificarContasQueNaoPodemSerCriadas();


        ///


        System.out.println("\n > Depositando R$ 1000,00 em cada conta...");
        CONTAS.forEach(conta -> conta.depositar(1000.0));
        // > cc = 1000
        // > digital = 1000
        // > poupanca = 1000


        ///


        System.out.println("\n > Sacando R$ 100,00 de cada conta...");
        CONTAS.forEach(conta -> conta.sacar(100.0));
        // > cc = 900
        // > digital = 900
        // > poupanca = 898


        ///


        System.out.println("\n > Verificando saques com valores menores do que o permitido...");
        verificarSaqueInvalidosMenores();


        ///


        System.out.println("\n > Transferindo R$ 10,00 de cada conta digital para cada conta corrente...");
        CONTAS_DIGITAL.forEach(digital ->
                CONTAS_CORRENTE.forEach(cc ->
                        digital.transferir(10.0, cc)));
        // > cc = 920
        // > digital = 850
        // > poupanca = 898


        ///


        System.out.println("\n > Transferindo R$ 10,00 de cada conta corrente para cada conta poupança...");
        CONTAS_CORRENTE.forEach(cc ->
                CONTAS_POUPANCA.forEach(poupanca ->
                        cc.transferir(10.0, poupanca)));
        // > cc (nubank) = 879.6
        // > cc (outros) = 879.7
        // > digital = 850
        // > poupanca = 948


        ///


        System.out.println("\n > Transferindo R$ 10,00 de cada conta poupança para cada conta digital...");
        CONTAS_POUPANCA.forEach(poupanca ->
                CONTAS_DIGITAL.forEach(digital ->
                        poupanca.transferir(10.0, digital)));
        // > cc (nubank) = 879.6
        // > cc (outros) = 879.7
        // > digital = 890
        // > poupanca (itaú) = 927.85
        // > poupanca (outros) = 927.8


        ///


        System.out.println("\n > Tentando sacar valores maiores do que o saldo...");
        verificarSaquesMaioresDoQueSaldo();


        ///


        System.out.println("\n > Verificando extrato da Conta Digital Nubank no período de 01/01/2021 a 31/01/2021 (devem aparecer 3 registros)...");
        nubankDigital.exibirExtrato(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 31));


        ///


        System.out.println("\n > Verificando o saldo das contas...");
        verificarSaldo(bbCc, 879.70);
        verificarSaldo(bradescoCc, 879.70);
        verificarSaldo(caixaCc, 879.70);
        verificarSaldo(itauCc, 879.70);
        verificarSaldo(nubankCc, 879.60);
        verificarSaldo(bbPoupanca, 927.80);
        verificarSaldo(bradescoPoupanca, 927.80);
        verificarSaldo(caixaPoupanca, 927.80);
        verificarSaldo(itauPoupanca, 927.85);
        verificarSaldo(itauDigital, 890.00);
        verificarSaldo(nubankDigital, 890.00);

        System.out.println("\n\n\nPROGRAMA VALIDADO COM SUCESSO! PARABÉNS! :D\n\n");
    }

    private static void verificarSaldo(ContaBancaria conta, Double saldoEsperado) {

        BigDecimal saldoConta = new BigDecimal(conta.consultarSaldo()).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal saldoReal = new BigDecimal(saldoEsperado).setScale(2, RoundingMode.HALF_EVEN);

        if (saldoConta.compareTo(saldoReal) != 0) {
            throw new RuntimeException("Atenção, saldo incorreto! O saldo da conta " + conta + " deveria ser " + getCurrencyInstance().format(saldoEsperado) +
                    ", mas atualmente é " + getCurrencyInstance().format(conta.consultarSaldo()));
        }
    }

    private static void verificarContasQueNaoPodemSerCriadas() {

        contaInvalida(() -> new ContaDigital(87877,BANCO_DO_BRASIL));
        contaInvalida(() -> new ContaDigital(8798441,BRADESCO));
        contaInvalida(() -> new ContaDigital(5145474,CAIXA));

        contaInvalida(() -> new ContaPoupanca(8947441,NUBANK));
    }

    private static void contaInvalida(Supplier<ContaBancaria> conta) {

        try {
            ContaBancaria cb = conta.get();
            throw new RuntimeException("Atenção! Não deveria ser possível criar a " + cb);
        } catch (InstituicaoBancariaInvalidaException ibie) {
        }
    }

    private static void verificarSaqueInvalidosMenores() {

        saqueInvalido(CONTAS_DIGITAL.iterator().next(), 9.99);

        double valorCc = 0.0;
        while (valorCc < 1 || valorCc % 5 == 0) {
            valorCc = (new Random().nextDouble() * 200) + 1;
        }
        saqueInvalido(CONTAS_CORRENTE.iterator().next(), valorCc);

        saqueInvalido(CONTAS_POUPANCA.iterator().next(), new Random().nextDouble() * 50);
    }

    private static void saqueInvalido(ContaBancaria conta, Double valor) {

        try {
            conta.sacar(valor);
            throw new RuntimeException("Atenção! Não deveria ser possível sacar " + getCurrencyInstance().format(valor) + " de " + conta);
        } catch (ValorSaqueInvalidoException vsie) {
            System.out.println("  X Saque cancelado: " + vsie.getMessage());
        }
    }

    private static void verificarSaquesMaioresDoQueSaldo() {

        CONTAS_CORRENTE.forEach(conta -> saldoInvalido(conta, 880.0));

        CONTAS_DIGITAL.forEach(conta -> saldoInvalido(conta, 890.01));

        CONTAS_POUPANCA.forEach(conta -> saldoInvalido(conta, conta.getInstituicaoBancaria() == ITAU ? 927.86 : 927.81));
    }

    private static void saldoInvalido(ContaBancaria conta, Double valor) {

        try {
            conta.sacar(valor);
            throw new RuntimeException("Atenção! Não deveria ser possível sacar " + getCurrencyInstance().format(valor) + " de " + conta);
        } catch (SaldoInsuficienteException sie) {
            System.out.println("  X Saque cancelado: " + sie.getMessage());
        }
    }
}