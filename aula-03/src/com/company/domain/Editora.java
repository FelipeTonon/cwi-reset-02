package com.company.domain;

import com.company.exception.ExceptionEditora;

public class Editora {
    private String nome;
    private String localizacao;

    public Editora(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao; // Poderia ser uma classe, utilizado como String para realização do exercício
    }

    public void exibir(){
        defineNome();
    }

    private void defineNome(){
        if(this.nome.equals("DC Comics")){
//          throw new RuntimeException("A editora DC Comics não é permitida. Entre com outra editora.");
            throw new ExceptionEditora("A editora DC Comics não é permitida. Entre com outra editora.");
        } else {
            this.nome = nome;
            System.out.println("Editora: " + this.nome);
        }
    }
}
