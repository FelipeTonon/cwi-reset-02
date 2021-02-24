package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.conta.*;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {

        ContaBancaria felipeTonon = new ContaCorrente(45580,InstituicaoBancaria.ITAU);
        ContaBancaria airtonTonon = new ContaCorrente(58990,InstituicaoBancaria.BRADESCO);
        ContaBancaria surfistaPrateado = new ContaPoupanca(87415,InstituicaoBancaria.CAIXA);


        surfistaPrateado.depositar(500.0);
        surfistaPrateado.consultarSaldo();
        surfistaPrateado.transferir(495.3,felipeTonon);
        surfistaPrateado.consultarSaldo();


    }
}