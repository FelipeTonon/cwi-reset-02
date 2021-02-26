package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.conta.*;

import java.time.LocalDate;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {

        ContaBancaria felipeTonon = new ContaPoupanca(45580,InstituicaoBancaria.BANCO_DO_BRASIL);
        ContaBancaria airtonTonon = new ContaCorrente(58990,InstituicaoBancaria.BANCO_DO_BRASIL);
        ContaBancaria camileTonon = new ContaDigital(87415,InstituicaoBancaria.NUBANK);

//  TESTES CONTA POUPANÇA

//        ContaBancaria fulano = new ContaPoupanca(45580,InstituicaoBancaria.NUBANK); // Verificando conta não permitida no Nubank
        felipeTonon.depositar(500.0);
        felipeTonon.sacar(100.0); // Verificando taxa 2%
        felipeTonon.transferir(100.0,airtonTonon); // Verificando taxa 0,5% para mesma instituição bancária
        felipeTonon.transferir(100.0,camileTonon); // Verificando taxa 1% para instituição bancária diferente
//        felipeTonon.exibirExtrato(LocalDate.of(2020,07,17),null); // Filtro pela data inicial
//        felipeTonon.exibirExtrato(null,LocalDate.of(2020,07,25)); // Filtro pela data final
        felipeTonon.exibirExtrato(null,null); // Filtro com as datas vazias
        felipeTonon.consultarSaldo();

// TESTES CONTA CORRENTE

        airtonTonon.depositar(500.0);
        airtonTonon.sacar(100.0);
//        airtonTonon.sacar(97.0); // Verificando regra do saque permissível apenas para valores divisíveis por 5
        airtonTonon.transferir(100.0,felipeTonon); // Sem taxas para mesma instituição bancária
        airtonTonon.transferir(100.0,camileTonon); // Verificando taxa 1% para instituição bancária diferente
//        airtonTonon.exibirExtrato(LocalDate.of(2020,8,16),null); // Filtro pela data inicial
//        airtonTonon.exibirExtrato(null,LocalDate.of(2020,8,01)); // Filtro pela data final
        airtonTonon.exibirExtrato(null,null); // Filtro com as datas vazias
        airtonTonon.consultarSaldo();

// TESTES CONTA DIGITAL
//        ContaBancaria ciclano = new ContaDigital(87415,InstituicaoBancaria.BRADESCO); // regra de conta digital não permitida
//        ContaBancaria beltrano = new ContaDigital(87415,InstituicaoBancaria.BANCO_DO_BRASIL); // regra de conta digital não permitida
//        ContaBancaria fulana = new ContaDigital(87415,InstituicaoBancaria.CAIXA); // regra de conta digital não permitida
        camileTonon.depositar(500.0);
//        camileTonon.sacar(9.5); // Verificando regra para saque de pelo menos 10 reais
        camileTonon.sacar(50.0);
        camileTonon.transferir(80.0,airtonTonon);
//        camileTonon.exibirExtrato(LocalDate.of(2020,9,5),null); // Filtro pela data inicial
//        camileTonon.exibirExtrato(null,LocalDate.of(2020,8,01)); // Filtro pela data final
        camileTonon.exibirExtrato(null,null); // Filtro com as datas vazias
        camileTonon.consultarSaldo();
    }
}