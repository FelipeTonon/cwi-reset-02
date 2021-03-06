package br.com.banco.desgraca.exception;

public class ValorSaqueInvalidoException extends IllegalArgumentException{

    public ValorSaqueInvalidoException(String mensagem) {
        super(mensagem);
    }
}
