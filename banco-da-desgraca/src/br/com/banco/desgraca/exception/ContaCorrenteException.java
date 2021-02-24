package br.com.banco.desgraca.exception;

public class ContaCorrenteException extends IllegalArgumentException{

    public ContaCorrenteException(String mensagem) {
        super(mensagem);
    }
}
