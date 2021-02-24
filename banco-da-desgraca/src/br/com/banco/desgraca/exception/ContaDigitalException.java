package br.com.banco.desgraca.exception;

public class ContaDigitalException extends IllegalArgumentException{

    public ContaDigitalException(String mensagem) {
        super(mensagem);
    }
}
