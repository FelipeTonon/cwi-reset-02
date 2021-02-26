package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;

import java.time.LocalDate;

/**
 *    !!!   ATENÇÃO: ESTA CLASSE NÃO DEVE SER MODIFICADA   !!!
 *
 * Contrato para especificação de contas bancárias.
 *   A gestão do saldo da br.com.banco.desgraca.domain.conta e das transações, além das taxas, é responsabilidade de cada implementação.
 */
public interface ContaBancaria {

    /**
     * Retorna a instituição bancária à qual a br.com.banco.desgraca.domain.conta pertence.
     *
     * @return A instituição bancária.
     */
    InstituicaoBancaria getInstituicaoBancaria();


    /**
     * Consulta o saldo atual da br.com.banco.desgraca.domain.conta bancária.
     *
     */
    void consultarSaldo();


    /**
     * Deposita o valor informado na br.com.banco.desgraca.domain.conta e registra uma transação de entrada.
     *   Atentar para o cálculo das taxas.
     *
     * @param valor O valor a ser depositado na br.com.banco.desgraca.domain.conta.
     */
    void depositar(Double valor);


    /**
     * Saca o valor informado da br.com.banco.desgraca.domain.conta, se a br.com.banco.desgraca.domain.conta possuir saldo suficiente, e registra uma transação de saída.
     *   Atentar para o cálculo das taxas.
     *
     * @param valor O valor a ser sacado da br.com.banco.desgraca.domain.conta.
     */
    void sacar(Double valor);


    /**
     * Efetua a transferência de um valor da br.com.banco.desgraca.domain.conta atual para a br.com.banco.desgraca.domain.conta de destino,
     *      registrando uma transação de saída na br.com.banco.desgraca.domain.conta de origem e uma de entrada na br.com.banco.desgraca.domain.conta de destino.
     *   A transferência só pode ser feita se houver saldo suficente na br.com.banco.desgraca.domain.conta.
     *
     * @param valor O valor a ser transferido da br.com.banco.desgraca.domain.conta atual para a br.com.banco.desgraca.domain.conta de destino.
     * @param contaDestino A br.com.banco.desgraca.domain.conta que receberá o valor.
     */
    void transferir(Double valor, ContaBancaria contaDestino);


    /**
     * Exibe o extrato da br.com.banco.desgraca.domain.conta para o período informado.
     *   Se não for passada a data de início, deve filtrar somente pela data de fim.
     *   Se não for passada a data de fim, deve filtrar somente pela data de início.
     *   Se não for passada nenhuma data, deve exibir todos os registros.
     *
     * É exibido o símobolo "+" para indicar entrada na br.com.banco.desgraca.domain.conta e "-" para indicar saída da br.com.banco.desgraca.domain.conta. Ex. de extrato:
     *
     * <code>
     *     ----- EXTRATO CONTA DIGITAL NUBANK 12345
     *     +   R$ 100,00   01/07/2020
     *     +    R$ 50,00   06/07/2020
     *     -    R$ 10,00   11/04/2020
     *     -----
     * </code>
     *
     * @param inicio Data de início para filtro. Pode ser null.
     * @param fim Data de fim para filtro. Pode ser null.
     */
    void exibirExtrato(LocalDate inicio, LocalDate fim);

}