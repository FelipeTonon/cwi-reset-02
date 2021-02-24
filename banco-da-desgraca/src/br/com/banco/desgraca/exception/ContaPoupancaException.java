package br.com.banco.desgraca.exception;

public class ContaPoupancaException extends IllegalArgumentException{

    public ContaPoupancaException(String mensagem) {
        super(mensagem);
    }
}
