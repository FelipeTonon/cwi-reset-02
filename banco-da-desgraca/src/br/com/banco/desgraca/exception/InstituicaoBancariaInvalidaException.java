package br.com.banco.desgraca.exception;

public class InstituicaoBancariaInvalidaException extends IllegalArgumentException{

    public InstituicaoBancariaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
